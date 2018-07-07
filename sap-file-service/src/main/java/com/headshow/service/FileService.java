package com.headshow.service;

import com.headshow.entity.po.FilePO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author linlangleo
 * @desc 文件操作service接口
 * @date 2018-05-21 19:27
 **/
@Validated
public interface FileService {
    /**
     * 上传文件
     * @param myFile
     */
    void fileUpload(MultipartFile myFile);

    /**
     * 获取文件信息
     */
    List<FilePO> getFileInfo();
}
