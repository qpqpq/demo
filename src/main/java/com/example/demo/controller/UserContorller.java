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

    @Autowired
    RegisterDao registerDao;
    @RequestMapping("/122")
    public String s(){
        return "122";
    }

    @RequestMapping("/111")
    public String ss(){
        return "111";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
//        String user = httpServletRequest.getParameter("user");
//        User user1 = JSON.parseObject(user, User.class);
//        int i = registerBiz.registerUser(user1);
//        registerBiz.f(user);
//        registerDao.insert(new Date(1550981645050L));
//        registerDao.createUserTable("a1");
        registerBiz.registerUser(user);
        return new Date()+" 注册成功";

    }
}
