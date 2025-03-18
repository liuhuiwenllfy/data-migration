package cn.liulingfengyu.datamigration.service.impl;

import cn.liulingfengyu.datamigration.entity.MigrationDataRecord;
import cn.liulingfengyu.datamigration.enums.DataMigrationType;
import cn.liulingfengyu.datamigration.service.DataMigrationService;
import cn.liulingfengyu.datamigration.service.IMigrationDataRecordService;
import cn.liulingfengyu.datamigration.template.DataImportTemplate;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 数据迁移
 *
 * @author 刘凌枫羽工作室
 */
@Service
public class DataMigrationServiceImpl implements DataMigrationService {

    @Resource
    private IMigrationDataRecordService scMigrationDataRecordService;

    @Override
    @Async
    public void migration() {
        DataMigrationType[] values = DataMigrationType.values();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<?>> futures = new ArrayList<>();
        for (DataMigrationType dataMigrationType : values) {
            Future<?> future = executor.submit(() -> {
                Long count = scMigrationDataRecordService
                        .lambdaQuery()
                        .eq(MigrationDataRecord::getType, dataMigrationType.getCode())
                        .count();
                DataImportTemplate dataImportTemplate = dataMigrationType.getDataImportTemplate();
                if (count == 0) {
                    dataImportTemplate.fetchData();
                    flagSynced(dataMigrationType.getCode());
                }
            });
            futures.add(future);
        }
        try {
            // 等待所有任务完成，并收集结果
            for (Future<?> future : futures) {
                future.get(); // 这会阻塞直到任务完成
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭线程池
            executor.shutdown();
        }
    }

    private void flagSynced(Integer type) {
        MigrationDataRecord record = new MigrationDataRecord();
        record.setIsSync(true);
        record.setType(type);
        scMigrationDataRecordService.save(record);
    }
}
