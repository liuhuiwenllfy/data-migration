package cn.liulingfengyu.datamigration.service.impl;

import cn.liulingfengyu.datamigration.entity.UserInfo;
import cn.liulingfengyu.datamigration.mapper.UserInfoMapper;
import cn.liulingfengyu.datamigration.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户信息 服务实现类
 *
 * @author 刘凌枫羽工作室
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
}
