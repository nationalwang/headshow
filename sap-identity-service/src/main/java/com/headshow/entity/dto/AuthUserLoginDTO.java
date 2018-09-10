package com.headshow.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author linlangleo
 * @desc 用户登陆验证实体
 * @date 2018-09-01 21:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserLoginDTO {

    @ApiModelProperty(value = "用户名", example = "")
    @NotBlank(message = "IDEN_ERR_0001")
    private String name;

    @ApiModelProperty(value = "密码", example = "")
    @NotBlank(message = "IDEN_ERR_0002")
    private String password;

    @ApiModelProperty(value = "删除标记", example = "")
    private String isDelete;

    @ApiModelProperty(value = "验证码", example = "")
    private String code;
}
