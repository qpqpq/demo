package com.example.demo.bo;

import java.sql.Timestamp;

/**
 * @author pangkun
 * @date 2019/5/5 下午5:20
 */
public class Pressure {
    private String high;
    private String low;
    private String maibo;
    private String time;//timestamp

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
    }
}
