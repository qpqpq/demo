package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.SugarBiz;
import com.example.demo.biz.WeightBiz;
import com.example.demo.bo.Sugar;
import com.example.demo.bo.Weight;
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

    @Validator
    @PostMapping("/save")
    public String save(@RequestHeader Map<String,String>header, @RequestBody Weight weight){
        try {
            System.out.println(JSON.toJSONString(weight));
            weightBiz.saveWeight(weight);
            return new Date() + " 上传成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    @Validator
    @PostMapping("/get")
    public String get(@RequestHeader Map<String,String>header, @RequestBody Map<String,String> map){
        String timeType = map.get("timeType");
        List<Sugar> list = weightBiz.selectByCondition(header.get("token").substring(0, 11), timeType);
        JSONArray jsonArray = new JSONArray();
        for (Sugar sugar : list) {
            JSONObject h = new JSONObject();
            h.put(sugar.getNum(), sugar.getTime());
            jsonArray.add(h);
        }
        return jsonArray.toString();
    }
}
