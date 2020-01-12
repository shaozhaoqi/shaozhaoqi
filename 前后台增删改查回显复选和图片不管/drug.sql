/*
Navicat MySQL Data Transfer

Source Server         : 1812
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : 1905b

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2020-01-01 20:10:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drug`
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `drugname` varchar(255) DEFAULT NULL,
  `drugprice` double DEFAULT NULL,
  `drugsales` int(11) DEFAULT NULL,
  `drugstock` int(11) DEFAULT NULL,
  `isotc` int(11) DEFAULT NULL,
  `person` varchar(255) DEFAULT NULL,
  `produceddate` datetime DEFAULT NULL,
  `expireddate` datetime DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `areaid` int(11) DEFAULT NULL,
  `brandid` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES ('44', '111', '111', '111', '111', '2', '幼儿,少年', '2019-12-31 00:00:00', '2019-12-22 00:00:00', null, null, '1', '4', 'https://yiyang03.oss-cn-beijing.aliyuncs.com/哈哈哈/1577774306111.jpg');
INSERT INTO `drug` VALUES ('45', '123', '13', '321', '213', '1', '少年,青年,中年', '2019-12-05 00:00:00', '2019-12-21 00:00:00', null, null, '3', '2', 'https://yiyang03.oss-cn-beijing.aliyuncs.com/哈哈哈/1577774908517.png');
INSERT INTO `drug` VALUES ('47', 'qweq', '200', '100', '400', '2', '幼儿,少年', '2020-01-17 00:00:00', '2020-01-26 00:00:00', null, null, '1', '1', 'https://yiyang03.oss-cn-beijing.aliyuncs.com/哈哈哈/1577863353900.jpg');
