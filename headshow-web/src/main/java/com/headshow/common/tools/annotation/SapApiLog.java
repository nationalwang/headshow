package com.headshow.common.tools.annotation;

import java.lang.annotation.*;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/23 15:38
 * @desc 自定义注解.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SapApiLog {
}

