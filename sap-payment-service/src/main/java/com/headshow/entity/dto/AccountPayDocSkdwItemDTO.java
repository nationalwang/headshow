package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/13 9:21
 * @desc 详细列表skdw.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPayDocSkdwItemDTO {
    //收款单位
    @JsonProperty("skdw")
    private String skdw;

    //收款单位户名
    @JsonProperty("skdwhm")
    private String skdwhm;

    //收款银行账号
    @JsonProperty("skyhzh")
    private String skyhzh;

    //开户银行
    @JsonProperty("khyh")
    private String khyh;
}

