package com.headshow.service.formmanager.impl;


import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.dao.formmanager.FormManagerQueryMapper;
import com.headshow.service.formmanager.FormManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * 表单的service 实现类
 */
@Service
public class FormManagerServiceImpl implements FormManagerService {
    @Resource
    private FormManagerQueryMapper formManagerQueryMapper;

    @Resource
    private ExceptionManager exceptionManager;
    /**
     * 根据传进来的流程Id，节点Id 获取对应的页面名称
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String getPageOfNode(String processId, String nodeId) {
        //判断非空
        if(processId.trim().equals("") || processId == null || nodeId.trim().equals("")  || nodeId == null){
            throw exceptionManager.createByCode("SAP_FORMINFO_NOTBLANK");
        }

        //根据流程编号ID，节点ID 获取页面名称
        String pageName = formManagerQueryMapper.getNodePageByProcessIdAndNodeId(processId, nodeId);

        //判断页面不存在
        if(pageName == null){
            throw exceptionManager.createByCode("SAP_FORMINFO_NOTEXIST");
        }
        return pageName;
    }
}

