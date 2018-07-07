package com.headshow.entity.enums;

/**
 * @author beyondLi--liboyang71@163.com
 * @date 2018/4/11 21:53
 * @desc
 */
public enum LogInterfaceStatusEnums {

    OPEN("开启"),CLOSE("关闭");

    public String name;

    LogInterfaceStatusEnums(String name) {
        this.name = name;
    }
}
