package com.example.demo.service;

import com.example.demo.bo.User;
import com.example.demo.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:45
 */
@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public int insertUser(User user){
        return registerDao.insertUser(user);
    }

    public User selectUserById(String id){
        return registerDao.selectById(id);
    }
}
