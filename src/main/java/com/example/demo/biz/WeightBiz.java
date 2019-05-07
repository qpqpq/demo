package com.example.demo.biz;

import com.example.demo.bo.Sugar;
import com.example.demo.bo.Weight;
import com.example.demo.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:27
 */
@Component
public class WeightBiz {

    @Autowired
    private WeightService weightService;

    public void saveWeight(Weight weight) {
        weightService.insertWeight(weight);
    }

    public List<Sugar> selectByCondition(String phone, String type) {
        List<Weight> weights = weightService.selectById(phone);
        return null;
    }
}
