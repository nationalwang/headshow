package com.headshow.controller.payment;

import com.headshow.common.tools.annotation.SapApiLog;
import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.common.utils.apiresult.ResultData;
import com.headshow.entity.dto.PayMentDTO;
import com.headshow.entity.vo.AccountPayDocHeadVO;
import com.headshow.service.PaymentBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 应付单的controller
 */
@Api(value = "应付表单", tags = {"payment"})
@RestController
@RequestMapping(value = "/payment")

public class PaymentController {

    @Resource
    PaymentBillService paymentBillService;

    /**
     * 提供给SAP 调用，从SAP 获取表单数据，进行处理
     */
    @RequestMapping(value = "/savepaymentall", method = RequestMethod.POST)
    @ApiOperation(value = "保存AP001-应付单生成接口", produces = "application/json")
    public AbstractApiResult savePaymentAll(@RequestBody PayMentDTO payMentDTO) {
        //存入到数据库里面
        ResultData resultData = paymentBillService.addPaymentBill(payMentDTO);
        return AbstractApiResult.success(resultData);
    }

    /**
     * .k2调用的应付显示接口
     */
    @RequestMapping(value = "/getpaymentall/{billsNumber}", method = RequestMethod.GET)
    @ApiOperation(value = "查看AP001-应付单生成接口", produces = "application/json")
    @SapApiLog
    public AbstractApiResult getPaymentAll(@PathVariable String billsNumber) {
        AccountPayDocHeadVO result = paymentBillService.getPayAll(billsNumber);
        return AbstractApiResult.success(result);

    }
}
