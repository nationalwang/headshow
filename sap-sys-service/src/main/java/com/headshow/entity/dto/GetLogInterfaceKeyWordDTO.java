package com.headshow.entity.dto;

import com.headshow.entity.enums.HttpTypeEnums;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by beyondLi
 * Date 2018/4/11 21:39
 * Desc .新增log接口DTO
 */
@Data
@ApiModel(value = "获取接口信息筛选条件")
@AllArgsConstructor
@NoArgsConstructor
public class GetLogInterfaceKeyWordDTO {


    @ApiModelProperty(value = "接口名称", example = "数据")
    private String interfaceName;

    @ApiModelProperty(value = "接口url", example = "add")
    private String url;

    @ApiModelProperty(value = "请求方式", example = "POST")
    private HttpTypeEnums methodType;

}
