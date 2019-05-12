package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author pangkun
 * @date 2019/5/12 下午8:02
 */
public class Constant {
    public static final String FAIL = "{\"code\":\"1\"}";

    public static String getSuccess(Object object) {
        if (object == null) {
            return "{\"code\":\"0\"}";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", object);
        jsonObject.put("code", "0");
        return JSON.toJSONString(jsonObject);
    }

}
