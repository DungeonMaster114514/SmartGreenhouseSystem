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

 Date: 22/04/2024 09:50:14
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
INSERT INTO `dashdoard` VALUES (305, '27', '55', '2111', '1544', '2024-04-16 19:55:08');
INSERT INTO `dashdoard` VALUES (306, '59', '165', '2378', '1083', '2024-04-16 19:55:11');
INSERT INTO `dashdoard` VALUES (307, '74', '137', '2326', '2382', '2024-04-16 19:55:14');
INSERT INTO `dashdoard` VALUES (308, '27', '28', '407', '1529', '2024-04-16 19:55:15');
INSERT INTO `dashdoard` VALUES (309, '63', '193', '1401', '3622', '2024-04-16 20:03:11');
INSERT INTO `dashdoard` VALUES (310, '126', '103', '103', '2632', '2024-04-16 20:03:14');
INSERT INTO `dashdoard` VALUES (311, '24', '171', '1972', '1487', '2024-04-16 20:03:16');
INSERT INTO `dashdoard` VALUES (312, '73', '69', '653', '1052', '2024-04-16 20:03:18');
INSERT INTO `dashdoard` VALUES (313, '79', '173', '1863', '492', '2024-04-16 20:04:31');
INSERT INTO `dashdoard` VALUES (314, '56', '105', '1233', '3553', '2024-04-16 20:04:33');
INSERT INTO `dashdoard` VALUES (315, '144', '28', '2071', '2862', '2024-04-16 20:04:35');
INSERT INTO `dashdoard` VALUES (316, '13', '63', '746', '2189', '2024-04-16 20:04:36');
INSERT INTO `dashdoard` VALUES (317, '126', '112', '726', '3057', '2024-04-16 20:04:38');
INSERT INTO `dashdoard` VALUES (318, '142', '91', '1106', '3346', '2024-04-16 20:04:41');
INSERT INTO `dashdoard` VALUES (319, '128', '153', '658', '79', '2024-04-16 20:04:42');
INSERT INTO `dashdoard` VALUES (320, '46', '96', '1242', '123', '2024-04-16 20:04:43');
INSERT INTO `dashdoard` VALUES (321, '99', '45', '349', '78', '2024-04-16 20:04:44');
INSERT INTO `dashdoard` VALUES (322, '101', '67', '1598', '768', '2024-04-16 20:11:57');
INSERT INTO `dashdoard` VALUES (323, '6', '127', '133', '1430', '2024-04-16 20:11:58');
INSERT INTO `dashdoard` VALUES (324, '94', '13', '1135', '274', '2024-04-16 20:12:00');
INSERT INTO `dashdoard` VALUES (325, '146', '138', '1314', '2200', '2024-04-16 20:12:02');
INSERT INTO `dashdoard` VALUES (326, '25', '43', '1398', '598', '2024-04-16 20:12:04');
INSERT INTO `dashdoard` VALUES (327, '10', '179', '710', '2904', '2024-04-16 20:12:06');
INSERT INTO `dashdoard` VALUES (328, '116', '142', '549', '3867', '2024-04-16 20:15:30');
INSERT INTO `dashdoard` VALUES (329, '26', '195', '894', '3431', '2024-04-16 20:15:32');
INSERT INTO `dashdoard` VALUES (330, '32', '101', '2202', '3550', '2024-04-16 20:15:33');
INSERT INTO `dashdoard` VALUES (331, '119', '62', '454', '3876', '2024-04-16 20:15:35');
INSERT INTO `dashdoard` VALUES (332, '44', '117', '128', '1947', '2024-04-16 20:15:36');
INSERT INTO `dashdoard` VALUES (333, '42', '188', '2155', '1959', '2024-04-16 20:15:38');
INSERT INTO `dashdoard` VALUES (334, '129', '168', '1552', '2320', '2024-04-16 20:15:39');
INSERT INTO `dashdoard` VALUES (335, '5', '89', '307', '1092', '2024-04-16 20:15:41');
INSERT INTO `dashdoard` VALUES (336, '149', '33', '2115', '2909', '2024-04-16 20:24:36');
INSERT INTO `dashdoard` VALUES (337, '14', '62', '644', '1425', '2024-04-16 20:24:43');
INSERT INTO `dashdoard` VALUES (338, '1', '194', '2120', '1268', '2024-04-16 20:24:45');
INSERT INTO `dashdoard` VALUES (339, '6', '49', '313', '3519', '2024-04-16 20:24:47');
INSERT INTO `dashdoard` VALUES (340, '3', '94', '758', '378', '2024-04-16 20:24:49');
INSERT INTO `dashdoard` VALUES (341, '84', '105', '2398', '836', '2024-04-16 20:24:52');
INSERT INTO `dashdoard` VALUES (342, '25', '41', '1343', '258', '2024-04-16 20:24:55');
INSERT INTO `dashdoard` VALUES (343, '106', '71', '1652', '916', '2024-04-16 20:25:00');
INSERT INTO `dashdoard` VALUES (344, '24', '25', '375', '1470', '2024-04-16 20:25:01');
INSERT INTO `dashdoard` VALUES (345, '58', '166', '2498', '2006', '2024-04-16 20:25:02');
INSERT INTO `dashdoard` VALUES (346, '76', '8', '1702', '1117', '2024-04-16 20:25:03');
INSERT INTO `dashdoard` VALUES (347, '53', '186', '1517', '931', '2024-04-16 20:25:04');
INSERT INTO `dashdoard` VALUES (348, '51', '3', '146', '963', '2024-04-16 20:25:06');
INSERT INTO `dashdoard` VALUES (349, '4', '82', '2481', '2870', '2024-04-16 20:25:07');
INSERT INTO `dashdoard` VALUES (350, '91', '179', '1660', '2497', '2024-04-16 20:25:08');
INSERT INTO `dashdoard` VALUES (351, '19', '154', '1186', '220', '2024-04-16 20:25:08');
INSERT INTO `dashdoard` VALUES (352, '127', '19', '2310', '1330', '2024-04-16 20:25:09');
INSERT INTO `dashdoard` VALUES (353, '133', '91', '1513', '2644', '2024-04-16 20:25:10');
INSERT INTO `dashdoard` VALUES (354, '73', '92', '2114', '3365', '2024-04-16 20:25:11');
INSERT INTO `dashdoard` VALUES (355, '100', '164', '239', '68', '2024-04-16 20:25:13');
INSERT INTO `dashdoard` VALUES (356, '119', '187', '761', '2815', '2024-04-16 20:25:14');
INSERT INTO `dashdoard` VALUES (357, '90', '183', '1905', '253', '2024-04-16 20:25:15');
INSERT INTO `dashdoard` VALUES (358, '4', '192', '1797', '2838', '2024-04-16 20:29:38');
INSERT INTO `dashdoard` VALUES (359, '58', '164', '2371', '1086', '2024-04-16 20:29:39');
INSERT INTO `dashdoard` VALUES (360, '76', '148', '450', '2687', '2024-04-16 20:29:40');
INSERT INTO `dashdoard` VALUES (361, '122', '15', '2331', '1718', '2024-04-16 20:29:43');
INSERT INTO `dashdoard` VALUES (362, '52', '93', '692', '3950', '2024-04-16 20:29:45');
INSERT INTO `dashdoard` VALUES (363, '15', '113', '1303', '3615', '2024-04-16 20:29:46');
INSERT INTO `dashdoard` VALUES (364, '143', '11', '1091', '11', '2024-04-16 20:29:47');
INSERT INTO `dashdoard` VALUES (365, '105', '103', '1175', '3200', '2024-04-16 20:29:49');
INSERT INTO `dashdoard` VALUES (366, '88', '109', '2416', '766', '2024-04-16 20:29:50');
INSERT INTO `dashdoard` VALUES (367, '8', '143', '1037', '3685', '2024-04-16 20:29:52');
INSERT INTO `dashdoard` VALUES (368, '54', '8', '308', '1973', '2024-04-16 20:29:53');
INSERT INTO `dashdoard` VALUES (369, '14', '0', '1815', '2482', '2024-04-16 20:29:55');
INSERT INTO `dashdoard` VALUES (370, '138', '152', '74', '3469', '2024-04-16 20:29:57');
INSERT INTO `dashdoard` VALUES (371, '37', '126', '1057', '865', '2024-04-16 20:30:01');
INSERT INTO `dashdoard` VALUES (372, '122', '83', '1631', '25', '2024-04-16 20:30:03');
INSERT INTO `dashdoard` VALUES (373, '11', '71', '1377', '2760', '2024-04-16 20:30:13');
INSERT INTO `dashdoard` VALUES (374, '9', '185', '1123', '1838', '2024-04-17 14:06:43');
INSERT INTO `dashdoard` VALUES (375, '142', '73', '2459', '3281', '2024-04-17 14:06:46');
INSERT INTO `dashdoard` VALUES (376, '22', '58', '8', '574', '2024-04-17 14:06:48');
INSERT INTO `dashdoard` VALUES (377, '106', '22', '1099', '3434', '2024-04-17 14:06:50');
INSERT INTO `dashdoard` VALUES (378, '146', '58', '1377', '3483', '2024-04-17 14:06:52');
INSERT INTO `dashdoard` VALUES (379, '105', '178', '903', '516', '2024-04-17 14:06:54');
INSERT INTO `dashdoard` VALUES (380, '84', '83', '985', '2899', '2024-04-17 14:07:14');
INSERT INTO `dashdoard` VALUES (381, '66', '7', '2135', '653', '2024-04-17 14:07:15');
INSERT INTO `dashdoard` VALUES (382, '37', '155', '307', '1143', '2024-04-17 14:07:17');
INSERT INTO `dashdoard` VALUES (383, '8', '88', '61', '3206', '2024-04-17 14:07:18');
INSERT INTO `dashdoard` VALUES (384, '140', '52', '1284', '3122', '2024-04-17 14:07:20');
INSERT INTO `dashdoard` VALUES (385, '54', '93', '622', '3379', '2024-04-17 14:07:22');
INSERT INTO `dashdoard` VALUES (386, '71', '170', '2066', '2310', '2024-04-17 14:07:23');
INSERT INTO `dashdoard` VALUES (387, '61', '62', '824', '2860', '2024-04-17 14:07:25');
INSERT INTO `dashdoard` VALUES (388, '87', '156', '405', '1835', '2024-04-17 14:07:27');
INSERT INTO `dashdoard` VALUES (389, '121', '132', '2246', '1993', '2024-04-17 14:07:30');
INSERT INTO `dashdoard` VALUES (390, '119', '96', '91', '2915', '2024-04-17 14:07:33');
INSERT INTO `dashdoard` VALUES (391, '80', '96', '2026', '2421', '2024-04-17 14:07:34');
INSERT INTO `dashdoard` VALUES (392, '89', '32', '51', '2474', '2024-04-17 14:07:35');
INSERT INTO `dashdoard` VALUES (393, '4', '59', '1006', '462', '2024-04-17 14:07:37');
INSERT INTO `dashdoard` VALUES (394, '55', '101', '1048', '2312', '2024-04-17 14:07:38');
INSERT INTO `dashdoard` VALUES (395, '94', '85', '606', '3716', '2024-04-17 14:07:40');
INSERT INTO `dashdoard` VALUES (396, '137', '159', '618', '3346', '2024-04-17 14:07:42');
INSERT INTO `dashdoard` VALUES (397, '66', '139', '385', '2736', '2024-04-17 14:07:45');
INSERT INTO `dashdoard` VALUES (398, '143', '147', '2050', '3537', '2024-04-17 14:07:47');
INSERT INTO `dashdoard` VALUES (399, '144', '30', '2213', '3857', '2024-04-17 14:07:50');
INSERT INTO `dashdoard` VALUES (400, '24', '187', '465', '481', '2024-04-17 15:20:12');
INSERT INTO `dashdoard` VALUES (401, '6', '171', '373', '717', '2024-04-17 15:29:41');
INSERT INTO `dashdoard` VALUES (402, '67', '140', '421', '2943', '2024-04-17 15:29:45');
INSERT INTO `dashdoard` VALUES (403, '26', '132', '1948', '3670', '2024-04-17 15:29:47');
INSERT INTO `dashdoard` VALUES (404, '37', '99', '1823', '637', '2024-04-17 15:29:53');
INSERT INTO `dashdoard` VALUES (405, '91', '113', '23', '1381', '2024-04-17 15:30:00');
INSERT INTO `dashdoard` VALUES (406, '104', '90', '439', '2066', '2024-04-17 15:47:28');
INSERT INTO `dashdoard` VALUES (407, '8', '145', '1199', '841', '2024-04-17 15:47:30');
INSERT INTO `dashdoard` VALUES (408, '91', '86', '804', '1252', '2024-04-17 15:51:06');
INSERT INTO `dashdoard` VALUES (409, '90', '12', '1269', '1416', '2024-04-17 15:51:08');
INSERT INTO `dashdoard` VALUES (410, '37', '34', '316', '449', '2024-04-17 15:51:11');
INSERT INTO `dashdoard` VALUES (411, '27', '114', '810', '3596', '2024-04-17 15:51:15');
INSERT INTO `dashdoard` VALUES (412, '78', '182', '2493', '995', '2024-04-17 15:51:17');
INSERT INTO `dashdoard` VALUES (413, '37', '103', '2053', '2238', '2024-04-17 15:51:20');
INSERT INTO `dashdoard` VALUES (414, '50', '197', '2366', '3057', '2024-04-17 15:51:23');
INSERT INTO `dashdoard` VALUES (415, '147', '123', '355', '3432', '2024-04-17 15:51:26');
INSERT INTO `dashdoard` VALUES (416, '129', '148', '317', '1615', '2024-04-17 16:02:32');
INSERT INTO `dashdoard` VALUES (417, '74', '160', '1318', '890', '2024-04-18 14:27:39');
INSERT INTO `dashdoard` VALUES (418, '79', '196', '829', '2823', '2024-04-18 14:27:41');
INSERT INTO `dashdoard` VALUES (419, '79', '109', '355', '261', '2024-04-18 14:27:44');
INSERT INTO `dashdoard` VALUES (420, '135', '61', '2095', '1067', '2024-04-18 14:27:47');
INSERT INTO `dashdoard` VALUES (421, '122', '58', '42', '801', '2024-04-18 14:27:50');
INSERT INTO `dashdoard` VALUES (422, '142', '30', '2268', '327', '2024-04-18 14:27:53');
INSERT INTO `dashdoard` VALUES (423, '103', '38', '2221', '3492', '2024-04-18 14:27:55');
INSERT INTO `dashdoard` VALUES (424, '104', '176', '752', '3456', '2024-04-18 14:35:26');
INSERT INTO `dashdoard` VALUES (425, '62', '99', '558', '2526', '2024-04-18 14:35:27');
INSERT INTO `dashdoard` VALUES (426, '73', '108', '636', '2572', '2024-04-18 14:35:29');
INSERT INTO `dashdoard` VALUES (427, '67', '65', '704', '1712', '2024-04-18 14:35:30');
INSERT INTO `dashdoard` VALUES (428, '44', '37', '160', '3007', '2024-04-18 14:35:34');
INSERT INTO `dashdoard` VALUES (429, '84', '115', '456', '738', '2024-04-18 14:36:17');
INSERT INTO `dashdoard` VALUES (430, '56', '64', '1220', '1890', '2024-04-18 14:36:18');
INSERT INTO `dashdoard` VALUES (431, '134', '15', '1700', '698', '2024-04-18 14:36:20');
INSERT INTO `dashdoard` VALUES (432, '124', '127', '1747', '2310', '2024-04-18 14:36:21');
INSERT INTO `dashdoard` VALUES (433, '118', '44', '1843', '82', '2024-04-18 14:36:23');
INSERT INTO `dashdoard` VALUES (434, '133', '78', '703', '944', '2024-04-18 14:36:25');
INSERT INTO `dashdoard` VALUES (435, '50', '194', '2129', '1368', '2024-04-18 14:36:27');
INSERT INTO `dashdoard` VALUES (436, '23', '150', '760', '1031', '2024-04-18 14:36:29');
INSERT INTO `dashdoard` VALUES (437, '56', '21', '1002', '2752', '2024-04-18 14:36:36');
INSERT INTO `dashdoard` VALUES (438, '35', '24', '2251', '538', '2024-04-18 14:36:37');
INSERT INTO `dashdoard` VALUES (439, '145', '91', '927', '1926', '2024-04-18 14:36:39');
INSERT INTO `dashdoard` VALUES (440, '148', '65', '1664', '1396', '2024-04-18 23:08:35');
INSERT INTO `dashdoard` VALUES (441, '112', '138', '566', '202', '2024-04-18 23:08:41');
INSERT INTO `dashdoard` VALUES (443, '10', '195', '1682', '1731', '2024-04-18 23:08:47');
INSERT INTO `dashdoard` VALUES (444, '21', '85', '1747', '860', '2024-04-18 23:08:49');
INSERT INTO `dashdoard` VALUES (445, '146', '48', '723', '2850', '2024-04-18 23:08:51');
INSERT INTO `dashdoard` VALUES (446, '104', '67', '1489', '3883', '2024-04-18 23:08:53');
INSERT INTO `dashdoard` VALUES (447, '10', '84', '2271', '1108', '2024-04-18 23:08:55');
INSERT INTO `dashdoard` VALUES (448, '99', '93', '915', '1689', '2024-04-18 23:09:00');
INSERT INTO `dashdoard` VALUES (449, '1', '159', '2390', '1535', '2024-04-18 23:09:05');
INSERT INTO `dashdoard` VALUES (450, '7', '20', '879', '1826', '2024-04-18 23:09:07');
INSERT INTO `dashdoard` VALUES (451, '34', '153', '411', '2053', '2024-04-18 23:09:10');
INSERT INTO `dashdoard` VALUES (452, '11', '165', '2287', '372', '2024-04-18 23:09:12');
INSERT INTO `dashdoard` VALUES (453, '108', '65', '1188', '1573', '2024-04-18 23:09:14');
INSERT INTO `dashdoard` VALUES (454, '81', '104', '2475', '1537', '2024-04-18 23:09:22');
INSERT INTO `dashdoard` VALUES (455, '142', '119', '366', '3736', '2024-04-18 23:09:25');
INSERT INTO `dashdoard` VALUES (456, '71', '81', '1509', '3185', '2024-04-19 10:40:30');
INSERT INTO `dashdoard` VALUES (457, '25', '91', '1953', '2130', '2024-04-19 10:40:32');
INSERT INTO `dashdoard` VALUES (458, '47', '199', '89', '729', '2024-04-19 10:40:34');
INSERT INTO `dashdoard` VALUES (459, '120', '95', '2405', '1541', '2024-04-19 10:40:35');
INSERT INTO `dashdoard` VALUES (460, '6', '9', '285', '1714', '2024-04-19 10:40:37');
INSERT INTO `dashdoard` VALUES (461, '120', '143', '459', '3070', '2024-04-19 10:40:39');
INSERT INTO `dashdoard` VALUES (462, '43', '26', '1992', '2362', '2024-04-19 10:40:42');
INSERT INTO `dashdoard` VALUES (463, '84', '7', '1235', '1454', '2024-04-19 10:40:44');
INSERT INTO `dashdoard` VALUES (464, '50', '117', '2348', '3711', '2024-04-19 10:40:46');
INSERT INTO `dashdoard` VALUES (465, '123', '65', '401', '3311', '2024-04-19 10:40:49');
INSERT INTO `dashdoard` VALUES (466, '98', '160', '105', '3208', '2024-04-19 10:40:50');
INSERT INTO `dashdoard` VALUES (467, '132', '2', '1047', '206', '2024-04-19 10:40:52');
INSERT INTO `dashdoard` VALUES (468, '0', '170', '654', '2995', '2024-04-19 10:40:53');
INSERT INTO `dashdoard` VALUES (469, '143', '110', '2184', '2867', '2024-04-19 10:40:54');
INSERT INTO `dashdoard` VALUES (470, '144', '133', '1113', '897', '2024-04-19 10:40:55');
INSERT INTO `dashdoard` VALUES (471, '114', '164', '2053', '2550', '2024-04-21 18:52:44');
INSERT INTO `dashdoard` VALUES (472, '108', '141', '893', '2681', '2024-04-21 18:52:52');
INSERT INTO `dashdoard` VALUES (473, '41', '77', '220', '1139', '2024-04-21 18:52:55');
INSERT INTO `dashdoard` VALUES (474, '24', '189', '624', '1645', '2024-04-21 18:52:57');
INSERT INTO `dashdoard` VALUES (475, '24', '73', '45', '4095', '2024-04-21 22:59:29');
INSERT INTO `dashdoard` VALUES (476, '24', '73', '45', '4095', '2024-04-21 22:59:35');
INSERT INTO `dashdoard` VALUES (477, '24', '73', '45', '4095', '2024-04-21 22:59:42');
INSERT INTO `dashdoard` VALUES (478, '24', '73', '45', '4095', '2024-04-21 22:59:48');
INSERT INTO `dashdoard` VALUES (479, '24', '73', '17', '4095', '2024-04-21 22:59:54');
INSERT INTO `dashdoard` VALUES (480, '24', '72', '0', '4095', '2024-04-21 23:00:01');
INSERT INTO `dashdoard` VALUES (481, '24', '73', '0', '4095', '2024-04-21 23:00:07');
INSERT INTO `dashdoard` VALUES (482, '24', '73', '0', '4095', '2024-04-21 23:00:13');
INSERT INTO `dashdoard` VALUES (483, '24', '72', '0', '4095', '2024-04-21 23:00:19');
INSERT INTO `dashdoard` VALUES (484, '24', '72', '49', '4095', '2024-04-21 23:00:26');
INSERT INTO `dashdoard` VALUES (485, '24', '72', '48', '4095', '2024-04-21 23:00:32');

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
INSERT INTO `image` VALUES (10, 'C:\\IdeaProjects\\Library\\src\\main\\java\\com\\ksamar\\library\\images_check\\smolder.jpg', 1, '', '2024-04-21 22:54:24');

-- ----------------------------
-- Table structure for operationlist
-- ----------------------------
DROP TABLE IF EXISTS `operationlist`;
CREATE TABLE `operationlist`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `time` datetime(0) NOT NULL DEFAULT '2023-04-15 08:00:00',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operationlist
-- ----------------------------
INSERT INTO `operationlist` VALUES (1, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (2, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (3, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (4, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (5, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (6, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (7, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (8, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (9, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (10, '2023-04-15 08:00:00', '张一', '检测了一张图');
INSERT INTO `operationlist` VALUES (11, '2023-04-15 08:00:00', '张一', '检测了一张图');

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
