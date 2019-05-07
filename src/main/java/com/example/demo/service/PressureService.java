package com.example.demo.service;

import com.example.demo.bo.Pressure;
import com.example.demo.dao.PressureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pangkun
 * @date 2019/5/7 下午2:24
 */
@Service
public class PressureService {

    @Autowired
    private PressureDao pressureDao;

    public void insertPressure(Pressure pressure){
        pressureDao.insertPressure(pressure);
    }
}
