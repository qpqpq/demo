package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.SugarBiz;
import com.example.demo.bo.Sugar;
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
@RequestMapping("/sugar")
public class SugarController {

    @Autowired
    private SugarBiz sugarBiz;

    @Validator
    @PostMapping("/save")
    public String insertSugar(@RequestHeader Map<String,String>header, @RequestBody Sugar sugar){
        try {
            System.out.println(JSON.toJSONString(sugar));
            sugarBiz.saveSugar(sugar);
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
        List<Sugar> list = sugarBiz.selectByCondition(header.get("token").substring(0, 11), timeType);
        JSONArray jsonArray = new JSONArray();
        for (Sugar sugar : list) {
            JSONObject h = new JSONObject();
            h.put(sugar.getNum(), sugar.getTime());
            jsonArray.add(h);
        }
        return jsonArray.toString();
    }
}
