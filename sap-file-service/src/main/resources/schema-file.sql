----------------------------
-----------user(用户表)
---------------------------
CREATE TABLE IF NOT EXISTS `cost` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for FB_SAP_CS_INITBUDATTITEM FM045一般预算初始化导入接口(SAP-表单）
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `fb_sap_cs_initbudattitem` (
`id`  int(30) unsigned NOT NULL AUTO_INCREMENT ,
`zfileid`  varchar(50) NULL ,
`filetype`  varchar(50) NULL ,
`filename`  varchar(100) NULL ,
`fileurl`  varchar(100) NULL ,
`headid`  varchar(50) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM045一般预算初始化导入接口(SAP-表单）附表';

-- ----------------------------
-- Table structure for FB_SAP_CS_INITBUDHEAD FM045一般预算初始化导入接口(SAP-表单）
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `fb_sap_cs_initbudhead` (
`id` int(30) unsigned NOT NULL AUTO_INCREMENT ,
`xjdh`  varchar(50) NULL ,
`fikrs`  varchar(50) NULL ,
`gjahr`  varchar(50) NULL ,
`tijr`  varchar(50) NULL ,
`tjrq`  varchar(50) NULL ,
`wbzy`  varchar(255) NULL ,
`headid`  varchar(50) NULL ,
`create_by`  varchar(50) NULL ,
`update_by`  varchar(50) NULL ,
`create_time`  datetime NULL ,
`update_time`  datetime NULL ,
`remark`  varchar(100) NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM045一般预算初始化导入接口(SAP-表单）主表';

-- ----------------------------
-- Table structure for FB_SAP_CS_INITBUDITEM FM045一般预算初始化导入接口(SAP-表单）
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_cs_initbuditem` (
`id`  int(30) unsigned NOT NULL AUTO_INCREMENT ,
`xjdh`  varchar(50) NULL ,
`djhh`  varchar(50) NULL ,
`fictr`  varchar(50) NULL ,
`beschr`  varchar(50) NULL ,
`fund`  varchar(50) NULL ,
`bezeich`  varchar(50) NULL ,
`tval01`  varchar(50) NULL ,
`tval02`  varchar(50) NULL ,
`tval03`  varchar(50) NULL ,
`tval04`  varchar(50) NULL ,
`tval05`  varchar(50) NULL ,
`tval06`  varchar(50) NULL ,
`tval07`  varchar(50) NULL ,
`tval08`  varchar(50) NULL ,
`tval09`  varchar(50) NULL ,
`tval10`  varchar(50) NULL ,
`tval11`  varchar(50) NULL ,
`tval12`  varchar(50) NULL ,
`tval99`  varchar(50) NULL ,
`bzxx`  varchar(50) NULL ,
`headid`  varchar(100) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM045一般预算初始化导入接口(SAP-表单）明细表';

-- ----------------------------
-- Table structure for FB_SAP_CS_CONSBUDGETATTITEM
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `fb_sap_cs_consbudgetattitem` (
`id`   int(30) unsigned NOT NULL AUTO_INCREMENT ,
`zfileid`  varchar(50) NULL ,
`filetype`  varchar(50) NULL ,
`filename`  varchar(100) NULL ,
`fileurl`  varchar(100) NULL ,
`headid`  varchar(50) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM053-预算执行结果管理-消耗预算调整单接口-（SAP-表单）附表';

-- ----------------------------
-- Table structure for FB_SAP_CS_CONSBUDGETHEAD
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `fb_sap_cs_consbudgethead` (
`id`   int(30) unsigned NOT NULL AUTO_INCREMENT ,
`tzdh`  varchar(50) NULL ,
`fikrs`  varchar(50) NULL ,
`djlx`  varchar(50) NULL ,
`gjahr`  varchar(50) NULL ,
`tizr`  varchar(50) NULL ,
`tzrq`  varchar(50) NULL ,
`ysly`  varchar(100) NULL ,
`fund`  varchar(100) NULL ,
`wbzy`  varchar(100) NULL ,
`headid`  varchar(50) NULL ,
`create_by`  varchar(50) NULL ,
`update_by`  varchar(50) NULL ,
`create_time`  datetime NULL ,
`update_time`  datetime NULL ,
`remark`  varchar(100) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM053-预算执行结果管理-消耗预算调整单接口-（SAP-表单）主表';

-- ----------------------------
-- Table structure for FB_SAP_CS_CONSBUDGETITEM
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `fb_sap_cs_consbudgetitem` (
`id`   int(30) unsigned NOT NULL AUTO_INCREMENT,
`tzdh`  varchar(50) NULL ,
`djhh`  varchar(50) NULL ,
`fictr`  varchar(50) NULL ,
`bezeich`  varchar(50) NULL ,
`fylx`  varchar(50) NULL ,
`fyms`  varchar(50) NULL ,
`ysqj`  varchar(50) NULL ,
`adjst`  varchar(50) NULL ,
`bzxx`  varchar(50) NULL ,
`headid`  varchar(50) NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM053-预算执行结果管理-消耗预算调整单接口-（SAP-表单）明细表';


-- Table structure for fb_sap_cs_budgethead: FM007
-- ----------------------------
CREATE TABLE IF NOT EXISTS fb_sap_cs_budgethead (
id int primary key auto_increment,
headid varchar(40) NULL,
tzdh varchar(50) NULL ,
fikrs varchar(50) NULL ,
djlx varchar(50) NULL ,
gjahr varchar(200) NULL ,
fund varchar(50) NULL ,
tizr varchar(50) NULL ,
tzrq varchar(50) NULL ,
wbzy varchar(50) NULL ,
create_by varchar(40) NULL ,
create_time datetime  NULL ,
update_by varchar(40) NULL ,
update_time datetime  NULL ,
remark varchar(200) NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM007';

-- ----------------------------
-- Table structure for FB_SAP_CS_BUDGETROWITEM：FM007
-- ----------------------------
CREATE TABLE IF NOT EXISTS fb_sap_cs_budgetrowitem (
id int PRIMARY KEY auto_increment,
tzdh varchar(50) NULL ,
djhh varchar(50) NULL ,
fictr varchar(50) NULL ,
ysqj varchar(50) NULL ,
adjst varchar(50) NULL ,
bzxx varchar(100) NULL ,
headid varchar(40) NULL 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM007';

-- ----------------------------
-- Table structure for FB_SAP_CS_GUDGETFILEITEM：FM007
-- ----------------------------
CREATE TABLE IF NOT EXISTS fb_sap_cs_gudgetfileitem (
id int primary key auto_increment ,
headid varchar(40) NULL ,
zfileid varchar(40) NULL ,
filetype varchar(100) NULL ,
filename varchar(100) NULL ,
fileurl varchar(100) NULL ,
pictureurl varchar(100) NULL 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='FM007';


