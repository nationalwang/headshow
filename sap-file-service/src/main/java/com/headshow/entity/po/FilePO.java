package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文件实体PO
 * @author linlangleo
 * @date 2018-5-22 19:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilePO {
    private Integer id;

    private String fileName;

    private Integer fileTypeId;

    private Integer filePropertyId;

    private Double fileSize;

    private String fileSuffix;

    private String fileUrl;

    private Integer parentFolderId;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remark;
}