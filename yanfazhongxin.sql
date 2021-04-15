/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : yanfazhongxin

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 15/04/2021 09:23:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `account_password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `identity` int NULL DEFAULT 0 COMMENT '用户身份，0表示用户，1表示管理员',
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '12345', '12345', 0);
INSERT INTO `account` VALUES (2, '123', '123', 0);
INSERT INTO `account` VALUES (3, '123456', '123456', 1);
INSERT INTO `account` VALUES (5, '456', '456', 0);
INSERT INTO `account` VALUES (6, '789', '789', 0);
INSERT INTO `account` VALUES (7, '156', '165', 0);
INSERT INTO `account` VALUES (8, '147', '147', 0);
INSERT INTO `account` VALUES (9, '258', '258', 0);
INSERT INTO `account` VALUES (10, '369', '369', 0);
INSERT INTO `account` VALUES (11, '102', '102', 0);
INSERT INTO `account` VALUES (12, '103', '103', 0);

-- ----------------------------
-- Table structure for notes_details
-- ----------------------------
DROP TABLE IF EXISTS `notes_details`;
CREATE TABLE `notes_details`  (
  `notes_details_id` int NOT NULL AUTO_INCREMENT COMMENT 'notes_details表的主键',
  `notes_title` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `notes_desc` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '笔记内容',
  `publisher_nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者昵称',
  `publisher_id` int NULL DEFAULT NULL COMMENT '发布者id',
  `add_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `last_time` datetime NULL DEFAULT NULL COMMENT '最后更新的时间',
  `jurisdiction` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章权限(私密还是公开)',
  `notes_likes` int UNSIGNED NULL DEFAULT 0 COMMENT '点赞数',
  `notes_group_id` int NULL DEFAULT NULL COMMENT '文章所属文章类别的id',
  PRIMARY KEY (`notes_details_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notes_details
-- ----------------------------
INSERT INTO `notes_details` VALUES (1, '哈哈啊修改成功', '啊发金凤凰就啊哈 加快', 'hhhh', 1, '2021-04-12 21:30:30', '2021-04-13 16:57:54', '公开', 12, 2);
INSERT INTO `notes_details` VALUES (2, '测试私密', '私密', '我要h得更高', 2, '2021-04-14 17:26:38', '2021-04-14 17:26:41', '私密', 20, 1);
INSERT INTO `notes_details` VALUES (19, '测试公开', '公开', 'hhhh', 1, '2021-04-14 17:27:35', '2021-04-14 17:27:39', '公开', 16, 3);
INSERT INTO `notes_details` VALUES (20, '102建党100周年', '建党100周年一般指庆祝中国共产党成立100周年。2021年7月1日是中国共产党成立100周年纪念日。2021年3月23日，中宣部介绍中国共产党成立100周年庆祝活动八项主要内容。3月24日，中宣部发布中国共产党成立100周年庆祝活动标识。', '102改成104', 11, '2021-04-14 21:56:04', '2021-04-14 21:56:04', '公开', 0, 1);
INSERT INTO `notes_details` VALUES (21, '古典音乐', '古典音乐 ，是音乐的一种类型。古典音乐有广义、狭义之分。广义是指那些从西方中世纪开始至今的、在欧洲主流文化背景下创作的西方古典音乐，主要因其复杂多样的创作技术和所能承载的厚重内涵而有别于通俗音乐和民间音乐。', '102改成104', 11, '2021-04-14 22:02:51', '2021-04-14 22:02:51', '公开', 0, 3);
INSERT INTO `notes_details` VALUES (22, '103', '103笔记', '103', 12, '2021-04-14 22:11:42', '2021-04-14 22:11:42', '公开', 0, 3);
INSERT INTO `notes_details` VALUES (23, '供奉神明选哪些水果为好，它们分别代表着不同的寓意！', '供奉神明选哪些水果为好，它们分别代表着不同的寓意！', '369', 10, '2021-04-15 08:59:20', '2021-04-15 08:59:24', '公开', 10, 2);
INSERT INTO `notes_details` VALUES (24, '南昌大学新传学硕：临渊羡鱼，不如退而结网', '古典音乐 ，是音乐的一种类型。古典音乐有广义、狭义之分。广义是指那些从西方中世纪开始至今的、在欧洲主流文化背景下创作的西方古典音乐，主要因其复杂多样的创作技术和所能承载的厚重内涵而有别于通俗音乐和民间音乐。', '102改成104', 11, '2021-04-14 22:02:51', '2021-04-14 22:02:51', '公开', 0, 3);
INSERT INTO `notes_details` VALUES (25, '南昌大学新传学硕：临渊羡', '本科来自江西非省会城市双非二本，大学填报志愿失利调剂了不感兴趣的专业，公共事业管理。四级复习一个月一次过520分，六级第一次裸考427，第二次复习一个月526。', '103', 12, '2021-04-14 22:11:42', '2021-04-14 22:11:42', '公开', 0, 3);
INSERT INTO `notes_details` VALUES (26, '供奉神明选哪些水果为好，它们分别代表着不同的寓意！', '一战暨南大学新闻学，总分352，政治73，英语67，专业课一95，专业课二117，专业排名第8，由于总分低于国家线无缘复试。', '369', 10, '2021-04-15 08:59:20', '2021-04-15 08:59:24', '公开', 10, 2);
INSERT INTO `notes_details` VALUES (27, '考研原因', '我算是一个从小到大学习细胞就不怎么活跃的摸鱼分子，成绩无论在哪里，无论入学时是前几名', '147', 8, '2021-04-14 09:04:18', '2021-04-21 09:04:22', '公开', 0, 4);
INSERT INTO `notes_details` VALUES (28, '关于择校', '区位条件、院校层次和专业水平是我认为在择校过程中必须考虑的三点，此外还必须结合自身的实力和综合素质进行最终的选择。择校这件事毕竟是见仁见智，我就大概说一下我的经历以供参考吧。', '789', 6, '2021-04-13 09:05:22', '2021-04-20 09:05:24', '公开', 0, 4);

-- ----------------------------
-- Table structure for notes_group
-- ----------------------------
DROP TABLE IF EXISTS `notes_group`;
CREATE TABLE `notes_group`  (
  `notes_group_id` int NOT NULL AUTO_INCREMENT COMMENT 'notes_group表的主键',
  `group_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章类别的名称',
  `add_time` datetime NULL DEFAULT NULL COMMENT '文章类别创建的时间',
  `last_time` date NULL DEFAULT NULL COMMENT '文章类别的最后一次更新时间',
  `admin_id` int NULL DEFAULT NULL COMMENT '该分组管理员的id',
  PRIMARY KEY (`notes_group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notes_group
-- ----------------------------
INSERT INTO `notes_group` VALUES (1, '计算机', '2021-04-14 19:33:35', '2021-04-13', 3);
INSERT INTO `notes_group` VALUES (2, '智能制造', '2021-04-13 19:33:38', '2021-04-14', 3);
INSERT INTO `notes_group` VALUES (3, '古典音乐', '2021-04-14 19:33:41', '2021-04-22', 3);
INSERT INTO `notes_group` VALUES (4, '现代美术', '2021-04-13 19:33:44', '2021-04-14', 3);
INSERT INTO `notes_group` VALUES (7, '土木工程', '2021-04-14 10:42:07', '2021-04-14', 3);

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
  `user_details_id` int NOT NULL AUTO_INCREMENT COMMENT '用户详情表主键',
  `user_nickname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_birthday` date NULL DEFAULT NULL COMMENT '用户生日',
  `user_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户个人介绍',
  `user_id` int NULL DEFAULT NULL COMMENT '作为关联user_account表的外键',
  PRIMARY KEY (`user_details_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES (1, 'hhhh', '女', '2021-04-13', '哈哈哈看到了', 1);
INSERT INTO `user_details` VALUES (2, '我要h得更高', '男', '2020-02-01', '我要飞得更高', 2);
INSERT INTO `user_details` VALUES (3, '456', '女', '2018-02-02', '456', 5);
INSERT INTO `user_details` VALUES (4, '789', '女', '2020-03-05', '789', 6);
INSERT INTO `user_details` VALUES (5, '156', '男', '2020-02-03', '156', 7);
INSERT INTO `user_details` VALUES (6, '147', '男', '2018-06-03', '147', 8);
INSERT INTO `user_details` VALUES (7, '258', '女', '2019-04-04', '258', 9);
INSERT INTO `user_details` VALUES (8, '369', '男', '2017-02-07', '369', 10);
INSERT INTO `user_details` VALUES (9, '102改成104', '女', '2020-02-06', '102改成104', 11);
INSERT INTO `user_details` VALUES (10, '103', '男', '2020-10-01', '103', 12);

SET FOREIGN_KEY_CHECKS = 1;
