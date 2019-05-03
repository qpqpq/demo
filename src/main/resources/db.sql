create database bishe;
use bishe;
create table user(id varchar(128) primary key,
picture varchar(128),
name varchar(64) not null,
password varchar(64) not null,
birthday datetime,
idcard varchar(32),
family varchar(64),
postcode varchar(16),
phone varchar(16),
state int,
height int,
weight int,
xiyan int,
yinjiu int,
yinshi int
);
create table xueya_id(
di int,
gao int,
maibo int,
date datetime,
);
create table xuetang_id(
time int,
shuzhi int,
date datetime
);
create table yongyao_id(
name varchar(16),
zhuzhi varchar(64),
cishu int,
yongliang int,
fangshi int
);
create table tizhong_id(
weight int
date datetime
);
create table yundong_id(
time int,
type int,
strength int,
date datetime
);
create table richang_id(
shuimian int,
wushui int,
yinshi int,
yinjiu int,
xinqing int,
zhengzhuang varchar(64),
date datetime
);