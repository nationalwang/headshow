package com.headshow.service.impl;

import com.headshow.dao.FileQueryMapper;
import com.headshow.entity.po.FilePO;
import com.headshow.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linlangleo
 * @desc 文件操作service实现类
 * @date 2018-05-21 19:27
 **/
@Service
public class FileServiceImpl implements FileService {
    @Resource
    private FileQueryMapper fileQueryMapper;

    /**
     * 上传文件
     * @param myFile
     */
    @Override
    public void fileUpload(MultipartFile myFile) {

    }

    /**
     * 获取文件信息
     */
    @Override
    public List<FilePO> getFileInfo() {
        List<FilePO> filePOList = fileQueryMapper.getFileInfo();
        return filePOList;
    }
}
