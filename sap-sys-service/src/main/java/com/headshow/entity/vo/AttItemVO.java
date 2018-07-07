package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc 附件明细表VO
 * @author linlangleo
 * @date 2018-04-19 17:10
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttItemVO {
  private String id;

  //单号
  private String headId;

  //文件ID
  private String zfileid;

  //文件类型
  private String filetype;

  //文件名
  private String filename;

  //附件系统URL
  private String fileurl;

  private String pictureurl;
}
