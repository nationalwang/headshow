package com.headshow.controller.identity;

import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.common.utils.code.CodeUtils;
import com.headshow.entity.dto.AuthUserLoginDTO;
import com.headshow.service.AuthUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author linlangleo
 * @desc 登陆相关controller
 * @date 2018-05-28 22:23
 **/
@RestController
@Api(value = "back", tags = {"identity"})
@RequestMapping(value = "/log")
public class LoginController {
    @Resource
    private AuthUserService authUserService;

    @ApiOperation(value = "登陆方法", produces = "application/json")
    @PostMapping(value = "/login")
    public AbstractApiResult login(@RequestBody AuthUserLoginDTO authUserLoginDTO) {
        authUserService.login(authUserLoginDTO);

        return AbstractApiResult.success("");
    }

    @ApiOperation(value = "获取验证码方法", produces = "application/json")
    @PostMapping(value = "/code/check.jpg")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 通知浏览器不要缓存
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        CodeUtils util = CodeUtils.Instance();
        // 将验证码输入到session中，用来验证
        String code = util.getString();
        System.err.println(code);
        request.getSession().setAttribute("code", code);
        // 输出打web页面
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
    }
}
