----------------------------
-----------user(用户表)
---------------------------
CREATE TABLE IF NOT EXISTS `sys` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `age` int(20) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';


----------------------------
-----------附件明细表
---------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_attitem` (
`id`  int(30) UNSIGNED NOT NULL AUTO_INCREMENT ,
`headid`  varchar(40) NULL COMMENT '单号' ,
`zfileid`  varchar(40) NULL COMMENT '文件ID' ,
`filetype`  varchar(40) NULL COMMENT '文件类型' ,
`filename`  varchar(40) NULL COMMENT '文件名' ,
`fileurl`  varchar(40) NULL COMMENT '附件系统URL' ,
`pictureurl`  varchar(40) NULL ,
`create_time`  datetime NULL COMMENT '创建时间' ,
`create_by`  varchar(10) NULL COMMENT '创建人' ,
`update_time`  datetime NULL COMMENT '最后一次更新时间' ,
`update_by`  varchar(10) NULL COMMENT '最后一次更新人' ,
`remark`  varchar(200) NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='附件明细表';

-- ----------------------------
-- Table structure for FB_SAP_FORM_FLOW 表单管理的流程表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_form_flow` (
`id`  INT(30) UNSIGNED NOT NULL AUTO_INCREMENT ,
`module_id`  varchar(40) NOT NULL COMMENT '模块id' ,
`flow_name`  varchar(50) NOT NULL COMMENT '流程名称' ,
`k2_process_code`  varchar(40) NOT NULL COMMENT 'K2流程模板ID' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
`create_by`  varchar(40) NOT NULL COMMENT '创建人' ,
`update_time`  datetime NOT NULL COMMENT '最后一次修改时间' ,
`update_by`  varchar(40) NOT NULL COMMENT '最后一次修改人' ,
`remark`  varchar(100) NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单管理的流程表';

-- ----------------------------
-- Table structure for FB_SAP_FORM_MODULE 表单管理的模块表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_form_module` (
`id`  INT(30) UNSIGNED NOT NULL AUTO_INCREMENT,
`module_name`  varchar(40) NOT NULL COMMENT '模块名称' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
`create_by`  varchar(40) NOT NULL COMMENT '创建人' ,
`update_time`  datetime NOT NULL COMMENT '最后一次修改时间' ,
`update_by`  varchar(40) NOT NULL COMMENT '最后一次修改人' ,
`remark`  varchar(100) NULL COMMENT '备注' ,
`module_code`  varchar(50) NOT NULL COMMENT '模块编号' ,
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单管理的模块表';

-- ----------------------------
-- Table structure for FB_SAP_FORM_NODE 表单管理的节点表
-- ----------------------------
CREATE TABLE IF NOT EXISTS `fb_sap_form_node` (
`id` INT(30) UNSIGNED NOT NULL AUTO_INCREMENT,
`k2_process_id`  varchar(40) NOT NULL COMMENT '流程id' ,
`k2_node_id`  varchar(40) NOT NULL COMMENT 'K2流程节点ID' ,
`node_pagename`  varchar(50) NOT NULL COMMENT '对应的页面名字' ,
`create_time`  datetime NOT NULL COMMENT '创建时间' ,
`create_by`  varchar(40) NOT NULL COMMENT '创建人' ,
`update_time`  datetime NOT NULL COMMENT '最后一次修改时间' ,
`update_by`  varchar(40) NOT NULL COMMENT '最后一次修改人' ,
`remark`  varchar(200) NULL COMMENT '备注' ,
PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='表单管理的节点表';