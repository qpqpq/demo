package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

    public static void main(String[] args) {
        User user = new User();
        for (Method method : User.class.getMethods()) {
            if (method.getName().contains("set")) {
                try {
                    method.invoke(user, method.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(JSON.toJSONString(user));
    }

}
