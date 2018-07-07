package com.headshow.service.impl;

import com.headshow.common.utils.SysReturnSapUrlConfig;
import com.headshow.common.utils.apiresult.ResultData;
import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.mapper.MapperUtils;
import com.headshow.dao.PaymentBillCUDMapper;
import com.headshow.dao.PaymentBillQueryMapper;
import com.headshow.entity.dto.PayMentDTO;
import com.headshow.entity.po.AccountPayDocHeadPO;
import com.headshow.entity.vo.AccountPayDocHeadVO;
import com.headshow.service.PaymentBillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * 应付单的业务层实现类
 */
@Service
public class PaymentBillServiceImpl implements PaymentBillService {
    @Resource
    PaymentBillCUDMapper paymentBillCUDMapper;
    @Resource
    PaymentBillQueryMapper paymentBIllQueryMapper;
    @Resource
    SysReturnSapUrlConfig sysReturnSapUrlConfig;
    @Resource
    ExceptionManager exceptionManager;
    /**
     * 添加用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData addPaymentBill(PayMentDTO paymentDTO) {
        //获取表单编号
        String docID = paymentDTO.getFormInfo().getDocID();
        //封装返回参数
        ResultData resultData = new ResultData();
        resultData.setDocID(docID);
        resultData.setProcessTempID(paymentDTO.getFormInfo().getProcessTempID());
        resultData.setFormURL(sysReturnSapUrlConfig.returnUrl(docID, paymentDTO.getFormInfo().getProcessTempID(), "payment"));
        //数据校验
        if (paymentDTO.getBusinessData().getAccPayDocRecord() == null) {
            return resultData;
        }
        //数据拷贝
        AccountPayDocHeadPO accountPayDocHead = MapperUtils.mapperBean(paymentDTO.getBusinessData().getAccPayDocRecord(),
             AccountPayDocHeadPO.class);
        //查询数据库并删除符合此id的数据
        paymentBillCUDMapper.deletepPayDocSkdwItemByHeadId(docID);
        paymentBillCUDMapper.deletepPayMentByHeadId(docID);
        paymentBillCUDMapper.deletepPayPayDocItemByHeadId(docID);
        paymentBillCUDMapper.deletepPayDocAttItemByHeadId(docID);
        //封装表单
        accountPayDocHead.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        accountPayDocHead.setHeadId(docID);
        //校验是否有item
        if (accountPayDocHead.getItem() != null && !accountPayDocHead.getItem().isEmpty()) {
        accountPayDocHead.getItem().stream().forEach(s -> {
            s.setHeadId(docID); s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            paymentBillCUDMapper.addPaymentBillAccountPayDocItem(s); });
        }
        //校验是否有Skdwitem
        if (accountPayDocHead.getSkdwItem() != null && !accountPayDocHead.getSkdwItem().isEmpty()) {
        accountPayDocHead.getSkdwItem().stream().forEach(s -> {
            s.setHeadId(docID); s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            paymentBillCUDMapper.addPaymentBillAccountPayDocSkdwItem(s); });
        }
         //校验是否有attitem
         if (accountPayDocHead.getAttitem() != null && !accountPayDocHead.getAttitem().isEmpty()) {
        accountPayDocHead.getAttitem().stream().forEach(s -> {
            s.setHeadId(docID); s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            paymentBillCUDMapper.addPaymentBillAccountPayDocAttItem(s); });
        }
        //表单头数据
        paymentBillCUDMapper.addPaymentBillAccountPayDocHead(accountPayDocHead);
        return resultData;
    }

    /**
     * 根据id查询应付表单数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountPayDocHeadVO getPayAll(String billsNumber) {
        AccountPayDocHeadPO result = paymentBIllQueryMapper.getPayAll(billsNumber);
        AccountPayDocHeadVO accountPayDocHead = MapperUtils.mapperBean(result, AccountPayDocHeadVO.class);
        return accountPayDocHead;
    }

}