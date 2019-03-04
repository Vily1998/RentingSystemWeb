/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : rental_agency

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-01-10 23:05:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_agency_income
-- ----------------------------
DROP TABLE IF EXISTS `t_agency_income`;
CREATE TABLE `t_agency_income` (
  `year` year(4) NOT NULL,
  `month` int(2) NOT NULL,
  `area` varchar(255) NOT NULL,
  `transaction_num` int(11) DEFAULT NULL,
  `total_agency_fee` float DEFAULT NULL,
  PRIMARY KEY (`year`,`month`,`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_agency_income
-- ----------------------------

-- ----------------------------
-- Table structure for t_area_income
-- ----------------------------
DROP TABLE IF EXISTS `t_area_income`;
CREATE TABLE `t_area_income` (
  `area` varchar(255) DEFAULT NULL,
  `transaction_num` int(11) DEFAULT NULL,
  `total_agency_fee` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_area_income
-- ----------------------------
INSERT INTO `t_area_income` VALUES ('北京市 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('天津市 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('上海市 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('重庆市 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('河北省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('山西省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('台湾省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('辽宁省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('吉林省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('黑龙江省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('江苏省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('浙江省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('安徽省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('福建省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('江西省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('山东省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('河南省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('湖北省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('湖南省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('广东省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('甘肃省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('四川省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('贵州省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('海南省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('云南省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('青海省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('陕西省 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('广西壮族自治区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('西藏自治区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('宁夏回族自治区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('新疆维吾尔自治区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('内蒙古自治区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('澳门特别行政区 ', '0', '0');
INSERT INTO `t_area_income` VALUES ('香港特别行政区 ', '0', '0');

-- ----------------------------
-- Table structure for t_house
-- ----------------------------
DROP TABLE IF EXISTS `t_house`;
CREATE TABLE `t_house` (
  `house_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  `community_name` varchar(255) NOT NULL,
  `house_num` varchar(255) NOT NULL,
  `house_type` int(1) NOT NULL,
  `house_area` float NOT NULL,
  `house_floor` int(2) NOT NULL,
  `is_elevator` int(1) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `deposit` float NOT NULL,
  `payment_method` int(1) NOT NULL,
  `rent_per_month` float NOT NULL,
  `register_time` datetime NOT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` int(1) NOT NULL,
  PRIMARY KEY (`house_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_house
-- ----------------------------
INSERT INTO `t_house` VALUES ('1', '1', '北京市 ', '西土城10号', '310', '1', '20', '3', '0', '这是310的寝室', '1000', '3', '500', '2019-01-10 16:38:00', '2019-01-10 16:38:39', '0');
INSERT INTO `t_house` VALUES ('2', '2', '黑龙江省 ', '黑河市', '403', '2', '90', '5', '0', '低价甩卖，童叟无欺', '100', '1', '500', '2019-01-10 16:51:00', '2019-01-10 16:51:37', '0');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `message_id` int(11) NOT NULL,
  `message` varchar(10000) NOT NULL,
  `landlord_user_id` int(11) NOT NULL,
  `tenant_user_id` int(11) NOT NULL,
  `house_id` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `modify_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_month_income
-- ----------------------------
DROP TABLE IF EXISTS `t_month_income`;
CREATE TABLE `t_month_income` (
  `year` year(4) NOT NULL,
  `month` int(2) NOT NULL,
  `transaction_num` int(11) DEFAULT NULL,
  `total_agency_fee` float DEFAULT NULL,
  PRIMARY KEY (`year`,`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_month_income
-- ----------------------------
INSERT INTO `t_month_income` VALUES ('2018', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2018', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2019', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2020', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2021', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2022', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2023', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2024', '12', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '1', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '2', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '3', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '4', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '5', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '6', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '7', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '8', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '9', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '10', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '11', '0', '0');
INSERT INTO `t_month_income` VALUES ('2025', '12', '0', '0');

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay` (
  `pay_id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `house_id` int(11) NOT NULL,
  `landlord_user_id` int(11) NOT NULL,
  `tenant_user_id` int(11) NOT NULL,
  `payment_method` int(11) NOT NULL,
  `pay_date` date NOT NULL,
  `rent` float NOT NULL,
  `is_pay` int(11) NOT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pay
-- ----------------------------

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `house_id` int(11) NOT NULL,
  `photo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES ('1', '//localhost:8080/image/ee6a1ceb-a5d0-41c7-a1d7-e111d511c96e_u=1225541717,590798022&fm=27&gp=0.jpg');
INSERT INTO `t_photo` VALUES ('2', '//localhost:8080/image/e8538039-cf9f-4610-a5db-bcacbf1a031d_back.jpg');

-- ----------------------------
-- Table structure for t_rent
-- ----------------------------
DROP TABLE IF EXISTS `t_rent`;
CREATE TABLE `t_rent` (
  `rent_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `city_name` varchar(255) DEFAULT NULL,
  `community_name` varchar(255) DEFAULT NULL,
  `house_type` int(1) DEFAULT NULL,
  `house_floor` int(2) DEFAULT NULL,
  `is_elevator` int(1) DEFAULT NULL,
  `description` varchar(20000) DEFAULT NULL,
  `deposit` int(2) DEFAULT NULL,
  `payment_method` int(1) DEFAULT NULL,
  `rent_per_month` float DEFAULT NULL,
  `register_time` datetime NOT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rent_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rent
-- ----------------------------
INSERT INTO `t_rent` VALUES ('1', '1', '-1', '-1', '-1', '-1', '-1', '-1', '-1', '1', '-1', '2019-01-10 19:18:00', '2019-01-10 22:11:18');
INSERT INTO `t_rent` VALUES ('2', '1', '北京市 ', '310', '1', '3', '0', '啦啦啦啦啦啦', '100', '1', '1000', '2019-01-10 19:20:00', '2019-01-10 19:20:43');

-- ----------------------------
-- Table structure for t_rent_transaction
-- ----------------------------
DROP TABLE IF EXISTS `t_rent_transaction`;
CREATE TABLE `t_rent_transaction` (
  `transaction_id` int(11) NOT NULL,
  `house_id` int(11) NOT NULL,
  `landlord_user_id` int(11) NOT NULL,
  `tenant_user_id` int(10) NOT NULL,
  `transaction_date` datetime NOT NULL,
  `start_month` date NOT NULL,
  `terminate_month` date NOT NULL,
  `deposit` float NOT NULL,
  `payment_method` int(1) NOT NULL,
  `rent_per_month` float NOT NULL,
  `total_rent` float NOT NULL,
  `landord_agency_fee` float NOT NULL,
  `tenant_agency_fee` float NOT NULL,
  PRIMARY KEY (`transaction_id`),
  KEY `landlord_user_id` (`landlord_user_id`),
  KEY `tenant_user_id` (`tenant_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rent_transaction
-- ----------------------------
INSERT INTO `t_rent_transaction` VALUES ('1', '1', '1', '2', '2019-01-10 16:45:44', '2019-01-09', '2019-04-09', '1000', '3', '500', '1500', '150', '150');
INSERT INTO `t_rent_transaction` VALUES ('2', '1', '1', '2', '2019-01-10 16:45:49', '2019-01-09', '2019-04-09', '1000', '3', '500', '1500', '150', '150');
INSERT INTO `t_rent_transaction` VALUES ('3', '2', '2', '1', '2019-01-10 16:56:18', '2019-01-11', '2020-01-11', '100', '1', '500', '6000', '600', '600');
INSERT INTO `t_rent_transaction` VALUES ('4', '2', '2', '1', '2019-01-10 16:58:14', '2019-01-11', '2020-01-11', '100', '1', '500', '6000', '600', '600');

-- ----------------------------
-- Table structure for t_total_fee
-- ----------------------------
DROP TABLE IF EXISTS `t_total_fee`;
CREATE TABLE `t_total_fee` (
  `user_id` int(11) NOT NULL,
  `total_fee` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_total_fee
-- ----------------------------
INSERT INTO `t_total_fee` VALUES ('2', '238076');
INSERT INTO `t_total_fee` VALUES ('1', '1500');
INSERT INTO `t_total_fee` VALUES ('2', '1500');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(50) NOT NULL,
  `user_type` int(1) NOT NULL,
  `real_name` varchar(255) NOT NULL,
  `certificate_type` int(1) NOT NULL,
  `certificate_num` varchar(255) NOT NULL,
  `mobile_num` varchar(11) NOT NULL,
  `user_level` int(1) NOT NULL,
  `register_city` varchar(255) NOT NULL,
  `register_time` datetime NOT NULL,
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('0', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '管理员', '0', '110101201812190000', '13712346789', '0', '北京', '2018-12-19 16:14:32', '2019-01-10 16:35:25');
INSERT INTO `t_user` VALUES ('1', 'zsl', '21232f297a57a5a743894a0e4a801fc3', '1', '主席', '1', '111111111111111111', '11111111111', '0', '北京市 ', '2019-01-10 16:37:00', '2019-01-10 19:08:20');
INSERT INTO `t_user` VALUES ('2', 'cb', '3cfe88a946a36aae8e94e7279beda8f6', '1', '树叶', '1', '231026111111111111', '18611881111', '0', '黑龙江省 ', '2019-01-10 16:42:00', '2019-01-10 16:42:00');

-- ----------------------------
-- Table structure for t_want
-- ----------------------------
DROP TABLE IF EXISTS `t_want`;
CREATE TABLE `t_want` (
  `want_id` int(11) NOT NULL,
  `landlord_user_id` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `tenant_user_id` int(11) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `start_month` date DEFAULT NULL,
  `continual_month` int(255) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`want_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_want
-- ----------------------------
INSERT INTO `t_want` VALUES ('1', '1', '1', '2', '树叶', '2019-01-09', '3', '310寝室是我家', '2', '2019-01-10 16:56:45');
INSERT INTO `t_want` VALUES ('2', '2', '2', '1', '主席', '2019-01-11', '12', '主席暂住', '3', '2019-01-10 16:58:14');
