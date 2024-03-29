package com.example.demo.dao;

import com.example.demo.bo.Pressure;
import com.example.demo.bo.Sugar;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:17
 */
@Mapper
@Repository("sugarDao")
public interface SugarDao {

    int insertSugar(Sugar sugar);

    List<Sugar> selectById(String phone);

}
