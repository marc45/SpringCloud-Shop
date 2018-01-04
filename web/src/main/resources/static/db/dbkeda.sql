/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : dbkeda

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-01-04 10:47:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for carousel
-- ----------------------------
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `body` varchar(255) DEFAULT NULL,
  `href_uri` varchar(255) DEFAULT NULL,
  `href_url` varchar(255) DEFAULT NULL,
  `order_number` bigint(20) DEFAULT NULL,
  `picture_uri` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  `used_for` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of carousel
-- ----------------------------
INSERT INTO `carousel` VALUES ('1', 'banner2', '#', '#', '10', '/eureka-web/img/ad2.jpg', '/eureka-web/img/ad2.jpg', 'home');
INSERT INTO `carousel` VALUES ('2', 'banner3', '#', '#', '2', '/eureka-web/img/ad3.jpg', '/eureka-web/img/ad3.jpg', 'home');
INSERT INTO `carousel` VALUES ('3', 'banner4', '#', '#', '3', '/eureka-web/img/ad4.jpg', '/eureka-web/img/ad4.jpg', 'home');
INSERT INTO `carousel` VALUES ('4', 'banner1', '#', '#', '4', '/eureka-web/img/ad1.jpg', '/eureka-web/img/ad1.jpg', 'home');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `order_number` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpqbj33aij72uwx8rwt086hvq2` (`parent_id`),
  CONSTRAINT `FKpqbj33aij72uwx8rwt086hvq2` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', '海味', '1', null, '29.99', '/eureka-web/img/cp.jpg', '');
INSERT INTO `category` VALUES ('2', '1', 'ZEK 原味海苔', '2', '1', '8.90', '/eureka-web/img/cp2.jpg', 'ZEK 原味海苔 详情');
INSERT INTO `category` VALUES ('3', '1', '萨拉米 1+1小鸡腿', '3', '1', '29.99', '/eureka-web/img/cp.jpg', '萨拉米 1+1小鸡腿 详情');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datetime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `summoney` decimal(10,2) DEFAULT NULL,
  `state` tinyint(4) NOT NULL COMMENT '订单状态',
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('9', '2018-01-03 16:59:50', '8.90', '0', '2');
INSERT INTO `order` VALUES ('10', '2018-01-04 10:07:43', '8.90', '0', '2');

-- ----------------------------
-- Table structure for order_category
-- ----------------------------
DROP TABLE IF EXISTS `order_category`;
CREATE TABLE `order_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `order_category_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `order_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_category
-- ----------------------------
INSERT INTO `order_category` VALUES ('5', '9', '2', '1', '2018-01-03 14:32:32');
INSERT INTO `order_category` VALUES ('6', '10', '2', '1', '2018-01-04 10:07:43');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `num` int(11) NOT NULL,
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '苏雄伟', '123456', '18361246696', '苏州科达');
INSERT INTO `user` VALUES ('3', 'test', '123456', '18361222222', '科达');
