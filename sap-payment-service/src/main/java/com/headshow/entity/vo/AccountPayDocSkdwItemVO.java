package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 细节2.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPayDocSkdwItemVO {

    //收款单位
    private String skdw;

    //收款单位户名
    private String skdwhm;

    //收款银行账号
    private String skyhzh;

    //开户银行
    private String khyh;
}

