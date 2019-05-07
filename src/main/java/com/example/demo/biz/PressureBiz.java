package com.example.demo.biz;

import com.example.demo.bo.Pressure;
import com.example.demo.service.PressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author pangkun
 * @date 2019/5/7 下午2:26
 */
@Component
public class PressureBiz {

    @Autowired
    private PressureService pressureService;

    public void savePressure(Pressure pressure) {
        pressureService.insertPressure(pressure);
    }

    public List<Pressure> selectByCondition(String phone, String type) {
        List<Pressure> pressures = pressureService.selectById(phone);
        pressures.sort(new Comparator<Pressure>() {
            @Override
            public int compare(Pressure o1, Pressure o2) {
                return Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime()));
            }
        });
        long l = System.currentTimeMillis();
        List<Pressure> list = new ArrayList<>();
        for (Pressure pressure : pressures) {
            list.add(pressure);
        }
        switch (type) {
            case "0":
                for (Pressure pressure : list) {
                    if (Long.valueOf(pressure.getTime()) < l - 1000L * 60 * 60 * 24 * 30) {
                        pressures.remove(pressure);
                    }
                }
                break;
            case "1":
                for (Pressure pressure : list) {
                    if (Long.valueOf(pressure.getTime()) < l - 1000L * 60 * 60 * 24 * 30 * 3) {
                        pressures.remove(pressure);
                    }
                }
                break;
            case "2":
                for (Pressure pressure : list) {
                    if (Long.valueOf(pressure.getTime()) < l - 1000L * 60 * 60 * 24 * 30 * 12) {
                        pressures.remove(pressure);
                    }
                }
                break;
            default:
                break;
        }
        return pressures;
    }


}
