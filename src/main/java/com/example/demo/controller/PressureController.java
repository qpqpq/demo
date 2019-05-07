package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.PressureBiz;
import com.example.demo.bo.Pressure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @PostMapping("/save")
    public String f(@RequestHeader Map<String, String> header, @RequestBody Pressure pressure) {
        try {
            System.out.println(JSON.toJSONString(pressure));
            pressureBiz.savePressure(pressure);
            return new Date() + " 上传成功";
        }catch (Exception e){
            return "{}";
        }
    }
}
