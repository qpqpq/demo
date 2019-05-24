package com.example.demo.biz;

import com.example.demo.bo.Sugar;
import com.example.demo.service.SugarService;
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
        for (int i = 1; i < sugars.size(); i++) {
            if (sugars.get(i).getTime().equals(sugar.getTime())) {
                sugar.setNum((Double.valueOf(sugar.getNum()) * t + Double.valueOf(sugars.get(i).getNum())) / (++t) + "");
            } else {
                list1.add(sugar);
                sugar = new Sugar();
                sugar.setNum(sugars.get(i).getNum());
                sugar.setTime(sugars.get(i).getTime());
                t = 1;
            }
        }
        list1.add(sugar);
        System.out.println(list1.size());
        cal(list1);
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

    private void cal(List<Sugar> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(new Date(Long.valueOf(System.currentTimeMillis())));
        if (Integer.valueOf(format) % 100 == 5) {
            //31天
            for (int i = 20190501; i < 20190532; i++) {
                boolean flag = false;
                for (Sugar sugar1 : list) {
                    if (sugar1.getTime().equals(i + "")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Sugar sugar = new Sugar();
                    sugar.setNum("0");
                    sugar.setQujian("0");
                    sugar.setTime(i + "");
                    list.add(sugar);
                }
                list.sort(new Comparator<Sugar>() {
                    @Override
                    public int compare(Sugar o1, Sugar o2) {
                        return Integer.valueOf(o1.getTime()).compareTo(Integer.valueOf(o2.getTime()));
                    }
                });
                while (Integer.valueOf(list.get(0).getTime())<20190501){
                    list.remove(0);
                }
            }
        } else {
            //30天
            for (int i = 20190601; i < 20190631; i++) {
                boolean flag = false;
                for (Sugar sugar1 : list) {
                    if (sugar1.getTime().equals(i + "")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Sugar sugar = new Sugar();
                    sugar.setNum("0");
                    sugar.setQujian("0");
                    sugar.setTime(i + "");
                    list.add(sugar);
                }
                list.sort(new Comparator<Sugar>() {
                    @Override
                    public int compare(Sugar o1, Sugar o2) {
                        return Integer.valueOf(o1.getTime()).compareTo(Integer.valueOf(o2.getTime()));
                    }
                });
                while (Integer.valueOf(list.get(0).getTime())<20190601){
                    list.remove(0);
                }
            }
        }
    }
}
