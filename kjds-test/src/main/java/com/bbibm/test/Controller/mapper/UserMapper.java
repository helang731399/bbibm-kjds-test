package com.bbibm.test.Controller.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbibm.test.Controller.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *@描述：用户测试
 *@项目：
 *@公司：软江科技
 *@作者：helang
 *@时间：2020-05-12 14:20:54
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
