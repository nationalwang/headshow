package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel(value = "表单管理的流程实体")
@AllArgsConstructor
@NoArgsConstructor
public class FormFlowDTO {
  @ApiModelProperty(value = "id", example = "1")
  private Long id;

  @ApiModelProperty(value = "模块id", example = "1")
  private String module_id;

  @ApiModelProperty(value = "流程名称", example = "流程登记流程")
  private String flow_name;

  @ApiModelProperty(value = "K2流程模板ID", example = "")
  private String k2_process_code;

//  @ApiModelProperty(value = "创建时间", example = "2018-09-09")
//  private LocalDateTime create_time;
//
//  @ApiModelProperty(value = "创建人", example = "admin")
//  private String create_by;
//
//  @ApiModelProperty(value = "最后一次修改时间", example = "2018-09-09")
//  private LocalDateTime update_time;
//
//  @ApiModelProperty(value = "最后一次修改人", example = "admin")
//  private String update_by;
//
//  @ApiModelProperty(value = "备注", example = "")
//  private String remark;

}
