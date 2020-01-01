/*
Navicat MySQL Data Transfer

Source Server         : 1812
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : 1905b

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2020-01-01 20:09:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drug_area`
-- ----------------------------
DROP TABLE IF EXISTS `drug_area`;
CREATE TABLE `drug_area` (
  `areaid` int(11) NOT NULL AUTO_INCREMENT,
  `areaname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`areaid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug_area
-- ----------------------------
INSERT INTO `drug_area` VALUES ('1', '河南');
INSERT INTO `drug_area` VALUES ('2', '山东');
INSERT INTO `drug_area` VALUES ('3', '广东');
INSERT INTO `drug_area` VALUES ('4', '北京');
