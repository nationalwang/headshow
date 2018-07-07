package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/17 11:41
 * @desc 附件表.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountPayDocAttItemPO {

    //
    private String zfileId;

    //
    private String fileType;

    //
    private String fileName;

    //
    private String fileUrl;

    //
    private String pictureUrl;

    //表单编号
    private String headId;

    //id
    private String id;
}

