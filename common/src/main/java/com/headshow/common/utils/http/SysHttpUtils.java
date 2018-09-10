package com.headshow.common.utils.http;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author linlangleo
 * @desc http工具
 * @date 2018-09-01 21:37
 **/
public class SysHttpUtils {
    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getHttpRequest(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    /**
     * 获取HttpServletResponse
     * @return
     */
    public static HttpServletResponse getHttpResponset(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        return response;
    }

}
