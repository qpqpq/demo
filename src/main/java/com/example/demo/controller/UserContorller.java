package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.biz.RegisterBiz;
import com.example.demo.bo.User;
import com.example.demo.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @author pangkun
 * @date 2019/2/19 下午3:03
 */
@RequestMapping("/user")
@RestController
public class UserContorller {

    @Autowired
    private RegisterBiz registerBiz;

    @RequestMapping("/111")
    public String ss() {
        return "111";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        registerBiz.registerUser(user);
        return new Date() + " 注册成功";
    }

    @PostMapping("/id")
    public String modify(@RequestBody Map<String,String> map) {
        User user = registerBiz.selectById(map.get("id"));
        if (user != null) {
            return new Date() + "查找成功"+JSON.toJSONString(user);
        }else{
            return "查找失败";
        }
    }

}
