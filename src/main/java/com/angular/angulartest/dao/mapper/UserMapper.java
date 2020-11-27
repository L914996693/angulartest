package com.angular.angulartest.dao.mapper;

import com.angular.angulartest.dao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * angular用户表 Mapper 接口
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    int usercount();
}
