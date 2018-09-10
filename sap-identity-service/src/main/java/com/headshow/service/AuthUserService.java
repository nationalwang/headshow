package com.headshow.service;

import com.headshow.entity.dto.AuthUserLoginDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author linlangleo
 * @desc 用户操作 service接口
 * @date 2018-09-01 21:49
 **/
@Validated
public interface AuthUserService {
    /**
     * 登陆方法
     * @param authUserLoginDTO
     */
    void login(@Valid AuthUserLoginDTO authUserLoginDTO);
}
