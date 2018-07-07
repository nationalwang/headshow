package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文件类型实体VO
 * @author linlangleo
 * @date 2018-5-22 19:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileTypeVO {
    private Integer id;

    private String typeName;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remark;
}