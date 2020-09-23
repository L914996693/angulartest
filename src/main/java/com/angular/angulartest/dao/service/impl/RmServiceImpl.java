package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.Rm;
import com.angular.angulartest.dao.mapper.RmMapper;
import com.angular.angulartest.dao.service.RmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * angular角色&菜单表 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Service
public class RmServiceImpl extends ServiceImpl<RmMapper, Rm> implements RmService {

}
