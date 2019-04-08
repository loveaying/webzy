--drop database if exists demo;
create database demo default character set utf8;
use demo;
drop table if exists product;
--drop table if exists category;
--create table category
--(
--   cid                  int not null auto_increment,
--   cname                varchar(20),
--   primary key (cid)
--);
create table product
(
   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP,
   primary key (id)
);
--insert into category (cname) values ('男士服装');
--insert into category (cname) values ('电脑设备');
/* 商品测试用例 */
insert into product (name,price,remark) values ('圣得西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('衫衫西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('Iphone6',6000.00,'这里是简单介绍');
--select * from category;
select * from product;