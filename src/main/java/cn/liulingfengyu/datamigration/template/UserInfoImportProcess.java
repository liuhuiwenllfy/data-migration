package cn.liulingfengyu.datamigration.template;

import cn.liulingfengyu.datamigration.entity.UserInfo;
import cn.liulingfengyu.datamigration.mapper.DataOutputMapper;
import cn.liulingfengyu.datamigration.template.load.UserInfoLoadData;
import com.baomidou.dynamic.datasource.annotation.DS;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户信息导入
 *
 * @author 刘凌枫羽工作室
 */
@Component
@Slf4j
public class UserInfoImportProcess implements DataImportTemplate {

    @Resource
    private DataOutputMapper dataOutputMapper;

    @Autowired
    private UserInfoLoadData userInfoLoadData;

    /**
     * 获取源数据
     */
    @Override
    @DS("output")
    public void fetchData() {
        log.info("【用户信息】源数据获取~");
        List<UserInfo> userInfoList;
        int page = 1;
        int limit = 10000;
        int count = dataOutputMapper.getCount();
        while (count > 0) {
            userInfoList = dataOutputMapper.getList(page, limit);
            transformData(userInfoList);
            count -= limit;
            page += 1;
        }
    }

    /**
     * 数据转换
     */
    private void transformData(List<UserInfo> userInfoList) {
        log.info("【用户信息】进行转化~");
        userInfoLoadData.removeData();
        userInfoLoadData.loadData(userInfoList);
    }
}
