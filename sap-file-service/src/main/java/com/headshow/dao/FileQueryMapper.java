package com.headshow.dao;

import com.headshow.entity.po.FilePO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author linlangleo
 * @date 2018/7/7 19:39
 * @desc 文件查询 dao层
 */

public interface FileQueryMapper {
    @Select("select * from file")
    List<FilePO> getFileInfo();
}
