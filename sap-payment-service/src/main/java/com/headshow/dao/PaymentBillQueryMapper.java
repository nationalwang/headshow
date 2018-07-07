package com.headshow.dao;

import com.headshow.entity.po.AccountPayDocHeadPO;
import com.headshow.entity.po.AccountPayDocItemPO;
import com.headshow.entity.po.AccountPayDocSkdwItemPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 应付单的查询Mapper
 */
public interface PaymentBillQueryMapper {

    /**
     *  根据单号，获取应付单的所有数据
     */
    @Select("SELECT * FROM FB_SAP_PM_ACCOUNTPAYDOCHEAD WHERE HEADID = #{headId} ")
    @Results({
                    @Result(column = "ID", property = "id"),
                    @Result(column = "YWSQDH", property = "ywsqdh"),
                    @Result(column = "YWSQDGJZ", property = "ywsqdgjz"),
                    @Result(column = "MYQYGUID", property = "myqyguid"),
                    @Result(column = "YWLX", property = "ywlx"),
                    @Result(column = "BUKRS", property = "bukrs"),
                    @Result(column = "PRCTR", property = "prctr"),
                    @Result(column = "LYXT", property = "lyxt"),
                    @Result(column = "K2SPH", property = "k2sph"),
                    @Result(column = "YQFKSJ", property = "yqfksj"),
                    @Result(column = "HTH", property = "hth"),
                    @Result(column = "FLG_DF", property = "flgDf"),
                    @Result(column = "DFGS", property = "dfgs"),
                    @Result(column = "DFLRZX", property = "dflrzx"),
                    @Result(column = "FLG_BDFGSYCL", property = "flgBdfgsycl"),
                    @Result(column = "YBJE", property = "ybje"),
                    @Result(column = "BZ", property = "bz"),
                    @Result(column = "ZDR", property = "zdr"),
                    @Result(column = "FLG_ZJKK", property = "flgZjkk"),
                    @Result(column = "FLG_JJFK", property = "flgJjfk"),
                    @Result(column = "LIFNR", property = "lifnr"),
                    @Result(column = "SY", property = "sy"),
                    @Result(column = "FLG_GYLRZ", property = "flgGylrz"),
                    @Result(column = "GYLRZLX", property = "gylrzlx"),
                    @Result(column = "HEADID", property = "headId"),
                    @Result(property = "item", column = "HEADID", javaType = List.class,
                            many = @Many(select = "com.headshow.dao.PaymentBillQueryMapper.queryDetailone")),
                    @Result(property = "skdwItem", column = "HEADID", javaType = List.class,
                            many = @Many(select = "com.headshow.dao.PaymentBillQueryMapper.queryDetailtwo"))
                    })
    AccountPayDocHeadPO getPayAll(@Param("headId") String headId);

    /**
     * 根据单号，获取应付单的细节表1的所有数据
     */
    @Select("SELECT * FROM FB_SAP_PM_ACCOUNTPAYDOCITEM WHERE HEADID = #{headId}")
    @Results({
            @Result(column = "ID", property = "id"),
            @Result(column = "FYLX", property = "fylx"),
            @Result(column = "YSLY", property = "ysly"),
            @Result(column = "YSZYBM", property = "yszybm"),
            @Result(column = "HSRZBM", property = "hsrzbm"),
            @Result(column = "MBGS", property = "mbgs"),
            @Result(column = "GZDW", property = "gzdw"),
            @Result(column = "YFDH", property = "yfdh"),
            @Result(column = "FLG_HTYF", property = "flgHtyf"),
            @Result(column = "YJFHRQ", property = "yjfhrq"),
            @Result(column = "FLG_ZC", property = "flgZc"),
            @Result(column = "FLG_JGC", property = "flgJgc"),
            @Result(column = "FLG_YXWPFK", property = "flgYxwpfk"),
            @Result(column = "FLG_KHS", property = "flgKhs"),
            @Result(column = "KXMC", property = "kxmc"),
            @Result(column = "XMMC", property = "xmmc"),
            @Result(column = "XMQQ", property = "xmqq"),
            @Result(column = "CBGLKM", property = "cbglkm"),
            @Result(column = "KKID", property = "kkid"),
            @Result(column = "KKPP", property = "kkpp"),
            @Result(column = "WL", property = "wl"),
            @Result(column = "YBJE", property = "ybje"),
            @Result(column = "SY", property = "sy"),
            @Result(column = "HEADID", property = "headId"),
            @Result(column = "TZKXLX", property = "tzkxlx")
    })
    List<AccountPayDocItemPO> queryDetailone(@Param("headId") String headId);

    /**
     * 根据单号，获取应付单的细节表2的所有数据
     */
    @Select("SELECT * FROM FB_SAP_PM_ACCOUNTPAYDOCSITEM WHERE HEADID = #{headId}")
    List<AccountPayDocSkdwItemPO> queryDetailtwo(@Param("headId") String headId);

}
