package com.example.demo.dao;

import com.example.demo.bo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:50
 */
@Mapper
@Repository("registerDao")
public interface UserDao {


    int insertUser(User user);

    User selectById(String id);

    void updateUser(User user);


}