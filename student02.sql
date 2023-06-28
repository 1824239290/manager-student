/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.26 : Database - student02
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`student02` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `student02`;

/*Table structure for table `clazz` */

DROP TABLE IF EXISTS `clazz`;

CREATE TABLE `clazz` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `clazzName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `gid` int DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `clazz` */

insert  into `clazz`(`cid`,`clazzName`,`gid`) values (2,'四年级1班',3),(3,'四年级2班',3),(7,'五年级1班',2),(8,'五年级2班',2),(10,'五年级3班',2),(11,'五年级4班',2),(12,'一年级1班',6),(13,'四年级4班',3),(14,'四年级八班',3),(15,'四年级八班22',3);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `course` */

insert  into `course`(`cid`,`courseName`) values (18,'英语'),(19,'体育'),(20,'生物'),(21,'音乐'),(22,'地理'),(32,'语文'),(33,'数学'),(34,NULL),(35,NULL);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `gid` int NOT NULL AUTO_INCREMENT,
  `gradeName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `grade` */

insert  into `grade`(`gid`,`gradeName`) values (2,'五年级'),(3,'四年级'),(15,'a'),(16,'b'),(17,'c'),(18,'d'),(19,'e'),(20,'f');

/*Table structure for table `grade_course` */

DROP TABLE IF EXISTS `grade_course`;

CREATE TABLE `grade_course` (
  `gcid` int NOT NULL AUTO_INCREMENT,
  `gid` int DEFAULT NULL,
  `cid` int DEFAULT NULL,
  PRIMARY KEY (`gcid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `grade_course` */

insert  into `grade_course`(`gcid`,`gid`,`cid`) values (4,2,18),(5,2,19),(7,3,18),(8,3,19),(9,3,20);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'ROLE_admin'),(2,'ROLE_user');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `gender` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `qq` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `cid` int DEFAULT NULL,
  `gid` int DEFAULT NULL,
  PRIMARY KEY (`sid`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `student` */

insert  into `student`(`sid`,`number`,`name`,`gender`,`phone`,`qq`,`cid`,`gid`) values (3,'444','zhangsan','男','13166666666','1111',2,3),(4,'555','zhangsan','男','13166666666','1111',6,1),(5,'666','zhangsan','男','13166666666','1111',6,1),(6,'777','zhangsan','男','13166666666','1111',6,1);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `gender` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `qq` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  PRIMARY KEY (`tid`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `teacher` */

insert  into `teacher`(`tid`,`number`,`name`,`gender`,`phone`,`qq`) values (10,'0001','张三22','男','13111111111','123'),(11,'0002','李四','女','13111111111','123'),(12,'0003','王五22','男','13111111111','45622'),(13,'0004','赵六','男','13111111111','123'),(14,NULL,'王五：0','男：0',NULL,NULL),(15,NULL,'王五：1','男：1',NULL,NULL),(16,NULL,'王五：2','男：2',NULL,NULL),(17,NULL,'王五：3','男：3',NULL,NULL),(18,NULL,'王五：4','男：4',NULL,NULL);

/*Table structure for table `teacher_course` */

DROP TABLE IF EXISTS `teacher_course`;

CREATE TABLE `teacher_course` (
  `tcid` int NOT NULL AUTO_INCREMENT,
  `tid` int DEFAULT NULL,
  `gid` int DEFAULT NULL,
  `clazzId` int DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  PRIMARY KEY (`tcid`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `teacher_course` */

insert  into `teacher_course`(`tcid`,`tid`,`gid`,`clazzId`,`courseId`) values (31,13,2,7,18),(32,13,2,7,19),(33,10,2,7,18),(34,10,2,7,19),(35,11,2,7,19),(36,11,3,2,18),(37,11,3,3,18);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_croatian_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `role` int DEFAULT NULL COMMENT '1 学生 2 老师 3 管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`nickname`,`password`,`enabled`,`role`) values (1,'admin','系统管理员','123',1,3),(2,'zhangsan',NULL,'123',1,NULL);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `rid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

/*Data for the table `user_role` */

insert  into `user_role`(`id`,`uid`,`rid`) values (1,1,1),(2,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
