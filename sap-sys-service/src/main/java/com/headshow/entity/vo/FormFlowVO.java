package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormFlowVO {

  //流程id
  private Long id;
  
  //模块id
  private String module_id;

  //模块名称 (需要二次查询)
  private String module_name;

  //流程名称
  private String flow_name;

  //K2流程模板ID
  private String k2_process_code;

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
