package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/11 16:15
 * @desc .
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMentBusinessDataDTO {

    //表单头
    @JsonProperty("AccPayDocRecord")
    private AccoutPayDocHeadDTO accPayDocRecord;

}

