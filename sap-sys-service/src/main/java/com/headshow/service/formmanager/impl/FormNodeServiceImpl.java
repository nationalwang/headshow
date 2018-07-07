package com.headshow.service.formmanager.impl;

import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.mapper.MapperUtils;
import com.headshow.dao.formmanager.FormNodePOMapper;
import com.headshow.entity.dto.FormNodeDTO;
import com.headshow.entity.po.FormNodePO;
import com.headshow.entity.vo.FormNodeVO;
import com.headshow.service.formmanager.FormNodeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @desc 节点的service实现类
 * @author linlangleo
 * @date 2018-04-22 20:32
 **/
@Service
public class FormNodeServiceImpl implements FormNodeService {
    @Resource
    private FormNodePOMapper formNodePOMapper;
    @Resource
    private ExceptionManager exceptionManager;

    /**
     * 新增节点
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveNode(FormNodeDTO formNodeDTO) {
        //进行数据拷贝
        FormNodePO formNodePO = MapperUtils.mapperBean(formNodeDTO, FormNodePO.class);

        //数据设置
        formNodePO.setCreate_time(LocalDateTime.now());
        formNodePO.setCreate_by("admin");
        formNodePO.setUpdate_time(LocalDateTime.now());
        formNodePO.setUpdate_by("admin");

        int count = formNodePOMapper.insertSelective(formNodePO);

        if(count > 0){
            return "新增成功";
        }else{
            throw exceptionManager.createByMessage("新增失败");
        }
    }

    /**
     * 获取所有的节点信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormNodeVO> queryAllNode() {
        return null;
    }

    /**
     * 根据流程ID，获取节点信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormNodeVO> getNodeByFlowId(String flowId) {
        FormNodePO formNodePO = new FormNodePO();
        formNodePO.setK2_process_id(flowId);
        //根据流程ID，获取节点信息
        List<FormNodePO> formNodePOList = formNodePOMapper.select(formNodePO);

        //数据拷贝
        List<FormNodeVO> formNodeVOS = MapperUtils.mapperList(formNodePOList, FormNodeVO.class);

        return formNodeVOS;
    }

    /**
     * 根据id删除节点
     */
    @Override
    public String delNodeById(long id) {
        //删除节点
        int count = formNodePOMapper.deleteByPrimaryKey(id);

        if(count > 0){
            return "删除成功";
        }else{
            throw exceptionManager.createByMessage("删除失败");
        }
    }

    /**
     * 修改节点信息
     */
    @Override
    public String updateNodeById(FormNodeDTO formNodeDTO) {
        //根据id查询原有数据
        FormNodePO formNodePO = new FormNodePO();
        formNodePO.setId(formNodeDTO.getId());
        formNodePO = formNodePOMapper.selectOne(formNodePO);
        //修改数据
        if(formNodeDTO.getK2_node_id() != null && !formNodeDTO.getK2_node_id().trim().equals("")){
            formNodePO.setK2_node_id(formNodeDTO.getK2_node_id());
        }
        if(formNodeDTO.getNode_pagename() != null && !formNodeDTO.getNode_pagename().trim().equals("")){
            formNodePO.setNode_pagename(formNodeDTO.getNode_pagename());
        }
        formNodePO.setUpdate_by("admin");
        formNodePO.setUpdate_time(LocalDateTime.now());
        int count = formNodePOMapper.updateByPrimaryKey(formNodePO);

        if(count > 0){
            return "修改成功";
        }else{
            throw exceptionManager.createByMessage("修改失败");
        }
    }
}
