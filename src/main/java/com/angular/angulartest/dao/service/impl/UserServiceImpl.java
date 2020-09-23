package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.User;
import com.angular.angulartest.dao.mapper.UserMapper;
import com.angular.angulartest.dao.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * angular用户表 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
