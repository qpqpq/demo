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

//{
//        "id": "setId",
//        "picture": "setPicture",
//        "name": "setName",
//        "password": "setPassword",
//        "birthday": "setBirthday",
//        "idcard": "setIdcard",
//        "family": "setFamily",
//        "postcode": "setPostcode",
//        "phone": "setPhone",
//        "state": "setState",
//        "height": "setHeight",
//        "weight": "setWeight",
//        "xiyan": "setXiyan",
//        "yinshi": "setYinshi",
//        "yinjiu": "setYinjiu"
//        }
//localhost:8080/register?user={"birthday":"setBirthday","family":"setFamily","height":"setHeight","id":"setId","idcard":"setIdcard","name":"setName","password":"setPassword","phone":"setPhone","picture":"setPicture","postcode":"setPostcode","state":"setState","weight":"setWeight","xiyan":"setXiyan","yinshi":"setYinshi","yinjiu":"setYinjiu"}
