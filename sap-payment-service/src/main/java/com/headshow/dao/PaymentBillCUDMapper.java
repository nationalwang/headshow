package com.headshow.dao;


import com.headshow.entity.po.AccountPayDocAttItemPO;
import com.headshow.entity.po.AccountPayDocHeadPO;
import com.headshow.entity.po.AccountPayDocItemPO;
import com.headshow.entity.po.AccountPayDocSkdwItemPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 应付单的增删改Mapper
 */
public interface PaymentBillCUDMapper {
    /**
     *  插入应付单的数据到数据库
     */
    @Insert("INSERT INTO FB_SAP_PM_ACCOUNTPAYDOCHEAD (ID, YWSQDH, YWSQDGJZ, "
            + "MYQYGUID, YWLX, BUKRS,PRCTR, LYXT, K2SPH, YQFKSJ, HTH, FLG_DF, DFGS, DFLRZX, FLG_BDFGSYCL, "
            + "YBJE, BZ, ZDR, FLG_ZJKK, FLG_JJFK, LIFNR, SY, FLG_GYLRZ, GYLRZLX, HEADID) values "
            + "(#{id}, #{ywsqdh}, #{ywsqdgjz}, #{myqyguid}, #{ywlx}, #{bukrs}, #{prctr}, #{lyxt}, #{k2sph}, "
            + "#{yqfksj}, #{hth}, #{flgDf}, #{dfgs}, #{dflrzx}, #{flgBdfgsycl}, #{ybje}, #{bz}, #{zdr}, #{flgZjkk}, "
            + "#{flgJjfk}, #{lifnr}, #{sy}, #{flgGylrz}, #{gylrzlx}, #{headId})")
    void addPaymentBillAccountPayDocHead(AccountPayDocHeadPO accountPayDocHead);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  添加详情页
     */
    @Insert(" INSERT INTO FB_SAP_PM_ACCOUNTPAYDOCITEM (ID, FYLX, YSLY, "
            + "YSZYBM, HSRZBM, MBGS, "
            + "GZDW, YFDH, FLG_HTYF, "
            + "YJFHRQ, FLG_ZC, FLG_JGC, "
            + "FLG_YXWPFK, FLG_KHS, KXMC, "
            + "XMMC, XMQQ, TZKXLX, CBGLKM, "
            + "KKID, KKPP, WL, YBJE, "
            + "SY, HEADID)"
            + " VALUES (#{id}, #{fylx}, #{ysly}, "
            + "#{yszybm}, #{hsrzbm}, #{mbgs}, "
            + "#{gzdw}, #{yfdh}, #{flgHtyf}, "
            + "#{yjfhrq}, #{flgZc}, #{flgJgc}, "
            + "#{flgYxwpfk}, #{flgKhs}, #{kxmc}, "
            + "#{xmmc}, #{xmqq}, #{tzkxlx}, #{cbglkm}, "
            + "#{kkid}, #{kkpp}, #{wl}, #{ybje}, "
            + "#{sy}, #{headId})")
    void addPaymentBillAccountPayDocItem(AccountPayDocItemPO accountPayDocItem);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  添加详情页
     */
    @Insert("INSERT INTO FB_SAP_PM_ACCOUNTPAYDOCSITEM (ID, SKDW, SKDWHM,SKYHZH, KHYH, HEADID) "
            + "VALUES "
            + "(#{id}, #{skdw}, #{skdwhm}, #{skyhzh}, #{khyh}, #{headId})")
    void addPaymentBillAccountPayDocSkdwItem(AccountPayDocSkdwItemPO accountPayDocSkdwItem);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .删除应付单主记录
     */
    @Delete("DELETE FROM FB_SAP_PM_ACCOUNTPAYDOCHEAD WHERE HEADID = #{headId}")
    void deletepPayMentByHeadId(@Param("headId") String headid);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .删除应付单主记录
     */
    @Delete("DELETE FROM FB_SAP_PM_ACCOUNTPAYDOCITEM WHERE HEADID = #{headId}")
    void deletepPayPayDocItemByHeadId(@Param("headId") String headid);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .删除应付单主记录
     */
    @Delete("DELETE FROM FB_SAP_PM_ACCOUNTPAYDOCSITEM WHERE HEADID = #{headId}")
    void deletepPayDocSkdwItemByHeadId(@Param("headId") String headid);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .添加附件
     */
    @Insert("INSERT INTO FB_SAP_PM_ACCOUNTPAYDOCATTITEM (ID, ZFILEID, FILETYPE, FILENAME, FILEURL, PICTUREURL, HEADID) "
            + "VALUES "
            + "(#{id}, #{zfileId}, #{fileType}, #{fileName}, #{fileUrl}, #{pictureUrl}, #{headId})")
    void addPaymentBillAccountPayDocAttItem(AccountPayDocAttItemPO accountPayDocAttItem);

    /**
     * @author LF--liufang@maxrocky.com
     * @desc  .删除应付单主记录
     */
    @Delete("DELETE FROM FB_SAP_PM_ACCOUNTPAYDOCATTITEM WHERE HEADID = #{headId}")
    void deletepPayDocAttItemByHeadId(@Param("headId") String headid);
}
