package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 表单的基础信息:单号和流程模板ID
 */
@Data
@ApiModel(value = "表单基础信息")
@AllArgsConstructor
@NoArgsConstructor
public class FormInfoDTO {
	
    //单号
    @ApiModelProperty(value = "每一个流程的单号", example = "98K")
    @NotBlank(message = "SAP_VALIDATE_001")
    private String docID;

    //流程模板ID
    @ApiModelProperty(value = "每一个流程的流程编号", example = "TR001")
    @NotBlank(message = "SAP_VALIDATE_001")
    private String processTempID;
}
