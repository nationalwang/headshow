package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Desc .表单管理的模块实体
 * @by linlangleo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fb_sap_form_module")
public class FormModulePO {

  //模块id
  @Id
  private Long id;
  
  //模块code
  @Column(name = "module_code")
  private String module_code;

  //模块名称
  @Column(name = "module_name")
  private String module_name;

  //创建时间
  @Column(name = "create_time")
  private LocalDateTime create_time;

  //创建人
  @Column(name = "create_by")
  private String create_by;

  //最后一次修改人
  @Column(name = "update_by")
  private String update_by;

  //最后一次修改时间
  @Column(name = "update_time")
  private LocalDateTime update_time;

  //备注
  @Column(name = "remark")
  private String remark;

}
