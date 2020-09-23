package com.angular.angulartest.dao.service.impl;

import com.angular.angulartest.dao.entity.Menu;
import com.angular.angulartest.dao.mapper.MenuMapper;
import com.angular.angulartest.dao.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * angular菜单 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
