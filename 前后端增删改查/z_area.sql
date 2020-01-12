/*
 Navicat Premium Data Transfer

 Source Server         : lala
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : 127.0.0.1:3306
 Source Schema         : 1905b

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 30/12/2019 14:19:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for z_area
-- ----------------------------
DROP TABLE IF EXISTS `z_area`;
CREATE TABLE `z_area`  (
  `areaId` int(10) NOT NULL AUTO_INCREMENT,
  `areaName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`areaId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for z_brand
-- ----------------------------
DROP TABLE IF EXISTS `z_brand`;
CREATE TABLE `z_brand`  (
  `brandId` int(10) NOT NULL AUTO_INCREMENT,
  `brandName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`brandId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for z_drug
-- ----------------------------
DROP TABLE IF EXISTS `z_drug`;
CREATE TABLE `z_drug`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `drugName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `drugPrice` decimal(10, 2) NULL DEFAULT NULL,
  `drugSales` int(10) NULL DEFAULT NULL,
  `drugStock` int(10) NULL DEFAULT NULL,
  `isOtc` int(10) NULL DEFAULT NULL,
  `person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `producedDate` date NULL DEFAULT NULL,
  `createDate` date NULL DEFAULT NULL,
  `updateDate` date NULL DEFAULT NULL,
  `areaId` int(10) NULL DEFAULT NULL,
  `brandId` int(10) NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
