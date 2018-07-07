----------------------------
-----------user(用户表)
---------------------------
CREATE TABLE IF NOT EXISTS `proceeds` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for FB_SAP_AR_FLOORDEDFUNDHEAD AR-IF017主表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_ar_floordedfundhead` (
`id`  int(20) unsigned NOT NULL AUTO_INCREMENT ,
`headid`  varchar(100) NULL ,
`zdjh`  varchar(100) NULL COMMENT '单据号' ,
`ernam`  varchar(100) NULL COMMENT '创建对象的人员名称' ,
`zshr`  varchar(100) NULL COMMENT '审核人' ,
`zdjrq`  varchar(100) NULL COMMENT '单据日期' ,
`zdjzt`  varchar(100) NULL COMMENT '单据状态' ,
`zshrq`  varchar(100) NULL COMMENT '审核日期' ,
`prctr`  varchar(100) NULL COMMENT '应收利润中心' ,
`zprctr`  varchar(100) NULL COMMENT '应付利润中心' ,
`bukrs`  varchar(100) NULL COMMENT '公司代码' ,
`zskdh`  varchar(100) NULL COMMENT 'SAP_ID' ,
`zdjlx`  varchar(100) NULL COMMENT '单据类型' ,
`budat`  varchar(100) NULL COMMENT '凭证中的过帐日期' ,
`belnr`  varchar(100) NULL COMMENT '会计凭证号码' ,
`bktxt`  varchar(100) NULL COMMENT '抬头摘要' ,
`erdat`  varchar(100) NULL COMMENT '创建日期' ,
`zspzt`  varchar(100) NULL COMMENT '审批状态' ,
`zpzzt`  varchar(100) NULL COMMENT '凭证状态' ,
`zdlklx`  varchar(100) NULL COMMENT '抵楼款类型' ,
`create_by`  varchar(100) NULL COMMENT '创建人' ,
`update_by`  varchar(100) NULL COMMENT '修改人' ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`update_time`  datetime NULL COMMENT '修改时间' ,
`remark`  varchar(255) NULL ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='R-IF017主表';

-- ----------------------------
-- Table structure for FB_SAP_AR_FLOORDEDFUNDITEM IF017详情表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_ar_floordedfunditem` (
`id`  int(30) unsigned NOT NULL AUTO_INCREMENT,
`headid`  varchar(100) NULL ,
`zskdh`  varchar(100) NULL ,
`zhxh`  varchar(100) NULL ,
`zfjdm`  varchar(100) NULL ,
`dmbtr`  varchar(100) NULL ,
`zbhsj`  varchar(100) NULL ,
`zyfdh`  varchar(100) NULL ,
`buzei`  varchar(100) NULL ,
`kunnr`  varchar(100) NULL ,
`zkxmx`  varchar(100) NULL ,
`mwskz`  varchar(100) NULL ,
`bukrs`  varchar(100) NULL ,
`zxm`  varchar(100) NULL ,
`zhdjh`  varchar(100) NULL ,
`zcplx`  varchar(100) NULL ,
`zse`  varchar(100) NULL ,
`zhxzt`  varchar(100) NULL ,
`sgtxt`  varchar(100) NULL ,
`zhxmzt`  varchar(100) NULL ,
`zxmdm`  varchar(100) NULL ,
`create_by`  varchar(100) NULL ,
`update_by`  varchar(100) NULL ,
`create_time`  datetime NULL ,
`update_time`  datetime NULL ,
`remark`  varchar(255) NULL ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='AR-IF017详情表';