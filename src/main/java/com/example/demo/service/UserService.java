package com.example.demo.service;

import com.example.demo.bo.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:45
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int insertUser(User user){
        return userDao.insertUser(user);
    }

    public User selectUserById(String id){
        return userDao.selectById(id);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
