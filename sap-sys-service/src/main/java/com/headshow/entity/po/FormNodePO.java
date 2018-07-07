package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fb_sap_form_node")
public class FormNodePO {

  //节点id
  @Id
  private Long id;

  //K2流程模板ID
  @Column(name = "k2_process_id")
  private String k2_process_id;

  //K2流程节点ID
  @Column(name = "k2_node_id")
  private String k2_node_id;

  //对应的页面名字
  @Column(name = "node_pagename")
  private String node_pagename;

  //创建时间
  @Column(name = "create_time")
  private LocalDateTime create_time;

  //创建人
  @Column(name = "create_by")
  private String create_by;

  //最后一次修改时间
  @Column(name = "update_time")
  private LocalDateTime update_time;

  //最后一次修改人
  @Column(name = "update_by")
  private String update_by;

  //备注
  @Column(name = "remark")
  private String remark;

}
