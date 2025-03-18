package cn.liulingfengyu.datamigration.service.impl;

import cn.liulingfengyu.datamigration.entity.MigrationDataRecord;
import cn.liulingfengyu.datamigration.mapper.MigrationDataRecordMapper;
import cn.liulingfengyu.datamigration.service.IMigrationDataRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据迁移记录 服务实现类
 *
 * @author 刘凌枫羽工作室
 */
@Service
public class MigrationDataRecordServiceImpl extends ServiceImpl<MigrationDataRecordMapper, MigrationDataRecord> implements IMigrationDataRecordService {

}
