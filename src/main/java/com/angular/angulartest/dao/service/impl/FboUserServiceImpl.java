package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.FboUser;
import com.angular.angulartest.dao.mapper.FboUserMapper;
import com.angular.angulartest.dao.service.FboUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-11-18
 */
@Service
public class FboUserServiceImpl extends ServiceImpl<FboUserMapper, FboUser> implements FboUserService {

}
