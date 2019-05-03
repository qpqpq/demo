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
public interface RegisterDao {


    /**
     * @param user
     * @return
     */
//    @Insert("insert into user values(#{id},#{picture},#{name},#{password},#{birthday},#{idcard},#{family},#{postcode},#{phone}," +
//            "#{state},#{height},#{weight},#{xiyan},#{yinjiu},#{yinshi});")
//    @Insert("create table #{id}(id varchar(64))")
    int insertUser(User user);

    @Update("create table ${name} (id datetime)")
    void createUserTable(@Param("name") String name);

    @Insert("insert into a1 values(#{date})")
    void insert(Date date);

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
