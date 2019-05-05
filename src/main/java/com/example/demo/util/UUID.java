package com.example.demo.util;

/**
 * @author pangkun
 * @date 2019/5/5 上午11:56
 */
public class UUID {
    public static final String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","" );
    }

    public static void main(String[] args) {
        System.out.println(UUID.getUUID().length());
        System.out.println(UUID.getUUID());
        System.out.println(UUID.getUUID());
        System.out.println(UUID.getUUID());
    }
}
