package com.angular.angulartest.dao.controller;


import com.angular.angulartest.controller.angularController;
import com.angular.angulartest.util.menutools.treemenu;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * angular菜单 前端控制器
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/anmenu")
public class MenuController {
    @Autowired
    private treemenu tremenu;

    //系统级日志
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MenuController.class);
    @PostMapping("menulist")
    public JSONObject menulist(){
        JSONObject menu_json = new JSONObject();
        menu_json.put("result","true");
        menu_json.put("message","");
        menu_json.put("data",tremenu.menuuitl());
        logger.info("------------------菜单调用成功"+menu_json+"-------------");
        return menu_json;
    }
}
