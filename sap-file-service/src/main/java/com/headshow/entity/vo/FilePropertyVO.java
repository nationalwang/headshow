package com.headshow.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文件性质实体VO
 * @author linlangleo
 * @date 2018-5-22 19:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilePropertyVO {
    private Integer id;

    private String propertyName;

    private String propertyCode;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remark;
}