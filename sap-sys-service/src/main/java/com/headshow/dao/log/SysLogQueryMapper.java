package com.headshow.dao.log;

import com.headshow.entity.po.GetLogInterfaceKeyWordPO;
import com.headshow.entity.po.LogInterfaceInfoPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by beyondLi
 * Date 2018/4/11 22:15
 * Desc .
 */
public interface SysLogQueryMapper {
    /**
     * 根据条件查看接口信息列表
     * @param getLogInterfaceKeyWordPO
     * @return
     */
    @Select("<script> select id as id, interface_name as interfaceName, url as url, "
            + "method_type as methodType, method_name as methodName, max_limit as maxLimit, "
            + "use_status as useStatus, remark as remark, create_time as createTime, "
            + "update_time as updateTime from tb_bgy_api_interface "
            + "<where>"
            + "<if test = \"interfaceName != null and interfaceName != ''\" >and interface_name like \"%\"#{interfaceName}\"%\"</if>"
            + "<if test = \"url != null and url != ''\" >and url like \"%\"#{url}\"%\"</if>"
            + "<if test = \"methodType != null \" >and method_type = #{methodType}</if>"
            + "</where>"
            + "</script>")
    List<LogInterfaceInfoPO> getInterfaceList(GetLogInterfaceKeyWordPO getLogInterfaceKeyWordPO);
}
