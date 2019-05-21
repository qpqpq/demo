package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.annotation.Validator;
import com.example.demo.biz.YaoBiz;
import com.example.demo.bo.Yao;
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
@RequestMapping("/yao")
public class YaoController {

    @Autowired
    private YaoBiz yaoBiz;

    //                 用药
    //                         保存   /yao/save                   Yao
    //                         获取   /yao/get                                      [{Yao},{}...]
    //                         删除   /yao/delete                 name
    @Validator
    @PostMapping("/save")
    public String save(@RequestHeader Map<String, String> header, @RequestBody Yao yao) {
        try {
            System.out.println(JSON.toJSONString(yao));
            yaoBiz.saveYao(yao);
            return Constant.getSuccess(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }

    @Validator
    @PostMapping("/delete")
    public String delete(@RequestHeader Map<String, String> header, @RequestBody Yao yao) {
        try {
            System.out.println(JSON.toJSONString(yao));
            yaoBiz.delete(yao.getName());
            return Constant.getSuccess(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }

    @Validator
    @PostMapping("/get")
    public String get(@RequestHeader Map<String, String> header) {
        try {
            List<Yao> list = yaoBiz.selectByCondition(header.get("token").substring(0, 11));
            JSONArray jsonArray = new JSONArray();
            for (Yao yao : list) {
                JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(yao));
                jsonArray.add(jsonObject);
            }
            return Constant.getSuccess(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
            return Constant.FAIL;
        }
    }
}

