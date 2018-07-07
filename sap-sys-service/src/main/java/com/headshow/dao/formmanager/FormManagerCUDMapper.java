package com.headshow.dao.formmanager;

import com.headshow.entity.po.AddLogInterfacePO;
import com.headshow.entity.po.UpdateLogInterfacePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * Desc .表单管理的增删改Mapper
 * @by linlangleo
 * Date 2018/4/14 15:03
 */
public interface FormManagerCUDMapper {
    /**
     * 插入log日志监管接口
     * @param addLogInterfacePO
     */
    @Insert("insert into tb_bgy_api_interface "
            + "(interface_name, url, method_type, method_name, max_limit, use_status, create_time, "
            + "create_by, update_time, remark) "
            + "values (#{interfaceName}, #{url}, #{methodType}, #{methodName}, #{maxLimit}, "
            + "#{useStatus}, #{createTime}, #{createBy}, #{updateTime}, #{remark})")
    void addInterface(AddLogInterfacePO addLogInterfacePO);

    /**
     * 根据id删除对应接口(伪删除)
     * @param id
     */
    @Update("UPDATE tb_bgy_api_interface SET state = 'NO' WHERE id = #{value}")
    void deleteInterfaceById(Integer id);

    /**
     * 根据interfaceId删除对应记录
     * @param id
     */
    @Update("UPDATE tb_bgy_api_interface_log SET state = 'NO' WHERE interface_id = #{value}")
    void deleteInterfaceRecordByInterfaceId(Integer id);

    /**
     * 根据id修改接口信息
     * @param updateLogInterfacePO
     */
    @Update("UPDATE tb_bgy_api_interface SET interface_name = #{interfaceName}, url = #{url}, "
            + "method_type = #{methodType}, method_name = #{methodName}, max_limit = #{maxLimit}, "
            + "use_status = #{useStatus}, update_time = #{updateTime}, update_by = #{updateBy}, "
            + "remark = #{remark} where id = #{id}")
    void updateInterfaceById(UpdateLogInterfacePO updateLogInterfacePO);
}
