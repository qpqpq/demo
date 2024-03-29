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

--------------------
create table bishe.user(
phone varchar(11)primary key,
name varchar(64),
password varchar(64),
sex varchar(1),
birthday varchar(8),
idcard varchar(18),
postcode varchar(8),
health varchar(1),
height varchar(8),
weight varchar(8),
xiyan varchar(8),
yinjiu varchar(8),
food varchar(4),
address varchar(64)
);

create table bishe.pressure(
phone varchar(11),
high varchar(4),
low varchar(4),
maibo varchar(4),
time varchar(16)
);

create table bishe.sugar(
phone varchar(11),
time varchar(8),
qujian varchar(4),
num varchar(8)
);

create table bishe.weight(
phone varchar(11),
num varchar(8),
time varchar(8)
);

create table bishe.exercise(
phone varchar(11),
time varchar(8),
type varchar(8),
strength varchar(8),
ctime varchar(8)
);

create table bishe.yao(
phone varchar(11),
name varchar(64),
zhuzhi varchar(128),
time varchar(8),
num varchar(8),
type varchar(8)
);

create table bishe.state(
phone varchar(11),
state varchar(16)
);