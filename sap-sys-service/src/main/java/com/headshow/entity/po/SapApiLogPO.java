package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/25 1:04
 * @desc 日志对象.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SapApiLogPO
{
    private String args;
    private Object result;
    private LocalDateTime now;
    private String time;
    private String ip;
    private String status;
    private Integer id;
    private String url;
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = createTime;
    private String createBy = "admin";
    private String updateBy = "admin";
}

