package com.headshow.service.formmanager.impl;

import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.mapper.MapperUtils;
import com.headshow.dao.formmanager.FormFlowPOMapper;
import com.headshow.dao.formmanager.FormModulePOMapper;
import com.headshow.dao.formmanager.FormNodePOMapper;
import com.headshow.entity.dto.FormModuleDTO;
import com.headshow.entity.po.FormFlowPO;
import com.headshow.entity.po.FormModulePO;
import com.headshow.entity.po.FormNodePO;
import com.headshow.entity.vo.FormModuleVO;
import com.headshow.service.formmanager.FormModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @desc 模块的service实现类
 * @author linlangleo
 * @date 2018-04-22 20:32
 **/
@Service
public class FormModuleServiceImpl implements FormModuleService {
    @Resource
    private FormModulePOMapper formModulePOMapper;
    @Resource
    private FormFlowPOMapper formFlowPOMapper;
    @Resource
    private FormNodePOMapper formNodePOMapper;
    @Resource
    private ExceptionManager exceptionManager;

    /**
     * 新增模块
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveModule(FormModuleDTO formModule) {
        //进行数据拷贝
        FormModulePO formModulePO = MapperUtils.mapperBean(formModule, FormModulePO.class);

        //数据设置
        formModulePO.setCreate_time(LocalDateTime.now());
        formModulePO.setCreate_by("admin");
        formModulePO.setUpdate_time(LocalDateTime.now());
        formModulePO.setUpdate_by("admin");

        int count = formModulePOMapper.insertSelective(formModulePO);

        if(count > 0){
            return "新增成功";
        }else{
            throw exceptionManager.createByMessage("新增失败");
        }
    }

    /**
     * 获取所有的模块信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormModuleVO> getAllModule() {
        List<FormModulePO> formModulePOList = null;
        formModulePOList = formModulePOMapper.selectAll();

        //数据拷贝
        List<FormModuleVO> formModuleVOList = MapperUtils.mapperList(formModulePOList, FormModuleVO.class);

        return formModuleVOList;
    }

    /**
     * 根据id获取模块信息
     */
    @Override
    public FormModuleVO getModuleById(long id) {
        FormModulePO formModulePO = new FormModulePO();
        formModulePO.setId(id);
        //根据id获取模块信息
        formModulePO = formModulePOMapper.selectOne(formModulePO);

        //进行数据拷贝
        FormModuleVO formModuleVO = MapperUtils.mapperBean(formModulePO, FormModuleVO.class);
        return formModuleVO;
    }

    /**
     * 根据id删除模块
     */
    @Override
    public String delModuleById(long id) {
        //先删除模块下的流程
        FormFlowPO formFlowPO = new FormFlowPO();
        formFlowPO.setModule_id(String.valueOf(id));
        int flowCount = formFlowPOMapper.selectCount(formFlowPO);
        //判断该模块存在流程
        if(flowCount > 0){
            //删除每个流程下的节点
            List<FormFlowPO> formFlowPOList = formFlowPOMapper.select(formFlowPO);
            formFlowPOList.stream().forEach(flowItem -> {
                FormNodePO formNodePO = new FormNodePO();
                formNodePO.setK2_process_id(String.valueOf(flowItem.getId()));
                int nodeCount = formNodePOMapper.selectCount(formNodePO);
                if(nodeCount > 0){
                    formNodePOMapper.delete(formNodePO);
                }
            });
            formFlowPOMapper.delete(formFlowPO);
        }

        //删除模块
        int count = formModulePOMapper.deleteByPrimaryKey(id);

        if(count > 0){
            return "删除成功";
        }else{
            throw exceptionManager.createByMessage("删除失败");
        }
    }

    /**
     * 修改模块信息
     */
    @Override
    public String updateModuleById(FormModuleDTO formModuleDTO) {
        //根据id查询原有数据
        FormModulePO formModulePO = new FormModulePO();
        formModulePO.setId(formModuleDTO.getId());
        formModulePO = formModulePOMapper.selectOne(formModulePO);
        //修改数据
        if(formModuleDTO.getModule_code() != null && !formModuleDTO.getModule_code().trim().equals("")){
            formModulePO.setModule_code(formModuleDTO.getModule_code());
        }
        if(formModuleDTO.getModule_name() != null && !formModuleDTO.getModule_name().trim().equals("")){
            formModulePO.setModule_name(formModuleDTO.getModule_name());
        }
        formModulePO.setUpdate_by("admin");
        formModulePO.setUpdate_time(LocalDateTime.now());
        int count = formModulePOMapper.updateByPrimaryKey(formModulePO);

        if(count > 0){
            return "修改成功";
        }else{
            throw exceptionManager.createByMessage("修改失败");
        }
    }
}
