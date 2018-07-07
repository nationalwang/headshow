package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/13 9:11
 * @desc 应付单抬头.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccoutPayDocHeadDTO {

    //业务申请单号
    @JsonProperty("ywsqdh")
    private String ywsqdh;

    //业务系统单据关键字
    @JsonProperty("ywsqdgjz")
    private String ywsqdgjz;

    //明源区域GUID
    @JsonProperty("myqyguid")
    private String myqyguid;

    //应付类型
    @JsonProperty("ywlx")
    private String ywlx;

    //公司代码
    @JsonProperty("bukrs")
    private String bukrs;

    //利润中心
    @JsonProperty("prctr")
    private String prctr;

    //来源系统
    @JsonProperty("lyxt")
    private String lyxt;

    //K2审批号
    @JsonProperty("k2sph")
    private String k2sph;

    //要求付款时间
    @JsonProperty("yqfksj")
    private String yqfksj;

    //合同号
    @JsonProperty("hth")
    private String hth;

    //是否代付
    @JsonProperty("flg_df")
    private String flgDf;

    //代付公司
    @JsonProperty("dfgs")
    private String dfgs;

    //代付利润中心
    @JsonProperty("dflrzx")
    private String dflrzx;

    //被代付公司是否已成立
    @JsonProperty("flg_bdfgsycl")
    private String flgBdfgsycl;

    //原币金额
    @JsonProperty("ybje")
    private String ybje;

    //币种
    @JsonProperty("bz")
    private String bz;

    //制单人
    @JsonProperty("zdr")
    private String zdr;

    //追加扣款
    @JsonProperty("flg_zjkk")
    private String flgZjkk;

    //是否紧急付款
    @JsonProperty("flg_jjfk")
    private String flgJjfk;

    //供应商
    @JsonProperty("lifnr")
    private String lifnr;

    //事由
    @JsonProperty("sy")
    private String sy;

    //是否供应链融资
    @JsonProperty("flg_gylrz")
    private String flgGylrz;

    //供应链融资类型
    @JsonProperty("gylrzlx")
    private String gylrzlx;

    //明细表1
    private List<AccountPayDocItemDTO> item;

    //明细表
    private List<AccountPayDocSkdwItemDTO> skdwItem;

    //附件表
    private List<AccountPayDocAttItemDTO> attitem;

}

