package com.example.demo.bo;

/**
 * @author pangkun
 * @date 2019/5/13 下午8:52
 */
public class State {
    //     /state    {state:0101010}
    private String phone;
    private String state;//0101010  [12]

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
