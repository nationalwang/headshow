package com.headshow.dao.formmanager;

import com.headshow.entity.po.GetLogInterfaceKeyWordPO;
import com.headshow.entity.po.LogInterfaceInfoPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Desc .表单管理的查询Mapper
 * @by linlangleo
 * Date 2018/4/14 15:03
 */
public interface FormManagerQueryMapper {
    /**
     * 根据传进来的 流程编号，节点Id 获取对应的页面名称
     * @param processCode
     * @param nodeId
     */
    @Select("SELECT node_pagename FROM fb_sap_form_node node" +
            " INNER JOIN fb_sap_form_flow flow ON flow.id = node.k2_process_id" +
            " WHERE flow.k2_process_code = #{processCode} AND node.k2_node_id = #{nodeId}")
    String getNodePageByProcessIdAndNodeId(@Param("processCode") String processCode, @Param("nodeId") String nodeId);
    /**
     * 根据传进来的 流程编号 获取流程Id
     * @param processCode
     */
    @Select("SELECT id FROM fb_sap_form_flow WHERE k2_process_code = #{processCode}")
    String getIdByProcessCode(@Param("processCode") String processCode);



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
