package com.headshow.entity.enums;

/**
 * @author beyondLi--liboyang71@163.com
 * @date 2018/4/11 21:53
 * @desc
 */
public enum HttpTypeEnums {

    GET("get请求"),POST("post请求");

    public String name;

    HttpTypeEnums(String name) {
        this.name = name;
    }
}
