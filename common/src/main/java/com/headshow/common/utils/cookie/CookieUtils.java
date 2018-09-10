package com.headshow.common.utils.cookie;

import java.util.UUID;

/**
 * @author linlangleo
 * @desc token 创建工具类
 * @date 2018-09-02 12:11
 **/
public class CookieUtils {

    public static String getUUTkoen() {
        String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return token;
    }
}
