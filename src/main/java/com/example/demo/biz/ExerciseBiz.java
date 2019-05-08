package com.example.demo.biz;

import com.example.demo.bo.Exercise;
import com.example.demo.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
        List<Exercise> exercises = exerciseService.selectById(phone);
        exercises.sort(new Comparator<Exercise>() {
            @Override
            public int compare(Exercise o1, Exercise o2) {
                return Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime()));
            }
        });
        long l = System.currentTimeMillis();
        List<Exercise> list = new ArrayList<>();
        for (Exercise exercise : exercises) {
            list.add(exercise);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(System.currentTimeMillis())));
        System.out.println(format);
        switch (type) {
            case "0":
                for (Exercise exercise : list) {
                    if (Long.valueOf(date2TimeStamp(exercise.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30) {
                        exercises.remove(exercise);
                    }
                }
                break;
            case "1":
                for (Exercise exercise : list) {
                    if (Long.valueOf(date2TimeStamp(exercise.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 3) {
                        exercises.remove(exercise);
                    }
                }
                break;
            case "2":
                for (Exercise exercise : list) {
                    if (Long.valueOf(date2TimeStamp(exercise.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 12) {
                        exercises.remove(exercise);
                    }
                }
                break;
            default:
                break;
        }
        return exercises;
    }


    public String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
