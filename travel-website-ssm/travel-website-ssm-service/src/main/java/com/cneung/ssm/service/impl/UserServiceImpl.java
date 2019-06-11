package com.cneung.ssm.service.impl;

import com.cneung.ssm.exception.UserExistsException;
import com.cneung.ssm.mapper.UserMapper;
import com.cneung.ssm.service.UserService;
import com.cneung.ssm.pojo.User;
import com.cneung.ssm.utils.Md5Util;
import com.cneung.ssm.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author zhangxl98
 * @Date 6/11/19 10:33 AM
 * @OS Ubuntu 18.04 LTS
 * @Device ASRock-Desktop
 * @Version V1.0.0
 * @Description 用户服务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) throws Exception {

        // 判断用户是否已注册
        if ((userMapper.queryUserByUserName(user.getUsername())) != null) {
            throw new UserExistsException("用户名已存在");
        }


        // 设置激活状态为未激活
        user.setStatus("0");
        // 设置激活码
        user.setCode(UuidUtil.getUuid());
        // 密码加密
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        // 注册用户，持久化到数据库
        userMapper.addUser(user);
    }
}
