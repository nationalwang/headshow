package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormNodeVO {

  //节点id
  private Long id;

  //K2流程模板ID
  private String k2_process_id;

  //K2流程节点ID
  private String k2_node_id;

  //对应的页面名字
  private String node_pagename;

  //创建时间
  private LocalDateTime create_time;

  //创建人
  private String create_by;

  //最后一次修改时间
  private LocalDateTime update_time;

  //最后一次修改人
  private String update_by;

  //备注
  private String remark;
}
