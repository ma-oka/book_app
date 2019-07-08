create table books(
id varchar(256) not null,
name varchar(256) not null,
author varchar(256) default null,
published_date date default null,
description varchar(256) default null,
  primary key (id)
)engine=InnoDB default charset=utf8mb4 row_format=dynamic;