package com.headshow.service.backinterfacemanage;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 22:04
 * @desc ${DESCRIPTION}.
 */

public interface SapApiLogAopService {
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .url 是否在开放的ip段内
     */
    List<Integer> urlByIp(String url);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .获取所有方法名
     */
    Integer queryByOpenName(String className);

    /**
     * @author LF--liufang@maxrocky.com
     *
     * @desc  .保存请求参数 调用结果 当前时间 调用时间  ip地址   状态到日志
     */
    void saveInterfaceManagerDetail(String args, String result, LocalDateTime now, String time,
                                    String ip, String status, Integer id, String url);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .获取起始ip结束ip
     */
    Integer urlById(Integer id, String ips);
}
