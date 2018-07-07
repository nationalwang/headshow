package com.headshow.entity.po;

import com.headshow.entity.enums.HttpTypeEnums;
import com.headshow.entity.enums.LogInterfaceStatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by beyondLi
 * Date 2018/4/11 21:39
 * Desc .新增log接口DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInterfaceInfoPO {
    //id
    private Integer id;
    //接口名称
    private String interfaceName;
    //url
    private String url;
    //请求方式
    private HttpTypeEnums methodType;
    //方法名称
    private String methodName;
    //每天允许最大请求次数
    private Integer maxLimit;
    //接口状态
    private LogInterfaceStatusEnums useStatus;
    //备注
    private String remark;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime updateTime;

}
