-- --------------------------------------------------------
-- 主机:                           192.168.100.10
-- 服务器版本:                        5.7.28 - MySQL Community Server (GPL)
-- 服务器OS:                        Linux
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table shop_plus_house.sys_resource
CREATE TABLE IF NOT EXISTS `sys_resource` (
  `id` bigint(22) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `parent_id` bigint(22) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `seq` int(11) DEFAULT NULL,
  `deep` int(11) DEFAULT NULL COMMENT '深度',
  `parent_path` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `is_hidden` bit(1) DEFAULT NULL COMMENT '是否隐藏 0 否 1 是',
  `redirect` varchar(100) DEFAULT NULL COMMENT '菜单指向',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table shop_plus_house.sys_role
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(22) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table shop_plus_house.sys_role_resource
CREATE TABLE IF NOT EXISTS `sys_role_resource` (
  `id` bigint(22) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `role_id` bigint(22) DEFAULT NULL,
  `resource_id` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table shop_plus_house.sys_user
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(22) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

-- Dumping structure for table shop_plus_house.sys_user_role
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(22) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `user_id` bigint(22) DEFAULT NULL,
  `role_id` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
