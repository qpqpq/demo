package com.example.demo.bo;

import java.sql.Timestamp;

/**
 * @author pangkun
 * @date 2019/5/5 下午5:20
 */
public class Pressure {
    private String phone;
    private String high;
    private String low;
    private String maibo;
    private String time;//timestamp

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getMaibo() {
        return maibo;
    }

    public void setMaibo(String maibo) {
        this.maibo = maibo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
