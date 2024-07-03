CREATE TABLE `user` (
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
                             `name` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户名',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci