----------------------------
-----------user(用户表)
---------------------------
CREATE TABLE IF NOT EXISTS `funds` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for FB_SAP_FM_SPECTRANSRATTITEM TR096明细表
-- ----------------------------
CREATE TABLE IF NOT EXISTS`fb_sap_fm_spectransrattitem` (
`id`  int(30) unsigned NOT NULL AUTO_INCREMENT,
`headid`  varchar(100) NOT NULL ,
`znum`  varchar(100) NULL ,
`zdjrq`  varchar(100) NULL ,
`zscom`  varchar(100) NULL ,
`zscom_t`  varchar(100) NULL ,
`zspc`  varchar(100) NULL ,
`zspc_t`  varchar(100) NULL ,
`zskqy`  varchar(100) NULL ,
`zskbk`  varchar(100) NULL ,
`zskbk_t`  varchar(100) NULL ,
`zcdxz`  varchar(100) NULL ,
`zcdxz_t`  varchar(100) NULL ,
`znbzh`  varchar(100) NULL ,
`znbzh_t`  varchar(100) NULL ,
`zssffz`  varchar(100) NULL ,
`zsbb`  varchar(100) NULL ,
`zsbb_t`  varchar(100) NULL ,
`zszjyt`  varchar(100) NULL ,
`zszjyt_t`  varchar(100) NULL ,
`zfkgs`  varchar(100) NULL ,
`zfkgs_t`  varchar(100) NULL ,
`zfklrzx`  varchar(100) NULL ,
`zfklrzx_t`  varchar(100) NULL ,
`zfkqy`  varchar(100) NULL ,
`zfkbk`  varchar(100) NULL ,
`zfkbk_t`  varchar(100) NULL ,
`zffcdxz`  varchar(100) NULL ,
`zffcdxz_t`  varchar(100) NULL ,
`zffnbzh`  varchar(100) NULL ,
`zffnbzh_t`  varchar(100) NULL ,
`zfsffz`  varchar(100) NULL ,
`zfbb`  varchar(100) NULL ,
`zfbb_t`  varchar(100) NULL ,
`zzjyt`  varchar(100) NULL ,
`zzjyt_t`  varchar(100) NULL ,
`zzjlx`  varchar(100) NULL ,
`zzjlx_t`  varchar(100) NULL ,
`zje`  varchar(100) NULL ,
`zbz`  varchar(100) NULL ,
`erdat`  varchar(100) NULL ,
`ernam`  varchar(100) NULL ,
`aedat`  varchar(100) NULL ,
`aenam`  varchar(100) NULL ,
`create_by`  varchar(100) NULL ,
`update_by`  varchar(100) NULL ,
`create_time`  datetime NULL ,
`update_time`  datetime NULL ,
`remark`  varchar(100) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='TR096明细表';
-- ----------------------------
-- Table structure for FB_SAP_FM_SPECTRANSRHEAD  TR096主表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_fm_spectransrhead` (
`id`  int(20) unsigned NOT NULL AUTO_INCREMENT,
`headid`  varchar(100) NOT NULL ,
`zdjbh`  varchar(100) NULL COMMENT '单据编号' ,
`zcom`  varchar(100) NULL COMMENT '公司代码' ,
`butxt`  varchar(100) NULL COMMENT '公司代码描述' ,
`zpc`  varchar(100) NULL ,
`ktext`  varchar(100) NULL ,
`zddfx`  varchar(100) NULL ,
`zddfxn`  varchar(100) NULL ,
`zdjlx`  varchar(100) NULL ,
`zddlyn`  varchar(100) NULL ,
`erdat`  varchar(100) NULL ,
`ernam`  varchar(100) NULL ,
`create_by`  varchar(100) NULL ,
`update_by`  varchar(100) NULL ,
`create_time`  datetime NULL ,
`update_time`  datetime NULL ,
`remark`  varchar(100) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='TR096主表';