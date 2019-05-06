package com.example.demo.bo;

/**
 * @author pangkun
 * @date 2019/2/23 下午3:47
 */
public class User {
    private String name;//姓名
    private String password;//注册
    private String sex;//0 男/1 女
    private String birthday;//20190101
    private String idcard;//18
    private String postcode;//130012
    private String phone;//11    注册
    private String health;//0 健康/1 高血压/2 糖尿病
    private String height;//cm
    private String weight;//kg
    private String xiyan;
    private String yinjiu;
//    private String yinshi;//0123456。。。
//    private String picture;
//    private String family;
//    private String state;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}