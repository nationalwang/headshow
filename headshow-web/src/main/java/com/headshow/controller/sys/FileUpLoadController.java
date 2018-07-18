//package com.headshow.controller.sys;
//
//import com.headshow.common.utils.apiresult.AbstractApiResult;
//import com.headshow.common.utils.exception.ExceptionManager;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.util.Random;
//
///**
// * @desc 文件上传controller
// * @author linlangleo
// * @date 2018-04-25 19:29
// **/
//@RestController
//@Api(value = "sap", tags = {"file"})
//@RequestMapping("/fileupload")
//public class FileUpLoadController {
//    @Resource
//    private ExceptionManager exceptionManager;
//
//    /**
//     * 文件上传
//     */
//    @ApiOperation(value = "文件上传", produces = "application/json")
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public AbstractApiResult fileUpLoad(MultipartFile myPicture, HttpServletRequest request, HttpServletResponse response){
//        String idPicPath = null;
//
//        try{
//            String name = myPicture.getOriginalFilename();//原文件名
//            System.out.println("uploadFile oldFileName =============>"+ name);
//            //判断文件是否为空
//            if(!myPicture.isEmpty()){
//                String path= request.getSession().getServletContext().getRealPath("file"+ File.separator+"uploadfiles");//上传路径
//                System.out.println("uploadFile path==================>" + path);
//                String oldFileName = myPicture.getOriginalFilename();//原文件名
////                System.out.println("uploadFile oldFileName =============>"+ oldFileName);
//                String suffix = FilenameUtils.getExtension(oldFileName);//原文件后缀
////                System.out.println("uploadFile prefixName =============>"+ prefix);
//                int filesize = 5000000;
////                System.out.println("uploadFile size ==============>" + myPicture.getSize());
//                if(myPicture.getSize() > filesize){ //上传文件大小不得超过5mb
//                    request.setAttribute("uploadFileError", "上传文件大小不得超过5mb");
//                    //throw
//                }else if(suffix.equalsIgnoreCase("jpg")||suffix.equalsIgnoreCase("png")||suffix.equalsIgnoreCase("jpeg")||suffix.equalsIgnoreCase("pneg")){
//                    String fileName = System.currentTimeMillis() + (new Random(1000000) + "_Personal.jpg");
//                    File targetFile = new File(path, fileName);
//                    if(!targetFile.getParentFile().exists()){
//                        targetFile.getParentFile().mkdirs();
//                    }
////                    targetFile.createNewFile();
//                    //保存
//                    try{
//                        myPicture.transferTo(targetFile);
//                    }catch (Exception e) {
//                        e.printStackTrace();
//                        request.setAttribute("uploadFileError", "上传失败");
//                        //throw
//                    }
//                    idPicPath = path + File.separator + fileName;
//                }else{
//                    request.setAttribute("uploadFileError", "上传图片文件格式不对");
//                    //throw
//                }
//
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//            //throw
//        }
//
////        try{
////            user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
////        }catch (Exception e) {
////            e.printStackTrace();
////        }
////        user.setCreationDate(new Date());
////        user.setIdPicPath(idPicPath);
////        if(userService.add(user)){
////            return "redirect:/user/userlist.html";
////        }
//        return AbstractApiResult.success(null);
//    }
//}
