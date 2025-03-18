package cn.liulingfengyu.datamigration.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 迁移记录
 *
 * @author 刘凌枫羽工作室
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("migration_data_record")
public class MigrationDataRecord extends Model<MigrationDataRecord> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private Integer type;

    private Boolean isSync;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
