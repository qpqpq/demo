package com.example.demo.biz;

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

    public List<Weight> selectByCondition(String phone, String type, String month) {
        List<Weight> weights = weightService.selectById(phone);
        weights.sort(new Comparator<Weight>() {
            @Override
            public int compare(Weight o1, Weight o2) {
                return Long.valueOf(o1.getTime()).compareTo(Long.valueOf(o2.getTime()));
            }
        });
        long l = System.currentTimeMillis();
        List<Weight> list = new ArrayList<>();
        for (Weight weight : weights) {
            list.add(weight);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date(Long.valueOf(System.currentTimeMillis())));
        System.out.println(format);
        switch (type) {
            case "0":
                for (Weight weight : list) {
                    if (Long.valueOf(date2TimeStamp(weight.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30) {
                        weights.remove(weight);
                    }
                }
                break;
            case "1":
                for (Weight weight : list) {
                    if (Long.valueOf(date2TimeStamp(weight.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 3) {
                        weights.remove(weight);
                    }
                }
                break;
            case "2":
                for (Weight weight : list) {
                    if (Long.valueOf(date2TimeStamp(weight.getTime() + " 00:00:00", "yyyyMMdd HH:mm:ss")) < l - 1000L * 60 * 60 * 24 * 30 * 12) {
                        weights.remove(weight);
                    }
                }
                break;
            default:
                break;
        }
        if (month != null && !month.equals("") && month.length() == 6) {
            cal(weights, month);
        }
        List<Weight> list1 = new ArrayList<>();
        for (int i = 0; i < weights.size() - 1; ) {
            Weight weight = weights.get(i);
            for (int j = i + 1; j < weights.size(); j++) {
                if (weight.getTime().equals(weights.get(j).getTime())) {
                    weight.setNum(String.valueOf(Double.valueOf(weight.getNum()) + Double.valueOf(weights.get(j).getNum())));
                } else {
                    weight.setNum(String.valueOf(Double.valueOf(weight.getNum()) / (j - i)));
                    list1.add(weight);
                    i = j;
                    break;
                }
            }
        }
        if(!weights.get(weights.size()-1).getTime().equals(weights.get(weights.size()-2).getTime())){
            list1.add(weights.get(weights.size()-1));
        }
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

    private void cal(List<Weight> list, String month) {
        for (int i = Integer.valueOf(month) * 100 + 1; i < Integer.valueOf(month) * 100 + 32; i++) {
            boolean flag = false;
            for (Weight sugar1 : list) {
                if (sugar1.getTime().equals(i + "")) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                Weight sugar = new Weight();
                sugar.setNum("0");
                sugar.setTime(i + "");
                list.add(sugar);
            }
            list.sort(new Comparator<Weight>() {
                @Override
                public int compare(Weight o1, Weight o2) {
                    return Integer.valueOf(o1.getTime()).compareTo(Integer.valueOf(o2.getTime()));
                }
            });
            while (Integer.valueOf(list.get(0).getTime()) < Integer.valueOf(month) * 100) {
                list.remove(0);
            }
            while (Integer.valueOf(list.get(list.size() - 1).getTime()) > Integer.valueOf(month) * 100 + 32) {
                list.remove(list.size() - 1);
            }
        }

    }
}
