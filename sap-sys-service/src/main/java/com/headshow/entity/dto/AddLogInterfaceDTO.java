package com.headshow.entity.dto;

import com.headshow.entity.enums.HttpTypeEnums;
import com.headshow.entity.enums.LogInterfaceStatusEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by beyondLi
 * Date 2018/4/11 21:39
 * Desc .新增log接口DTO
 */
@Data
@ApiModel(value = "添加接口信息")
@AllArgsConstructor
@NoArgsConstructor
public class AddLogInterfaceDTO {

    @ApiModelProperty(value = "接口名称", example = "插入sap数据")
    @NotBlank(message = "SYS_LOG_0001")
    private String interfaceName;

    @ApiModelProperty(value = "接口url", example = "/add/sap/info")
    @NotBlank(message = "SYS_LOG_0002")
    private String url;

    @ApiModelProperty(value = "请求方式", example = "GET")
    private HttpTypeEnums methodType;

    @ApiModelProperty(value = "方法名称", example = "addSapInfo")
    private String methodName;

    @ApiModelProperty(value = "每天允许最大请求次数", example = "1000")
    private Integer maxLimit;

    @ApiModelProperty(value = "接口状态", example = "OPEN")
    private LogInterfaceStatusEnums useStatus;

    @ApiModelProperty(value = "创建人", example = "beyondLi")
    private String createBy;

    @ApiModelProperty(value = "备注", example = "此接口是用来接收sap数据的")
    private String remark;
}
