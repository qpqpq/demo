package com.example.demo.dao;

import com.example.demo.bo.Exercise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午10:29
 */
@Mapper
@Repository("exerciseDao")
public interface ExerciseDao {

    int insertExercise(Exercise exercise);

    List<Exercise> selectById(String phone);

}
