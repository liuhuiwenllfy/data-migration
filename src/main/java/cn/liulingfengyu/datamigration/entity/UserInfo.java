package cn.liulingfengyu.datamigration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author 刘凌枫羽工作室
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("d_user_info")
public class UserInfo extends Model<UserInfo> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
