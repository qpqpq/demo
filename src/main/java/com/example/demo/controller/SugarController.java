package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.biz.SugarBiz;
import com.example.demo.bo.Sugar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
}
