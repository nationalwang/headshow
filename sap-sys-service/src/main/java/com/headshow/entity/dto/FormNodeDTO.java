package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "表单管理的节点实体")
@AllArgsConstructor
@NoArgsConstructor
public class FormNodeDTO {
  @ApiModelProperty(value = "id", example = "1")
  private Long id;

  @ApiModelProperty(value = "K2流程模板ID", example = "")
  private String k2_process_id;

  @ApiModelProperty(value = "K2流程节点ID", example = "")
  private String k2_node_id;

  @ApiModelProperty(value = "对应的页面名字", example = "")
  private String node_pagename;

//  @ApiModelProperty(value = "创建时间", example = "")
//  private LocalDateTime create_time;
//
//  @ApiModelProperty(value = "创建人", example = "")
//  private String create_by;
//
//  @ApiModelProperty(value = "最后一次修改时间", example = "")
//  private LocalDateTime update_time;
//
//  @ApiModelProperty(value = "最后一次修改人", example = "")
//  private String update_by;
//
//  @ApiModelProperty(value = "备注", example = "")
//  private String remark;
}
