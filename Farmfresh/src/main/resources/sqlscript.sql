create database farmfresh;
use farmfresh;
create table menuitem(id int NOT NULL primary key AUTO_INCREMENT,itemName varchar(20)  NOT NULL, price float  NOT NULL, farmerName varchar(20)  NOT NULL, location varchar(60)  NOT NULL,quantity float,stock float  NOT NULL,category varchar(20)  NOT NULL);
create table cart( userId int NOT NULL,farmerId int NOT NULL, menuitemId int NOT NULL,total float NOT NULL ,delivered boolean  DEFAULT false);
create table login(uid int NOT NULL primary key AUTO_INCREMENT,username varchar(20) NOT NULL,email varchar(50) NOT NULL,pswd varchar(20) NOT NULL);
create table rating(fname varchar(20),cname varchar(20),email varchar(50),rateService int,pros varchar(100),cons varchar(100),comments varchar(100));
SET SQL_SAFE_UPDATES=0;