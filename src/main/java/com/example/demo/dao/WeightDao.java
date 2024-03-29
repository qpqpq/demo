package com.example.demo.dao;

import com.example.demo.bo.Sugar;
import com.example.demo.bo.Weight;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午10:29
 */
@Mapper
@Repository("weightDao")
public interface WeightDao {

    int insertWeight(Weight weight);

    List<Weight> selectById(String phone);

}
