DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`
(
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200)  DEFAULT '' COMMENT '流水号' ,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;