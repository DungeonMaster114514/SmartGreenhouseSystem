/*
 Navicat Premium Data Transfer

 Source Server         : 114514
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : javaswing_bookmanagement

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 21/04/2024 18:01:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dashdoard
-- ----------------------------
DROP TABLE IF EXISTS `dashdoard`;
CREATE TABLE `dashdoard`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `temperature` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `humidity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `lightIntensity` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `soilTemperature` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `updateTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 471 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dashdoard
-- ----------------------------
INSERT INTO `dashdoard` VALUES (2, '24', '35', '2000', '78', '2024-04-12 12:27:06');
INSERT INTO `dashdoard` VALUES (3, '34', '38', '1985', '75', '2024-04-12 13:30:12');
INSERT INTO `dashdoard` VALUES (13, '100', '100', '1000', '1000', '2024-04-12 17:17:44');
INSERT INTO `dashdoard` VALUES (17, '50', '50', '1500', '800', '2024-04-12 17:48:42');
INSERT INTO `dashdoard` VALUES (21, '32', '60', '1600', '950', '2024-04-12 20:30:25');
INSERT INTO `dashdoard` VALUES (22, '38', '70', '1650', '1100', '2024-04-15 11:00:35');
INSERT INTO `dashdoard` VALUES (23, '45', '40', '2000', '700', '2024-04-15 11:01:28');
INSERT INTO `dashdoard` VALUES (24, '50', '30', '2200', '400', '2024-04-15 11:02:13');
INSERT INTO `dashdoard` VALUES (25, '52', '25', '2300', '300', '2024-04-15 11:03:57');
INSERT INTO `dashdoard` VALUES (26, '54', '27', '2400', '400', '2024-04-15 18:32:17');
INSERT INTO `dashdoard` VALUES (27, '58', '30', '2450', '500', '2024-04-15 20:36:25');
INSERT INTO `dashdoard` VALUES (28, '42', '32', '2500', '520', '2024-04-15 22:32:54');
INSERT INTO `dashdoard` VALUES (29, '40', '31', '2100', '492', '2024-04-15 22:46:46');
INSERT INTO `dashdoard` VALUES (30, '43', '35', '2150', '500', '2024-04-15 22:49:04');
INSERT INTO `dashdoard` VALUES (48, '6', '155', '1926', '2067', '2024-04-16 19:47:52');
INSERT INTO `dashdoard` VALUES (284, '59', '134', '469', '3668', '2024-04-16 19:51:33');
INSERT INTO `dashdoard` VALUES (285, '3', '72', '1871', '2612', '2024-04-16 19:51:36');
INSERT INTO `dashdoard` VALUES (286, '2', '27', '1584', '3011', '2024-04-16 19:51:37');
INSERT INTO `dashdoard` VALUES (288, '75', '111', '696', '2877', '2024-04-16 19:51:40');
INSERT INTO `dashdoard` VALUES (289, '114', '129', '2380', '3280', '2024-04-16 19:51:41');
INSERT INTO `dashdoard` VALUES (290, '36', '151', '168', '230', '2024-04-16 19:51:42');
INSERT INTO `dashdoard` VALUES (291, '12', '51', '54', '1369', '2024-04-16 19:51:44');
INSERT INTO `dashdoard` VALUES (292, '96', '40', '162', '2898', '2024-04-16 19:51:45');
INSERT INTO `dashdoard` VALUES (293, '64', '192', '1347', '3204', '2024-04-16 19:51:46');
INSERT INTO `dashdoard` VALUES (294, '58', '108', '1367', '423', '2024-04-16 19:51:47');
INSERT INTO `dashdoard` VALUES (295, '133', '25', '2419', '1831', '2024-04-16 19:51:51');
INSERT INTO `dashdoard` VALUES (296, '57', '111', '1569', '1869', '2024-04-16 19:51:53');
INSERT INTO `dashdoard` VALUES (297, '67', '172', '2399', '827', '2024-04-16 19:51:54');
INSERT INTO `dashdoard` VALUES (298, '23', '30', '770', '310', '2024-04-16 19:51:56');
INSERT INTO `dashdoard` VALUES (299, '69', '16', '68', '3545', '2024-04-16 19:51:58');
INSERT INTO `dashdoard` VALUES (300, '52', '17', '985', '2822', '2024-04-16 19:52:03');
INSERT INTO `dashdoard` VALUES (301, '51', '122', '54', '1093', '2024-04-16 19:52:05');
INSERT INTO `dashdoard` VALUES (302, '45', '137', '1352', '2550', '2024-04-16 19:52:08');
INSERT INTO `dashdoard` VALUES (303, '84', '181', '2125', '2098', '2024-04-16 19:52:10');
INSERT INTO `dashdoard` VALUES (304, '10', '158', '1846', '1271', '2024-04-16 19:52:32');

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` int(0) NOT NULL DEFAULT 1,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `add_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\black_point.jpg', 1, '', '2024-04-11 18:42:36');
INSERT INTO `image` VALUES (2, 'C:\\Users\\Lenovo\\Pictures\\Smolder.jpg', 1, '', '2024-04-11 18:42:37');
INSERT INTO `image` VALUES (3, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\yellow.jpg', 1, '', '2024-04-11 18:42:38');
INSERT INTO `image` VALUES (4, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\deep_yellow.jpg', 1, '', '2024-04-11 18:42:39');
INSERT INTO `image` VALUES (6, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\yellow.jpg', 1, NULL, '2024-04-19 20:48:13');
INSERT INTO `image` VALUES (7, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\cm.jpg', 1, NULL, '2024-04-19 20:51:34');
INSERT INTO `image` VALUES (8, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\qg.png', 1, NULL, '2024-04-20 19:57:39');
INSERT INTO `image` VALUES (9, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\ybb.png', 1, NULL, '2024-04-20 20:04:43');

-- ----------------------------
-- Table structure for operationlist
-- ----------------------------
DROP TABLE IF EXISTS `operationlist`;
CREATE TABLE `operationlist`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) NOT NULL DEFAULT '2023-04-15 08:00:00',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `book_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operationlist
-- ----------------------------
INSERT INTO `operationlist` VALUES (1, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (2, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (3, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (4, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (5, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (6, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (7, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (8, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (9, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (10, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (11, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (12, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (13, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (14, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (15, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (16, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (17, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (18, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (19, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');
INSERT INTO `operationlist` VALUES (20, '2023-04-15 08:00:00', '张一', '房龙地理', '借走了 房龙地理 书籍');

-- ----------------------------
-- Table structure for userlist
-- ----------------------------
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `groups` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT 'user',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `gender` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '0',
  `identity` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '学生',
  `state` int(0) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userlist
-- ----------------------------
INSERT INTO `userlist` VALUES (1, 'admin', '管理员', 'Admin', '123456', '男', '13700000000', '管理员', 1);
INSERT INTO `userlist` VALUES (2, 'user', '张一', '张一', '123456', '男', '13700000001', '学生', 1);
INSERT INTO `userlist` VALUES (3, 'user', '张二', '张二', '123456', '男', '13700000002', '学生', 1);
INSERT INTO `userlist` VALUES (4, 'user', '张三', '张三', '123456', '男', '13700000003', '学生', 1);
INSERT INTO `userlist` VALUES (5, 'user', '张四', '张四', '123456', '男', '13700000004', '学生', 1);
INSERT INTO `userlist` VALUES (6, 'user', '张五', '张五', '123456', '男', '13700000005', '学生', 1);
INSERT INTO `userlist` VALUES (7, 'user', '李一', '李一', '123456', '男', '13700000006', '老师', 1);
INSERT INTO `userlist` VALUES (8, 'user', '李二', '李二', '123456', '男', '13700000007', '老师', 1);
INSERT INTO `userlist` VALUES (9, 'user', '李三', '李三', '123456', '男', '13700000008', '老师', 1);
INSERT INTO `userlist` VALUES (10, 'user', '李四', '李四', '123456', '男', '13700000009', '老师', 1);
INSERT INTO `userlist` VALUES (11, 'user', '李五', '李五', '123456', '男', '13700000010', '老师', 1);
INSERT INTO `userlist` VALUES (12, 'user', '赵一', '赵一', '123456', '男', '13700000011', '学生', 1);
INSERT INTO `userlist` VALUES (13, 'user', '赵二', '赵二', '123456', '男', '13700000012', '学生', 1);
INSERT INTO `userlist` VALUES (14, 'user', '赵三', '赵三', '123456', '男', '13700000013', '学生', 1);
INSERT INTO `userlist` VALUES (15, 'user', '赵四', '赵四', '123456', '男', '13700000014', '学生', 1);
INSERT INTO `userlist` VALUES (16, 'user', '赵五', '赵五', '123456', '男', '13700000015', '学生', 1);

SET FOREIGN_KEY_CHECKS = 1;
