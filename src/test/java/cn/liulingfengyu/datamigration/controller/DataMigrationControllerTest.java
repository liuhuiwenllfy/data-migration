package cn.liulingfengyu.datamigration.controller;

import cn.liulingfengyu.datamigration.service.DataMigrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataMigrationControllerTest {

    @Autowired
    private DataMigrationService dataMigrationService;

    @Test
    void migration() {
        dataMigrationService.migration();
    }
}