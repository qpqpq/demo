package com.example.demo.service;

import com.example.demo.bo.Sugar;
import com.example.demo.bo.Weight;
import com.example.demo.dao.SugarDao;
import com.example.demo.dao.WeightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:25
 */
@Service
public class WeightService {

    @Autowired
    private WeightDao weightDao;

    public void insertWeight(Weight weight) {
        weightDao.insertWeight(weight);
    }

    public List<Weight> selectById(String phone) {
        return weightDao.selectById(phone);
    }


}
