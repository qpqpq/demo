package com.example.demo.biz;

import com.example.demo.bo.Pressure;
import com.example.demo.service.PressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
        List<Pressure> list1 = new ArrayList<>();
        if (pressures.size() == 0) {
            System.out.println("!!!!");
            return list1;
        }
        for (Pressure pressure : pressures) {
            pressure.setTime(stampToDate(pressure.getTime()));
        }
        Pressure pressure = new Pressure();
        pressure.setTime(pressures.get(0).getTime());
        pressure.setPhone(pressures.get(0).getPhone());
        pressure.setHigh(pressures.get(0).getHigh());
        pressure.setLow(pressures.get(0).getLow());
        pressure.setMaibo(pressures.get(0).getMaibo());
        int t = 1;
        for (int i = 1; i < pressures.size(); i++) {
            if (pressures.get(i).getTime().equals(pressure.getTime())) {
                pressure.setMaibo((Double.valueOf(pressure.getMaibo()) * t + Double.valueOf(pressures.get(i).getMaibo())) / (t + 1) + "");
                pressure.setLow((Double.valueOf(pressure.getLow()) * t + Double.valueOf(pressures.get(i).getLow())) / (t + 1) + "");
                pressure.setHigh((Double.valueOf(pressure.getHigh()) * t + Double.valueOf(pressures.get(i).getHigh())) / (t + 1) + "");
                t++;
            } else {
                list1.add(pressure);
                pressure = new Pressure();
                pressure.setHigh(pressures.get(i).getHigh());
                pressure.setLow(pressures.get(i).getLow());
                pressure.setMaibo(pressures.get(i).getMaibo());
                pressure.setTime(pressures.get(i).getTime());
                t = 1;
            }
        }
        list1.add(pressure);
        cal(list1);
        System.out.println(list1.size());
        return list1;
    }

    public String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    private void cal(List<Pressure> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String format = sdf.format(new Date(Long.valueOf(System.currentTimeMillis())));
        if (Integer.valueOf(format) % 100 == 5) {
            //31天
            for (int i = 20190501; i < 20190532; i++) {
                boolean flag = false;
                for (Pressure sugar1 : list) {
                    if (sugar1.getTime().equals(i + "")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Pressure sugar = new Pressure();
                    sugar.setLow("0");
                    sugar.setHigh("0");
                    sugar.setMaibo("0");
                    sugar.setTime(i + "");
                    list.add(sugar);
                }
                list.sort(new Comparator<Pressure>() {
                    @Override
                    public int compare(Pressure o1, Pressure o2) {
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
                for (Pressure sugar1 : list) {
                    if (sugar1.getTime().equals(i + "")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    Pressure sugar = new Pressure();
                    sugar.setMaibo("0");
                    sugar.setHigh("0");
                    sugar.setLow("0");
                    sugar.setTime(i + "");
                    list.add(sugar);
                }
                list.sort(new Comparator<Pressure>() {
                    @Override
                    public int compare(Pressure o1, Pressure o2) {
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
