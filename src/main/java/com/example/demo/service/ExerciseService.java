package com.example.demo.service;

import com.example.demo.bo.Exercise;
import com.example.demo.dao.ExerciseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:25
 */
@Service
public class ExerciseService {

    @Autowired
    private ExerciseDao exerciseDao;

    public void insertExercise(Exercise exercise) {
        exerciseDao.insertExercise(exercise);
    }

    public List<Exercise> selectById(String phone) {
        return exerciseDao.selectById(phone);
    }


}
