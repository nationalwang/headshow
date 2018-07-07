package com.headshow.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文件性质实体DTO
 *
 * @author linlangleo
 * @date 2018-5-22 19:29
 */
@Data
@ApiModel(value = "文件性质实体")
@NoArgsConstructor
@AllArgsConstructor
public class FilePropertyDTO {
    @ApiModelProperty(value = "", example = "")
    private Integer id;

    @ApiModelProperty(value = "", example = "")
    private String propertyName;

    @ApiModelProperty(value = "", example = "")
    private String propertyCode;

    @ApiModelProperty(value = "", example = "")
    private Date createTime;

    @ApiModelProperty(value = "", example = "")
    private String createBy;

    @ApiModelProperty(value = "", example = "")
    private Date updateTime;

    @ApiModelProperty(value = "", example = "")
    private String updateBy;

    @ApiModelProperty(value = "", example = "")
    private String remark;
}