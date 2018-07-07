package com.headshow.service.formmanager;

import com.headshow.entity.dto.FormFlowDTO;
import com.headshow.entity.vo.FormFlowVO;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * @desc 流程的service接口
 * @author linlangleo
 * @date 2018-04-22 20:31
 **/
@Validated
public interface FormFlowService {
    /**
     * 新增流程
     */
    String saveFlow(FormFlowDTO formFlowDTO);

    /**
     * 获取所有的流程信息
     */
    List<FormFlowVO> queryAllFlow();

    /**
     * 根据ID获取流程信息
     */
    FormFlowVO getFlowById(long id);

    /**
     * 根据模块ID获取流程信息
     */
    List<FormFlowVO> getFlowByModuleId(String moduleId);

    /**
     * 根据流程编号获取流程信息
     */
    FormFlowVO getFlowByFlowCode();

    /**
     * 根据流程名称获取流程信息
     */
    List<FormFlowVO> queryFlowByFlowName();

    /**
     * 根据id删除流程
     */
    String delFlowById(long id);

    /**
     * 修改流程信息
     */
    String updateFlowById(FormFlowDTO formFlowDTO);
}
