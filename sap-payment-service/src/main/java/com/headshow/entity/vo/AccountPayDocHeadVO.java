package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 应付单主表.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPayDocHeadVO {


    //业务申请单号
    private String ywsqdh;

    //业务系统单据关键字
    private String ywsqdgjz;

    //明源区域GUID
    private String myqyguid;

    //应付类型
    private String ywlx;

    //公司代码
    private String bukrs;

    //利润中心
    private String prctr;

    //来源系统
    private String lyxt;

    //K2审批号
    private String k2sph;

    //要求付款时间
    private String yqfksj;

    //合同号
    private String hth;

    //是否代付
    private String flgDf;

    //代付公司
    private String dfgs;

    //代付利润中心
    private String dflrzx;

    //被代付公司是否已成立
    private String flgBdfgsycl;

    //原币金额
    private String ybje;

    //币种
    private String bz;

    //制单人
    private String zdr;

    //追加扣款
    private String flgZjkk;

    //是否紧急付款
    private String flgJjfk;

    //供应商
    private String lifnr;

    //事由
    private String sy;

    //是否供应链融资
    private String flgGylrz;

    //供应链融资类型
    private String gylrzlx;


    //明细表1
    private List<AccountPayDocItemVO> item;

    //明细表
    private List<AccountPayDocSkdwItemVO> skdwItem;

    

}

