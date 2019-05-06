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
