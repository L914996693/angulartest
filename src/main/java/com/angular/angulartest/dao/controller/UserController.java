package com.angular.angulartest.dao.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * angular用户表 前端控制器
 * </p>
 *
 * @author liuwei
 * @since 2020-09-22
 */
@RestController
@RequestMapping("user")
public class UserController {


    @PostMapping("userlist")
    public JSONObject userlist(){
        JSONObject user_json = new JSONObject();
        return null;
    }
}
