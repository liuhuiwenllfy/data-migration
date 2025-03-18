package cn.liulingfengyu.datamigration.mapper;

import cn.liulingfengyu.datamigration.entity.UserInfo;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 数据导出
 *
 * @author Reid
 * @since 2024/7/13
 **/
@DS("output")
public interface DataOutputMapper extends BaseMapper<UserInfo> {

    int getCount();

    List<UserInfo> getList(int page, int limit);
}
