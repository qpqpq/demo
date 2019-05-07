package com.example.demo.biz;

import com.example.demo.bo.Pressure;
import com.example.demo.service.PressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pangkun
 * @date 2019/5/7 下午2:26
 */
@Component
public class PressureBiz {

    @Autowired
    private PressureService pressureService;

    public void savePressure(Pressure pressure){
        pressureService.insertPressure(pressure);
    }

}
