package com.angular.angulartest.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.angular.angulartest.util.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/wx")
public class WxController {

    @PostMapping(value = "test")
    public ResponseResult test(@RequestBody JSONObject json){
        JSONObject json_data = new JSONObject(true);
        JSONObject json_de = new JSONObject(true);
        json_de.put("acc","100");
        json_de.put("proname","商品1");
        json_de.put("hname1","标题1");
        json_de.put("hname2","标题2");

        json_data.put("data",json_de);
        System.out.println("测试微信连通性");
        System.out.println(json);
        System.out.println(json_data);
        return new ResponseResult(true,200,"",json_de);
    }

    @PostMapping(value = "applicationre")
    public List applicationre(){
        List<JSONObject> json_list = new LinkedList<>();
        for(int i=0;i<=3;i++){
            JSONObject json = new JSONObject(true);
            json.put("id",i);
            json.put("acc",i+"00");
            json.put("proname","商品"+i);
            json.put("hname1","标题1");
            json.put("hname2","标题2");

            json_list.add(json);
        }

        return json_list;
    }
}
