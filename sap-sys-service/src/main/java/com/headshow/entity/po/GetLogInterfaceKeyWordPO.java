package com.headshow.entity.po;

import com.headshow.entity.enums.HttpTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by beyondLi
 * Date 2018/4/11 21:39
 * Desc .新增log接口DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLogInterfaceKeyWordPO {
    //接口名
    private String interfaceName;
    //url
    private String url;
    //请求方式
    private HttpTypeEnums methodType;
}
