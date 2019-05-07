package com.example.demo.service;

import com.example.demo.bo.Sugar;
import com.example.demo.dao.SugarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:25
 */
@Service
public class SugarService {

    @Autowired
    private SugarDao sugarDao;

    public void insertSugar(Sugar sugar){
        sugarDao.insertSugar(sugar);
    }

    public List<Sugar>selectById(String phone){
        return sugarDao.selectById(phone);
    }


}
