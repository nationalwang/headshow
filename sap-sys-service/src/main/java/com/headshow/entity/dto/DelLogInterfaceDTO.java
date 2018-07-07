package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by beyondLi
 * Date 2018/4/11 21:39
 * Desc .新增log接口DTO
 */
@Data
@ApiModel(value = "删除接口信息")
@AllArgsConstructor
@NoArgsConstructor
public class DelLogInterfaceDTO {

    @ApiModelProperty(value = "接口名称", example = "[1,2,3,4,5]")
    private List<Integer> ids;

}
