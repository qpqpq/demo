package com.example.demo.biz;

import com.alibaba.fastjson.JSON;
import com.example.demo.bo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.SHA256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:43
 */
@Component
public class UserBiz {

    @Autowired
    private UserService userService;

    public int registerUser(User user) {
        user.setPassword(SHA256.getSHA(user.getName()+user.getPassword()));
        System.out.println(JSON.toJSONString(user));
        return userService.insertUser(user);
    }


    public User selectById(String id) {
        try {
            return userService.selectUserById(id);
        }catch (Exception e){
            return null;
        }
    }

    public void updateUser(User user){
        userService.updateUser(user);
    }
}
