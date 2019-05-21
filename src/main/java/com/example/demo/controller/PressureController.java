package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.PressureBiz;
import com.example.demo.bo.Pressure;
import com.example.demo.util.Constant;
import com.example.demo.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author pangkun
 * @date 2019/5/5 下午2:17
 */
@RestController
@RequestMapping("/pressure")
public class PressureController {

    @Autowired
    private PressureBiz pressureBiz;

    //                 血压
    //                         保存   /pressure/save              Pressure
    //                         获取   /pressure/get               {timeType:012}    {high:[{num,time},{},{}...],low:[{},{},{}...]}
    @Validator
    @CrossOrigin
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody Pressure pressure) {
        try {
            System.out.println(JSON.toJSONString(pressure));
            pressureBiz.savePressure(pressure);
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
            List<Pressure> list = pressureBiz.selectByCondition(header.get("token").substring(0, 11), timeType);
            JSONObject jsonObject = new JSONObject();
            JSONArray high = new JSONArray();
            JSONArray low = new JSONArray();
            for (Pressure pressure : list) {
                JSONObject h = new JSONObject();
                h.put("num", pressure.getHigh());
                h.put("time", Time.stampToDate(pressure.getTime()));
                high.add(h);
                JSONObject l = new JSONObject();
                l.put("num", pressure.getLow());
                l.put("time", Time.stampToDate(pressure.getTime()));
                low.add(l);
            }
            jsonObject.put("high", high);
            jsonObject.put("low", low);
            return Constant.getSuccess(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }

}
