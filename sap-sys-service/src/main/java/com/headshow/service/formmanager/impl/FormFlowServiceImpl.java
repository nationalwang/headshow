package com.headshow.service.formmanager.impl;

import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.mapper.MapperUtils;
import com.headshow.dao.formmanager.FormFlowPOMapper;
import com.headshow.dao.formmanager.FormModulePOMapper;
import com.headshow.dao.formmanager.FormNodePOMapper;
import com.headshow.entity.dto.FormFlowDTO;
import com.headshow.entity.po.FormFlowPO;
import com.headshow.entity.po.FormModulePO;
import com.headshow.entity.po.FormNodePO;
import com.headshow.entity.vo.FormFlowVO;
import com.headshow.service.formmanager.FormFlowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @desc 流程的service实现类
 * @author linlangleo
 * @date 2018-04-22 20:32
 **/
@Service
public class FormFlowServiceImpl implements FormFlowService {
    @Resource
    private FormModulePOMapper formModulePOMapper;
    @Resource
    private FormFlowPOMapper formFlowPOMapper;
    @Resource
    private FormNodePOMapper formNodePOMapper;
    @Resource
    private ExceptionManager exceptionManager;

    /**
     * 新增流程
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String saveFlow(FormFlowDTO formFlowDTO) {
        //进行数据拷贝
        FormFlowPO formFlowPO = MapperUtils.mapperBean(formFlowDTO, FormFlowPO.class);

        //数据设置
        formFlowPO.setCreate_time(LocalDateTime.now());
        formFlowPO.setCreate_by("admin");
        formFlowPO.setUpdate_time(LocalDateTime.now());
        formFlowPO.setUpdate_by("admin");

        int count = formFlowPOMapper.insertSelective(formFlowPO);

        if(count > 0){
            return "新增成功";
        }else{
            throw exceptionManager.createByMessage("新增失败");
        }
    }

    /**
     * 获取所有的流程信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormFlowVO> queryAllFlow() {
        return null;
    }

    /**
     * 根据ID获取流程信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public FormFlowVO getFlowById(long id) {
        FormFlowPO formFlowPO = new FormFlowPO();
        formFlowPO.setId(id);
        //根据ID获取流程信息
        formFlowPO = formFlowPOMapper.selectOne(formFlowPO);

        //根据模块Id查询模块名
        FormModulePO formModulePO = new FormModulePO();
        formModulePO.setId(Long.valueOf(formFlowPO.getModule_id()));
        String module_name = formModulePOMapper.selectOne(formModulePO).getModule_name();

        //进行数据拷贝
        FormFlowVO formFlowVO = MapperUtils.mapperBean(formFlowPO, FormFlowVO.class);
        //数据设置
        formFlowVO.setModule_name(module_name);

        return formFlowVO;
    }

    /**
     * 根据模块ID获取流程信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormFlowVO> getFlowByModuleId(String moduleId) {
        FormFlowPO formFlowPO = new FormFlowPO();
//        formFlowPO.setModule_id(moduleId);
        //获取数据
        List<FormFlowPO> formFlowPOList = formFlowPOMapper.select(formFlowPO);

        //进行数据拷贝
        List<FormFlowVO> formFlowVOList = MapperUtils.mapperList(formFlowPOList, FormFlowVO.class);

        return formFlowVOList;
    }

    /**
     * 根据流程编号获取流程信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public FormFlowVO getFlowByFlowCode() {
        return null;
    }

    /**
     * 根据流程名称获取流程信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<FormFlowVO> queryFlowByFlowName() {
        return null;
    }

    /**
     * 根据id删除流程
     */
    @Override
    public String delFlowById(long id) {
        //先删除流程下的节点
        FormNodePO formNodePO = new FormNodePO();
        formNodePO.setK2_process_id(String.valueOf(id));
        int nodeCount = formNodePOMapper.selectCount(formNodePO);
        //判断该流程存在节点
        if(nodeCount > 0){
            formNodePOMapper.delete(formNodePO);
        }

        //删除流程
        int count = formFlowPOMapper.deleteByPrimaryKey(id);

        if(count > 0){
            return "删除成功";
        }else{
            throw exceptionManager.createByMessage("删除失败");
        }
    }

    /**
     * 修改流程信息
     */
    @Override
    public String updateFlowById(FormFlowDTO formFlowDTO) {
        //根据id查询原有数据
        FormFlowPO formFlowPO = new FormFlowPO();
        formFlowPO.setId(formFlowDTO.getId());
        formFlowPO = formFlowPOMapper.selectOne(formFlowPO);
        //修改数据
        if(formFlowDTO.getFlow_name() != null && !formFlowDTO.getFlow_name().trim().equals("")){
            formFlowPO.setFlow_name(formFlowDTO.getFlow_name());
        }
        if(formFlowDTO.getK2_process_code() != null && !formFlowDTO.getK2_process_code().trim().equals("")){
            formFlowPO.setK2_process_code(formFlowDTO.getK2_process_code());
        }
        formFlowPO.setUpdate_by("admin");
        formFlowPO.setUpdate_time(LocalDateTime.now());
        int count = formFlowPOMapper.updateByPrimaryKey(formFlowPO);

        if(count > 0){
            return "修改成功";
        }else{
            throw exceptionManager.createByMessage("修改失败");
        }
    }
}
