package com.headshow.service.impl;

import com.headshow.common.utils.cookie.CookieUtils;
import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.common.utils.http.SysHttpUtils;
import com.headshow.dao.AuthUserQueryMapper;
import com.headshow.domain.constant.DeleteEnum;
import com.headshow.entity.dto.AuthUserLoginDTO;
import com.headshow.entity.po.AuthUserPO;
import com.headshow.service.AuthUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author linlangleo
 * @desc 用户操作 service实现类
 * @date 2018-09-01 21:49
 **/
@Service
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserQueryMapper authUserQueryMapper;

    @Resource
    private ExceptionManager exceptionManager;

    /**
     * 登陆方法
     * @param authUserLoginDTO
     */
    @Override
    public void login(AuthUserLoginDTO authUserLoginDTO) {
        //校验验证码是否正确
        checkCode(authUserLoginDTO.getCode());

        authUserLoginDTO.setIsDelete(DeleteEnum.ENABLE.getStatus());
        AuthUserPO user = authUserQueryMapper.getLoginUser(authUserLoginDTO);
        //未注册或者密码错误，提示用户名或者密码错误
        if(user == null) {
            throw exceptionManager.createByCode("IDEN_ERR_0004");
        }
        //生成token，保存用户登陆状态
        String token = CookieUtils.getUUTkoen();
    }


    private void checkCode(String code){
        HttpServletRequest request = SysHttpUtils.getHttpRequest();
        String codeSession = (String) request.getSession().getAttribute("code");
        if(StringUtils.isEmpty(codeSession)) {
            throw exceptionManager.createByCode("IDEN_ERR_0023");
        }
        if(StringUtils.isEmpty(code)) {
            throw exceptionManager.createByCode("IDEN_ERR_0024");
        }
        if(!codeSession.equalsIgnoreCase(code)) {
            throw exceptionManager.createByCode("IDEN_ERR_0025");
        }
    }

}
