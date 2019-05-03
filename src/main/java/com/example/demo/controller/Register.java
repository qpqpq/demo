package com.example.demo.controller;

import com.example.demo.biz.RegisterBiz;
import com.example.demo.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author pangkun
 * @date 2019/2/19 下午3:03
 */
@RequestMapping("")
@RestController
public class Register {

    @Autowired
    private RegisterBiz registerBiz;

    @Autowired
    RegisterDao registerDao;
    @RequestMapping("/122")
    public String s(){
        return "122";
    }


    @RequestMapping("/register")
    public String register(@RequestParam("user") String user){
//        String user = httpServletRequest.getParameter("user");
//        User user1 = JSON.parseObject(user, User.class);
//        int i = registerBiz.registerUser(user1);
//        registerBiz.f(user);
        registerDao.insert(new Date(1550981645050L));
//        registerDao.createUserTable("a1");
        return System.currentTimeMillis()+" 注册成功";

    }
}
