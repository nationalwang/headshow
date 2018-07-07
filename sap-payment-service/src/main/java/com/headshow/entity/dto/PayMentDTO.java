package com.headshow.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/11 16:10
 * @desc 表单数据实体.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMentDTO {

    //头信息
    @NotNull(message = "PayMent_0001")
    private FormInfoDTO formInfo;

    //表单信息
    private PayMentBusinessDataDTO businessData;
}

