package com.headshow.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LF--liufang@maxrocky.com
 * @date 2018/4/17 11:41
 * @desc 附件表.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountPayDocAttItemDTO {

    //
    @JsonProperty("ZFILEID")
    private String zfileId;

    //
    @JsonProperty("FILETYPE")
    private String fileType;

    //
    @JsonProperty("FILENAME")
    private String fileName;

    //
    @JsonProperty("FILEURL")
    private String fileUrl;

    //
    @JsonProperty("PICTUREURL")
    private String pictureUrl;
}

