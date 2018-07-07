package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 细节1.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPayDocItemVO {

    //费用类型
    private String fylx;

    //预算来源
    private String ysly;

    //预算占用部门(基金中心)
    private String yszybm;

    //核算入账部门(成本中心)
    private String hsrzbm;

    //目标公司
    private String mbgs;

    //挂账单位
    private String gzdw;

    //原预付单据号
    private String yfdh;

    //是否合同预付
    private String flgHtyf;

    //预计返还日期
    private String yjfhrq;

    //是否资产
    private String flgZc;

    //是否甲供材
    private String flgJgc;

    //是否允许无票付款
    private String flgYxwpfk;

    //是否可回收
    private String flgKhs;

    //款项名称
    private String kxmc;

    //项目名称
    private String xmmc;

    //项目期区
    private String xmqq;

    //投策款项类型
    private String tzkxlx;

    // 成本管理科目
    private String cbglkm;

    //扣款ID
    private String kkid;

    //扣款KKPP
    private String kkpp;

    //物料（大类）
    private String wl;

    //原币金额
    private String ybje;

    //事由
    private String sy;
}

