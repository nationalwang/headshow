package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @desc 附件明细表PO
 * @author linlangleo
 * @date 2018-04-19 17:03
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fb_sap_attitem")
public class AttItemPO {
  @Id
  private String id;

  //单号
  @Column(name = "headid")
  private String headId;

  //文件ID
  @Column(name = "zfileid")
  private String zfileid;

  //文件类型
  @Column(name = "filetype")
  private String filetype;

  //文件名
  @Column(name = "filename")
  private String filename;

  //附件系统URL
  @Column(name = "fileurl")
  private String fileurl;

  @Column(name = "pictureurl")
  private String pictureurl;

  //创建时间
  @Column(name = "create_time")
  private LocalDateTime create_time;

  //创建人
  @Column(name = "create_by")
  private String create_by;

  //最后一次更新时间
  @Column(name = "update_time")
  private LocalDateTime update_time;

  //最后一次更新人
  @Column(name = "update_by")
  private String update_by;

  //备注
  @Column(name = "remark")
  private String remark;
}
