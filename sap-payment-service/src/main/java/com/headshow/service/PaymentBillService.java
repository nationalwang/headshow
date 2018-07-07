package com.headshow.service;


import com.headshow.common.utils.apiresult.ResultData;
import com.headshow.entity.dto.PayMentDTO;
import com.headshow.entity.vo.AccountPayDocHeadVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * 应付单的业务层接口
 */
@Validated
public interface PaymentBillService {

    /**
     * 新增应付单
     */
    ResultData addPaymentBill(@Valid PayMentDTO payMentDTO);

    /**
     * 根据id查询表单数据
     */
    AccountPayDocHeadVO getPayAll(String billsNumber);

}
