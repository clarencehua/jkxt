/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - bbs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bbs`;

/*Table structure for table `userb` */

DROP TABLE IF EXISTS `userb`;

CREATE TABLE `userb` (
  `userId` int(40) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(40) NOT NULL COMMENT '用户名称',
  `password` varchar(40) NOT NULL,
  `level` int(40) DEFAULT '1' COMMENT '用户等级',
  `postNum` int(40) DEFAULT NULL COMMENT '发帖数',
  `userCode` varchar(40) DEFAULT NULL COMMENT '用户代码',
  `realName` varchar(40) DEFAULT NULL,
  `court` varchar(8) DEFAULT NULL,
  `power` int(8) DEFAULT '1',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `userb` */

insert  into `userb`(`userId`,`userName`,`password`,`level`,`postNum`,`userCode`,`realName`,`court`,`power`) values (1,'chengkang','123',4,NULL,NULL,'程康','高院',4),(2,'zhangzhenghua','123',3,NULL,NULL,'张振华','一中院',1),(3,'zhaocong','123',2,NULL,NULL,'赵聪','二中院',2),(9,'张三','2222',2,NULL,NULL,'张大刀','北京法院',1),(10,'gao','123',1,NULL,NULL,'zxc','高院',2),(13,'asd','qwe',1,NULL,NULL,'asd','sad',2),(14,'asdasd','123',1,NULL,NULL,'asdasd','dfg',2),(15,'asd','as',1,NULL,NULL,'asd','qw',1),(16,'asd','asd',1,NULL,NULL,'asd','qwe',1),(17,'csdfsdf','qw',2,NULL,NULL,'sdfsd','qwe',2),(18,'asda','asd',1,NULL,NULL,'asd','asd',1),(19,'4','123',NULL,NULL,NULL,NULL,NULL,1),(20,'4','123',NULL,NULL,NULL,NULL,NULL,1),(21,'4','123',NULL,NULL,NULL,NULL,NULL,1),(22,'4','123',NULL,NULL,NULL,NULL,NULL,1),(23,'4','123',NULL,NULL,NULL,NULL,NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
