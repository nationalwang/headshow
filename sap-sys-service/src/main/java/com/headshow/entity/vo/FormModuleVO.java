package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormModuleVO {

  //模块id
  private Long id;
  
  //模块code
  private String module_code;

  //模块名称
  private String module_name;

  //创建时间
  private LocalDateTime create_time;

  //创建人
  private String create_by;

  //最后一次修改人
  private String update_by;

  //最后一次修改时间
  private LocalDateTime update_time;

  //备注
  private String remark;

}
