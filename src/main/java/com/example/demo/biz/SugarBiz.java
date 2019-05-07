package com.example.demo.biz;

import com.example.demo.bo.Pressure;
import com.example.demo.bo.Sugar;
import com.example.demo.service.SugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
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
        switch (type) {
            case "0":
                for (Sugar sugar : list) {
                    if (Long.valueOf(sugar.getTime()) < l - 1000L * 60 * 60 * 24 * 30) {
                        sugars.remove(sugar);
                    }
                }
                break;
            case "1":
                for (Sugar sugar : list) {
                    if (Long.valueOf(sugar.getTime()) < l - 1000L * 60 * 60 * 24 * 30 * 3) {
                        sugars.remove(sugar);
                    }
                }
                break;
            case "2":
                for (Sugar sugar : list) {
                    if (Long.valueOf(sugar.getTime()) < l - 1000L * 60 * 60 * 24 * 30 * 12) {
                        sugars.remove(sugar);
                    }
                }
                break;
            default:
                break;
        }
        String last=sugars.get(0).getTime();
        int t=1;
        Double sum= Double.valueOf(sugars.get(0).getNum());
        List<Sugar>list1=new ArrayList<>();
        for(int i=1;i<sugars.size();i++){
            Sugar sugar = sugars.get(i);
            if(sugar.getTime().equals(last)){
                sum+=Double.valueOf(sugar.getNum());
                t++;
            }else{
                Sugar sugar1=new Sugar();
                sugar1.setTime(last);
                sugar1.setNum(sum/t+"");
                sugar1.setPhone(sugar.getPhone());
                list1.add(sugar1);
                t=1;
                last=sugar.getTime();
                sum=Double.valueOf(sugar.getNum());
            }
        }
        return list1;
    }

}
