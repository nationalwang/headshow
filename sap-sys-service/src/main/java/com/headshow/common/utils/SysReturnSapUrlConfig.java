package com.headshow.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/19 18:54
 * @desc 返回SAPurl工具.
 */
@Configuration
public class SysReturnSapUrlConfig {
    @Value("${ipSapUrl}")
    String ipSapUrl;
    @Value("${port}")
    String port;
    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .url公用方法 docId=表关联id tempID=模版id   moduleName=模块名
     */
    public String returnUrl(String docId, String tempID, String moduleName) {
        String newPort = "";
        if (!port.equals("80")) {
            newPort = ":" + port;
        }
        String url = "http://" + ipSapUrl + newPort + "/sap/" + moduleName + "/" + moduleName  + "Index.html?docID="
                + docId + "&tempID=" + tempID + "&act=";
        return url;
    }
}

