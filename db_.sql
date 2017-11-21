/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.27 : Database - dbjunit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbjunit` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dbjunit`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `age` int(4) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`Id`,`username`,`password`,`age`,`address`) values (3,'wangwu','wangwu',25,'北京市丰台区'),(4,'customer1','123456',20,'北京市'),(5,'customer2','123456',20,'北京市'),(6,'xiao9','xiao9',69,'上海市'),(7,'customer4','123456',20,'北京市'),(8,'customer5','123456',20,'北京市'),(9,'customer6','123456',20,'北京市'),(10,'customer7','123456',20,'北京市'),(11,'customer8','123456',20,'北京市'),(12,'customer9','123456',20,'北京市'),(13,'customer0','123456',20,'北京市'),(14,'customer11','123456',20,'北京市'),(15,'customer23','123456',20,'北京市'),(16,'customer44','123456',20,'北京市'),(17,'customer55','123456',20,'北京市'),(18,'customer66','123456',20,'北京市'),(19,'customer66','123456',20,'北京市'),(20,'customer66','123456',20,'北京市'),(21,'xiao6','xiao6',29,'上海市'),(22,'xiao7','xiao7',69,'上海市'),(23,'xiao7','xiao7',69,'上海市'),(24,'xiao7','xiao7',69,'上海市'),(25,'xiao7','xiao7',69,'上海市'),(26,'xiao7','xiao7',69,'上海市');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
