package com.headshow.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 文件夹实体PO
 * @author linlangleo
 * @date 2018-5-22 19:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderPO {
    private Integer id;

    private String folderName;

    private Integer parentFolderId;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remark;
}