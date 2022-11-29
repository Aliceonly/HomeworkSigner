/*
 Navicat Premium Data Transfer

 Source Server         : mysql_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 29/11/2022 21:29:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (30, 'admin', '21232f297a57a5a743894a0e4a801fc3', '1139045289@qq.com');
INSERT INTO `user` VALUES (31, NULL, NULL, NULL);
INSERT INTO `user` VALUES (32, NULL, NULL, NULL);
INSERT INTO `user` VALUES (33, NULL, NULL, NULL);
INSERT INTO `user` VALUES (34, NULL, NULL, NULL);
INSERT INTO `user` VALUES (35, NULL, NULL, NULL);
INSERT INTO `user` VALUES (36, NULL, NULL, NULL);
INSERT INTO `user` VALUES (37, NULL, NULL, NULL);
INSERT INTO `user` VALUES (38, NULL, NULL, NULL);
INSERT INTO `user` VALUES (39, NULL, NULL, NULL);
INSERT INTO `user` VALUES (40, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
