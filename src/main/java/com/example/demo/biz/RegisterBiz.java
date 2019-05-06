package com.example.demo.biz;

import com.example.demo.bo.User;
import com.example.demo.service.RegisterService;
import com.example.demo.util.SHA256;
import com.example.demo.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:43
 */
@Component
public class RegisterBiz {

    @Autowired
    private RegisterService registerService;

    public int registerUser(User user) {
//        user.setId(UUID.getUUID());
        user.setName(user.getName());
        user.setPassword(SHA256.getSHA(user.getPassword()));
        return registerService.insertUser(user);
    }


    public User selectById(String id) {
        try {
            return registerService.selectUserById(id);
        }catch (Exception e){
            return null;
        }
    }
}
