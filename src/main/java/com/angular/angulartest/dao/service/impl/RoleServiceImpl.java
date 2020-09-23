package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.Role;
import com.angular.angulartest.dao.mapper.RoleMapper;
import com.angular.angulartest.dao.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * angualr角色表 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
