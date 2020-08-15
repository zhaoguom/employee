# employee
Simple Sample of SpringBoot/Thymeleaf

---
create database miaosha;

drop table if exists `employee`;

create table `employee` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` varchar(50) NOT NULL,
`last_name` varchar(50) NOT NULL,
`email` varchar(128) NOT NULL
PRIMARY KEY(`id`)
) engine=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

---