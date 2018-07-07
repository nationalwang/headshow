package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Desc .表单管理的模块实体
 * @by linlangleo
 */
@Data
@ApiModel(value = "表单管理的模块实体")
@AllArgsConstructor
@NoArgsConstructor
public class FormModuleDTO {
  @ApiModelProperty(value = "id", example = "1")
  private Long id;

  @ApiModelProperty(value = "模块编号", example = "file")
  private String module_code;

  @ApiModelProperty(value = "模块名称", example = "应收")
  private String module_name;

//  @ApiModelProperty(value = "创建时间", example = "2018-09-09")
//  private LocalDateTime create_time;
//
//  @ApiModelProperty(value = "创建人", example = "admin")
//  private String create_by;
//
//  @ApiModelProperty(value = "最后一次修改人", example = "admin")
//  private String update_by;
//
//  @ApiModelProperty(value = "最后一次修改时间", example = "2018-09-09")
//  private LocalDateTime update_time;
//
//  @ApiModelProperty(value = "备注", example = "")
//  private String remark;
}
