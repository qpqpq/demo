package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.UserBiz;
import com.example.demo.bo.User;
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
    private UserBiz userBiz;

    //token:phone+sha256(phone+password)
    //                 用户信息 功能   url                         param             返回格式
    //                         注册   /user/register              User
    // ]                       请求   /user/info                                    User
    //                         更新   /user/info/update           User
    //                 血压
    //                         保存   /pressure/save              Pressure
    //                         获取   /pressure/get               {timeType:012}    {high:[{num,time},{},{}...],low:[{},{},{}...]}
    //                 血糖
    //                         保存   /sugar/save                 Sugar
    //                         获取   /sugar/get                  {timeType:012}    [{num,time},{num,time}...]
    //                 体重
    //                         保存   /weight/save                Weight            {BMI:xxx}
    //                         获取   /weight/get                 {timeType:012}    [{num,time},{}...]
    //                 锻炼
    //                         保存   /exercise/save              Exercise
    //                         获取   /exercise/get               {timeType:012}    [{type:ctime},{}...]
    //                 用药
    //                         保存   /yao/save                   Yao
    //                         获取   /yao/get                                      [{Yao},{}...]
    //
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        try {
            System.out.println(JSON.toJSONString(user));
            userBiz.registerUser(user);
            return new Date() + " 注册成功";
        }catch (Exception e){
            return "{}";
        }
    }

    @Validator
    @PostMapping("/info")
    public String login(@RequestHeader Map<String, String> header) {
        User user = userBiz.selectById(header.get("token").substring(0, 11));
        if(user!=null){
            user.setPassword("");
            return JSON.toJSONString(user);
        }else{
            return "{}";
        }
    }

    @Validator
    @PostMapping("/info/update")
    public String update(@RequestHeader Map<String, String> header,@RequestBody User user) {
        try {
            System.out.println(JSON.toJSONString(user));
            userBiz.updateUser(user);
            return new Date() + " 修改成功";
        }catch (Exception e){
            return "{}";
        }
    }

}
