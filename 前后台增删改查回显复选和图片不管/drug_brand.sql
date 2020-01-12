/*
Navicat MySQL Data Transfer

Source Server         : 1812
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : 1905b

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2020-01-01 20:09:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drug_brand`
-- ----------------------------
DROP TABLE IF EXISTS `drug_brand`;
CREATE TABLE `drug_brand` (
  `brandid` int(11) NOT NULL AUTO_INCREMENT,
  `brandname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brandid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug_brand
-- ----------------------------
INSERT INTO `drug_brand` VALUES ('1', '仁和');
INSERT INTO `drug_brand` VALUES ('2', '国泰');
INSERT INTO `drug_brand` VALUES ('3', '憧憬');
INSERT INTO `drug_brand` VALUES ('4', '不晓得');
