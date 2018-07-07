package com.headshow.controller.file;

import com.headshow.common.utils.apiresult.AbstractApiResult;
import com.headshow.common.utils.exception.ExceptionManager;
import com.headshow.entity.po.FilePO;
import com.headshow.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @desc 文件上传controller
 * @author linlangleo
 * @date 2018-5-20 19:29
 **/
@RestController
@Api(value = "sap", tags = {"fileoperate"})
@RequestMapping("/file")
public class FileController {
    @Resource
    private FileService fileService;
    @Resource
    private ExceptionManager exceptionManager;

    /**
     * 文件上传
     */
    @ApiOperation(value = "文件上传", produces = "application/json")
    @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
    public AbstractApiResult fileUpLoad(MultipartFile myFile, HttpServletRequest request){
        String idPicPath = null;

        try{
            String name = myFile.getOriginalFilename();//原文件名
            System.out.println("uploadFile oldFileName =============>"+ name);
            //判断文件是否为空
            if(!myFile.isEmpty()){
//                String path= request.getSession().getServletContext().getRealPath("file"+ File.separator+"uploadfiles");//上传路径
                String path= "/data/nfs/client";
                System.out.println("uploadFile path==================>" + path);
                String oldFileName = myFile.getOriginalFilename();//原文件名
                System.out.println("uploadFile oldFileName =============>"+ oldFileName);
                String suffix = FilenameUtils.getExtension(oldFileName);//原文件后缀
                System.out.println("uploadFile prefixName =============>"+ suffix);
                int filesize = 50000000;//50MB
                System.out.println("uploadFile size ==============>" + myFile.getSize());
                if(myFile.getSize() > filesize){ //上传文件大小不得超过50mb
                    throw exceptionManager.createByMessage("上传文件大小不得超过50MB");
                }else{
//                    String fileName = System.currentTimeMillis() + (new Random(1000000) + "_Personal.jpg");
                    String fileName = oldFileName;
                    File targetFile = new File(path, fileName);
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    //下面的transferTo()方法会同时调用
//                    targetFile.createNewFile();
                    //保存
                    try{
                        myFile.transferTo(targetFile);
                    }catch (Exception e) {
                        e.printStackTrace();
                        throw exceptionManager.createByMessage("上传失败");
                    }
                    idPicPath = path + File.separator + fileName;
                }

            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return AbstractApiResult.success(null);
    }

    /**
     * 获取文件信息
     */
    @ApiOperation(value = "获取文件信息", produces = "application/json")
    @PostMapping(value = "/getfileinfo")
    public AbstractApiResult getFileInfo() {
        List<FilePO> filePOList = fileService.getFileInfo();
        return AbstractApiResult.success(filePOList);
    }
}
