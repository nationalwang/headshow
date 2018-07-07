package com.headshow.service.log.impl;

import com.headshow.common.utils.mapper.MapperUtils;
import com.headshow.common.utils.page.PageParam;
import com.headshow.common.utils.page.PageResult;
import com.headshow.common.utils.page.PageResultFactory;
import com.headshow.dao.log.SysLogCUDMapper;
import com.headshow.dao.log.SysLogQueryMapper;
import com.headshow.entity.dto.AddLogInterfaceDTO;
import com.headshow.entity.dto.DelLogInterfaceDTO;
import com.headshow.entity.dto.GetLogInterfaceKeyWordDTO;
import com.headshow.entity.dto.UpdateLogInterfaceDTO;
import com.headshow.entity.po.AddLogInterfacePO;
import com.headshow.entity.po.GetLogInterfaceKeyWordPO;
import com.headshow.entity.po.LogInterfaceInfoPO;
import com.headshow.entity.po.UpdateLogInterfacePO;
import com.headshow.entity.vo.LogInterfaceInfoVO;
import com.headshow.service.log.SysLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by beyondLi
 * Date 2018/4/11 22:09
 * Desc .
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    SysLogCUDMapper sysLogCUDMapper;
    @Resource
    SysLogQueryMapper sysLogQueryMapper;
    @Resource
    PageResultFactory pageResultFactory;

    /**
     * 新增日志所监管的接口
     * @param addLogInterfaceDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addInterface(AddLogInterfaceDTO addLogInterfaceDTO) {
        //进行数据拷贝
        AddLogInterfacePO addLogInterfacePO = MapperUtils.mapperBean(addLogInterfaceDTO, AddLogInterfacePO.class);
        //数据设置
        addLogInterfacePO.setCreateTime(LocalDateTime.now());
        addLogInterfacePO.setUpdateTime(LocalDateTime.now());
        //插入数据
        sysLogCUDMapper.addInterface(addLogInterfacePO);
    }

    /**
     * 根据id集合删除对应接口以及以下对应记录
     * @param delLogInterfaceDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteInterfaceById(DelLogInterfaceDTO delLogInterfaceDTO) {
        //根据id删除接口以及对应访问记录
        delLogInterfaceDTO.getIds().stream().forEach(id -> {
            //删除接口
            sysLogCUDMapper.deleteInterfaceById(id);
            //删除对应记录
            sysLogCUDMapper.deleteInterfaceRecordByInterfaceId(id);
        });
    }

    /**
     * 根据id更新接口信息
     * @param updateLogInterfaceDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateInterfaceById(UpdateLogInterfaceDTO updateLogInterfaceDTO) {
        UpdateLogInterfacePO updateLogInterfacePO = MapperUtils.mapperBean(updateLogInterfaceDTO, UpdateLogInterfacePO.class);
        updateLogInterfacePO.setUpdateTime(LocalDateTime.now());
        sysLogCUDMapper.updateInterfaceById(updateLogInterfacePO);
    }

    /**
     * 根据条件进行接口列表显示
     * @param getLogInterfaceKeyWordDTO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult getInterfaceList(GetLogInterfaceKeyWordDTO getLogInterfaceKeyWordDTO, PageParam pageParam) {
        //数据拷贝
        GetLogInterfaceKeyWordPO getLogInterfaceKeyWordPO = MapperUtils.mapperBean(getLogInterfaceKeyWordDTO, GetLogInterfaceKeyWordPO.class);
        //设置分页
        Page<LogInterfaceInfoPO> page = PageHelper.startPage(pageParam.getP(), pageParam.getC());
        //查询数据
        List<LogInterfaceInfoPO> interfaceInfoPOList = sysLogQueryMapper.getInterfaceList(getLogInterfaceKeyWordPO);
        //取分页信息
        int total = (int) page.getTotal();
        //拷贝
        List<LogInterfaceInfoVO> interfaceInfoVOList = MapperUtils.mapperList(interfaceInfoPOList, LogInterfaceInfoVO.class);
        //分页类
        PageResult pageResult = pageResultFactory.createPageResult(pageParam.getP(), total, interfaceInfoVOList);
        return pageResult;
    }

}
