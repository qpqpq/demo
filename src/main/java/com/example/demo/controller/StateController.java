package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.StateBiz;
import com.example.demo.bo.State;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:24
 */
@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateBiz stateBiz;

    @Validator
    @CrossOrigin
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody State state) {
        try {
            System.out.println(JSON.toJSONString(state));
            stateBiz.saveState(state);
            return Constant.getSuccess(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }

    @Validator
    @CrossOrigin
    @PostMapping("/get")
    public String get(@RequestHeader Map<String, String> header) {
        try {
            List<State> list = stateBiz.selectByCondition(header.get("token").substring(0, 11));
            JSONArray jsonArray = new JSONArray();
            for (State state : list) {
                jsonArray.add(state.getState());
            }
            return Constant.getSuccess(jsonArray);
        } catch (Exception e) {
            return Constant.FAIL;
        }
    }
}
