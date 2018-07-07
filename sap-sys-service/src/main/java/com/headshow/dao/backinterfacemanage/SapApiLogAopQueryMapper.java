package com.headshow.dao.backinterfacemanage;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 22:11
 * @desc ${DESCRIPTION}.
 */

public interface SapApiLogAopQueryMapper {

    @Select("select id from sys_whitename_manager where substring_index(url_start, '.', 3) = substring_index(#{url}, '.', 3)")
    List<Integer> urlByIp(String url);

    @Select("select id from sys_interface_manager where mark = 'ENABLE' and status = 'OPEN' and method_name = #{className} ")
    Integer queryByOpenName(String className);

    @Select("SELECT COUNT(*) FROM sys_whitename_manager WHERE SUBSTRING_INDEX(#{ips}, '.', -1) >= SUBSTRING_INDEX(url_start, '.', -1) AND  "
            + "SUBSTRING_INDEX(#{ips}, '.', -1) <= SUBSTRING_INDEX(url_end, '.', -1) AND id = #{id};")
    Integer urlById(@Param(value = "id")Integer id, @Param(value = "ips") String ips);
}
