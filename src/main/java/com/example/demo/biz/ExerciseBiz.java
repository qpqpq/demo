package com.example.demo.biz;

import com.example.demo.bo.Exercise;
import com.example.demo.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:27
 */
@Component
public class ExerciseBiz {

    @Autowired
    private ExerciseService exerciseService;

    public void saveExercise(Exercise exercise) {
        exerciseService.insertExercise(exercise);
    }

    public List<Exercise> selectByCondition(String phone, String type) {
        List<Exercise> weights = exerciseService.selectById(phone);
        return null;
    }
}
