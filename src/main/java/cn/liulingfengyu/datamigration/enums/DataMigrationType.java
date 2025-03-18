package cn.liulingfengyu.datamigration.enums;

import cn.hutool.extra.spring.SpringUtil;
import cn.liulingfengyu.datamigration.template.DataImportTemplate;
import cn.liulingfengyu.datamigration.template.UserInfoImportProcess;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 数据迁移类型枚举
 *
 * @author 刘凌枫羽工作室
 */
@Getter
@AllArgsConstructor
public enum DataMigrationType {
    USER_INFO(1, "用户信息", SpringUtil.getBean(UserInfoImportProcess.class));

    private final int code;
    private final String msg;
    private final DataImportTemplate dataImportTemplate;

}