package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.ExerciseBiz;
import com.example.demo.bo.Exercise;
import com.example.demo.util.Constant;
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
    @CrossOrigin
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody Exercise exercise) {
        try {
            System.out.println(JSON.toJSONString(exercise));
            String phone = header.get("token").substring(0, 11);
            exercise.setPhone(phone);
            exerciseBiz.saveExercise(exercise);
            return Constant.getSuccess(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }

    @Validator
    @CrossOrigin
    @PostMapping("/get")
    public String get(@RequestHeader Map<String, String> header, @RequestBody Map<String, String> map) {
        try {
            String timeType = map.get("timeType");
            String month = map.get("month");
            List<Exercise> list = exerciseBiz.selectByCondition(header.get("token").substring(0, 11), timeType==null?"2":timeType,month);
            JSONArray jsonArray = new JSONArray();
            for (Exercise exercise : list) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ctime", exercise.getCtime());
                jsonObject.put("type", exercise.getType());
                jsonArray.add(jsonObject);
            }
            return Constant.getSuccess(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }
}

