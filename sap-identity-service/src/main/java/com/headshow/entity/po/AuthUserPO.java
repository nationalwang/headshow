package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author linlangleo
 * @desc 登陆用户 实体PO
 * @date 2018-09-02 11:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserPO {
    //主键
    private Long id;

    //用户名
    private String name;

    //密码
    private String pwd;

}
