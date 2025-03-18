package cn.liulingfengyu.datamigration.template.load;

import cn.liulingfengyu.datamigration.entity.UserInfo;
import cn.liulingfengyu.datamigration.service.IUserInfoService;
import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@DS("master")
public class UserInfoLoadData {

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 加载到目标数据库
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeData() {
        log.info("【用户信息】删除用户信息~");
        userInfoService.remove(null);
    }

    /**
     * 加载到目标数据库
     */
    @Transactional(rollbackFor = Exception.class)
    public void loadData(List<UserInfo> userInfoList) {
        log.info("【用户信息】转化后加载到目标数据库~");
        if (!userInfoList.isEmpty()) {
            userInfoService.saveBatch(userInfoList);
        }
    }
}
