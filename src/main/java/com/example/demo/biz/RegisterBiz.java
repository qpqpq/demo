package com.example.demo.biz;

import com.example.demo.bo.User;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:43
 */
@Component
public class RegisterBiz {

    @Autowired
    private RegisterService registerService;

    public int registerUser(User user){
        return registerService.registerUser(user);
    }

    public void f(String name){
        registerService.createTable(name);
    }

}
