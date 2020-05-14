package com.bbibm.test.Controller.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bbibm.test.Controller.entity.User;
import com.bbibm.test.Controller.mapper.UserMapper;
import com.bbibm.test.Controller.service.UserService;
import org.springframework.stereotype.Service;

/**
 *@描述：用户测试
 *@项目：
 *@公司：软江科技
 *@作者：helang
 *@时间：2020-05-12 14:20:54
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
