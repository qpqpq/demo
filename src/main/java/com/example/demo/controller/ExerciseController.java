package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.ExerciseBiz;
import com.example.demo.bo.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author pangkun
 * @date 2019/5/8 上午8:49
 */
@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseBiz exerciseBiz;

    //                 锻炼
    //                         保存   /exercise/save              Exercise
    //                         获取   /exercise/get               {timeType:012}    [{type:ctime},{}...]
    @Validator
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody Exercise exercise) {
        try {
            System.out.println(JSON.toJSONString(exercise));
            exerciseBiz.saveExercise(exercise);
            return new Date() + " 上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    @Validator
    @PostMapping("/get")
    public String get(@RequestHeader Map<String, String> header, @RequestBody Map<String, String> map) {
        String timeType = map.get("timeType");
        List<Exercise> list = exerciseBiz.selectByCondition(header.get("token").substring(0, 11), timeType);
        JSONArray jsonArray = new JSONArray();
        for(Exercise exercise:list){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put(exercise.getType(), exercise.getCtime());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}

