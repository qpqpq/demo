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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getXiyan() {
        return xiyan;
    }

    public void setXiyan(String xiyan) {
        this.xiyan = xiyan;
    }

    public String getYinjiu() {
        return yinjiu;
    }

    public void setYinjiu(String yinjiu) {
        this.yinjiu = yinjiu;
    }
}