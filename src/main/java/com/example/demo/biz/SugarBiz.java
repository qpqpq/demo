package com.example.demo.biz;

import com.example.demo.bo.Pressure;
import com.example.demo.bo.Sugar;
import com.example.demo.service.SugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author pangkun
 * @date 2019/5/7 下午7:27
 */
@Component
public class SugarBiz {

    @Autowired
    private SugarService sugarService;

    public void saveSugar(Sugar sugar) {
        sugarService.insertSugar(sugar);
    }

    public List<Sugar> selectByCondition(String phone, String type) {
        List<Sugar> sugars = sugarService.selectById(phone);
        sugars.sort(new Comparator<Sugar>() {
            @Override
            public int compare(Sugar o1, Sugar o2) {
                return Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime()));
            }
        });
        long l = System.currentTimeMillis();
        List<Sugar> list = new ArrayList<>();
        for (Sugar sugar : sugars) {
            list.add(sugar);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(System.currentTimeMillis())));
        System.out.println(format);
        switch (type) {
            case "0":
                for (Sugar sugar : list) {
                    if (Long.valueOf(date2TimeStamp(sugar.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30) {
                        sugars.remove(sugar);
                    }
                }
                break;
            case "1":
                for (Sugar sugar : list) {
                    if (Long.valueOf(date2TimeStamp(sugar.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 3) {
                        sugars.remove(sugar);
                    }
                }
                break;
            case "2":
                for (Sugar sugar : list) {
                    if (Long.valueOf(date2TimeStamp(sugar.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 12) {
                        sugars.remove(sugar);
                    }
                }
                break;
            default:
                break;
        }
        List<Sugar> list1 = new ArrayList<>();
        if (sugars.size() == 0) {
            System.out.println("!!!!");
            return list1;
        }

        Sugar sugar = new Sugar();
        sugar.setPhone(sugars.get(0).getPhone());
        sugar.setTime(sugars.get(0).getTime());
        sugar.setNum(sugars.get(0).getNum());
        int t = 1;
        for (Sugar sugar1 : sugars) {
            if (sugar1.getTime().equals(sugar.getTime())) {
                sugar.setNum((Double.valueOf(sugar.getNum()) * t + Double.valueOf(sugar1.getNum())) / (++t) + "");
            } else {
                list1.add(sugar);
                sugar.setNum(sugar1.getNum());
                sugar.setTime(sugar1.getTime());
                t = 1;
            }
        }
        list1.add(sugar);
        System.out.println(list1.size());
        return list1;
    }


    public String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
