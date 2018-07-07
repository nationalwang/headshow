package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/13 9:19
 * @desc 详细列表.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountPayDocItemDTO {
    //费用类型
    @JsonProperty("fylx")
    private String fylx;

    //预算来源
    @JsonProperty("ysly")
    private String ysly;

    //预算占用部门(基金中心)
    @JsonProperty("yszybm")
    private String yszybm;

    //核算入账部门(成本中心)
    @JsonProperty("hsrzbm")
    private String hsrzbm;

    //目标公司
    @JsonProperty("mbgs")
    private String mbgs;

    //挂账单位
    @JsonProperty("gzdw")
    private String gzdw;

    //原预付单据号
    @JsonProperty("yfdh")
    private String yfdh;

    //是否合同预付
    @JsonProperty("flg_htyf")
    private String flgHtyf;

    //预计返还日期
    @JsonProperty("yjfhrq")
    private String yjfhrq;

    //是否资产
    @JsonProperty("flg_zc")
    private String flgZc;

    //是否甲供材
    @JsonProperty("flg_jgc")
    private String flgJgc;

    //是否允许无票付款
    @JsonProperty("flg_yxwpfk")
    private String flgYxwpfk;

    //是否可回收
    @JsonProperty("flg_khs")
    private String flgKhs;

    //款项名称
    @JsonProperty("kxmc")
    private String kxmc;

    //项目名称
    @JsonProperty("xmmc")
    private String xmmc;

    //项目期区
    @JsonProperty("xmqq")
    private String xmqq;

    //投策款项类型
    @JsonProperty("tzkxlx")
    private String tzkxlx;

    // 成本管理科目
    @JsonProperty("cbglkm")
    private String cbglkm;

    //扣款ID
    @JsonProperty("kkid")
    private String kkid;

    //扣款KKPP
    @JsonProperty("kkpp")
    private String kkpp;

    //物料（大类）
    @JsonProperty("wl")
    private String wl;

    //原币金额
    @JsonProperty("ybje")
    private String ybje;

    //事由
    @JsonProperty("sy")
    private String sy;
}

