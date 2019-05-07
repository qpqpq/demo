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
    //                 体重
    //                         保存   /weight/save                Weight            {BMI:xxx}
    //                         获取   /weight/get                 {timeType:012}    [{num,time},{}...]

    int insertWeight(Weight weight);

    List<Weight> selectById(String phone);

}
