package com.example.demo.dao;

import com.example.demo.bo.Pressure;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午2:18
 */
@Mapper
@Repository("pressureDao")
public interface PressureDao {

    int insertPressure(Pressure pressure);

    List<Pressure> selectById(String id);

}
