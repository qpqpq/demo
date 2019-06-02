package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.WeightBiz;
import com.example.demo.bo.User;
import com.example.demo.bo.Weight;
import com.example.demo.dao.UserDao;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:24
 */
@RestController
@RequestMapping("/weight")
public class WeightController {

    @Autowired
    private WeightBiz weightBiz;

    @Autowired
    private UserDao userDao;

    @Validator
    @CrossOrigin
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody Weight weight) {
        try {
            System.out.println(JSON.toJSONString(weight));
            String phone = header.get("token").substring(0, 11);
            weight.setPhone(phone);
            weightBiz.saveWeight(weight);
            User user = userDao.selectById(header.get("token").substring(0, 11));
            User user1=new User();
            user1.setWeight(weight.getNum());
            userDao.updateUser(user1);
            String height = user.getHeight();
            if (height != null) {
                Double num = Double.valueOf(weight.getNum());
                double v = num / Double.valueOf(height) / Double.valueOf(height) * 10000;
                return Constant.getSuccess(v);
            }
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
            String month=map.get("month");
            List<Weight> list = weightBiz.selectByCondition(header.get("token").substring(0, 11), timeType,month);
            JSONArray jsonArray = new JSONArray();
            for (Weight weight : list) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("time", weight.getTime());
                jsonObject.put("num", weight.getNum());
                jsonArray.add(jsonObject);
            }
            return Constant.getSuccess(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }
}
