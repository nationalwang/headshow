package com.headshow.dao.backinterfacemanage;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 22:11
 * @desc ${DESCRIPTION}.
 */

public interface SapApiLogAopCUDMapper {


    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .保存请求参数 调用时间  ip地址 调用结果 到日志
     */
    @Insert("insert into sys_interface_manager_details (manager_id, time, ip, status, request, inface_url, start_time, response,"
            + " create_time, update_time, create_by, update_by, mark) values "
            + "(#{id}, #{time}, #{ip}, #{status}, #{args}, #{url}, #{now}, #{result}, #{createTime}, #{updateTime}, #{createBy},"
            + " #{updateBy}, 'ENABLE')")
    void saveInterfaceManagerDetail(@Param(value = "args") String args,
                                    @Param(value = "result")String result,
                                    @Param(value = "now")LocalDateTime now,
                                    @Param(value = "time")String time,
                                    @Param(value = "ip")String ip,
                                    @Param(value = "status")String status,
                                    @Param(value = "id")Integer id,
                                    @Param(value = "url")String url,
                                    @Param(value = "createTime")LocalDateTime createTime,
                                    @Param(value = "updateTime")LocalDateTime updateTime,
                                    @Param(value = "createBy")String createBy,
                                    @Param(value = "updateBy")String updateBy);
}
