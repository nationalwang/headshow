package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 附件明细表DTO
 * @author linlangleo
 * @date 2018-04-19 17:11
 **/
@Data
@ApiModel(value = "附件明细表DTO")
@NoArgsConstructor
@AllArgsConstructor
public class AttItemDTO {
  //文件ID
  @ApiModelProperty(value = "文件ID", example = "")
  @JsonProperty("ZFILEID")
  private String zfileid;

  //文件类型
  @ApiModelProperty(value = "文件类型", example = "")
  @JsonProperty("FILETYPE")
  private String filetype;

  //文件名
  @ApiModelProperty(value = "文件名", example = "")
  @JsonProperty("FILENAME")
  private String filename;

  //附件系统URL
  @ApiModelProperty(value = "附件系统URL", example = "")
  @JsonProperty("FILEURL")
  private String fileurl;

  @ApiModelProperty(value = "图片路径", example = "")
  @JsonProperty("PICTUREURL")
  private String pictureurl;
}
