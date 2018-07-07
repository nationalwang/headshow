package com.headshow.service.backinterfacemanage.impl;

import com.headshow.dao.backinterfacemanage.SapApiLogAopCUDMapper;
import com.headshow.dao.backinterfacemanage.SapApiLogAopQueryMapper;
import com.headshow.service.backinterfacemanage.SapApiLogAopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/24 22:05
 * @desc aop服务类.
 */
@Service
public class SapApiLogAopServiceImpl implements SapApiLogAopService {

    @Resource
    SapApiLogAopQueryMapper sapApiLogAopQueryMapper;
    @Resource
    SapApiLogAopCUDMapper sapApiLogAopCUDMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Integer>  urlByIp(String url) {
        List<Integer> ids = sapApiLogAopQueryMapper.urlByIp(url);
        return ids;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer queryByOpenName(String className) {
        return  sapApiLogAopQueryMapper.queryByOpenName(className);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveInterfaceManagerDetail(String args, String result, LocalDateTime now, String time,
                                           String ip, String status, Integer id, String url) {
        LocalDateTime createTime = LocalDateTime.now();
        LocalDateTime updateTime = createTime;
        String createBy = "admin";
        String updateBy = "admin";
        sapApiLogAopCUDMapper.saveInterfaceManagerDetail(args, result, now, time, ip, status, id, url,
                createTime, updateTime, createBy, updateBy);
    }

    @Override
    public Integer urlById(Integer id, String ips) {
        return sapApiLogAopQueryMapper.urlById(id, ips);
    }

}

