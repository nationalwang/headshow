package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fb_sap_form_flow")
public class FormFlowPO {

  //流程id
  @Id
  private Long id;

  //模块id
  @Column(name = "module_id")
  private String module_id;

  //流程名称
  @Column(name = "flow_name")
  private String flow_name;

  //K2流程模板ID
  @Column(name = "k2_process_code")
  private String k2_process_code;

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
