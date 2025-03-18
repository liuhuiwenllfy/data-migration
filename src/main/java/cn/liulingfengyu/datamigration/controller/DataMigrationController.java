package cn.liulingfengyu.datamigration.controller;

import cn.liulingfengyu.datamigration.service.DataMigrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据迁移
 *
 * @author 刘凌枫羽工作室
 */
@RestController
@RequestMapping("/dataMigration")
@AllArgsConstructor
public class DataMigrationController {

    private final DataMigrationService dataMigrationService;

    /**
     * 数据迁移
     *
     * @return {@link Boolean}
     */
    @GetMapping("migration")
    public Boolean migration() {
        dataMigrationService.migration();
        return true;
    }
}
