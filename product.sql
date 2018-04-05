/*
SQLyog v10.2 
MySQL - 5.5.49 : Database - test03
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test03` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test03`;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`NAME`,`COUNT`,`price`) values (1,'电视机',100,2000),(2,'洗衣机',200,1000),(3,'空调',300,3000),(4,'投影仪',50,2000),(5,'HP电脑',1000,4000),(6,'苹果手机',100,5000),(7,'缝纫机',60,2000),(8,'小米盒子',100,2200),(9,'饮水机',300,2000),(10,'净水器',200,2000),(11,'电暖器',500,2000),(12,'榨汁机',100,399),(13,'电压力锅',200,498),(14,'电饭煲',300,299),(15,'微波炉',50,1299),(16,'豆浆机',200,199),(17,'电磁炉',300,398),(18,'加湿器',500,99),(19,'剃须刀',250,98),(20,'舒肤佳',1000,16.5),(21,'雕牌',1200,8.8),(22,'立白',1500,9.9);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
