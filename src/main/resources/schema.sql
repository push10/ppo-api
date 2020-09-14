create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table content
(
   id integer not null,
   title varchar(255) not null,
   description varchar(255) not null,
   url varchar(100) ,
   primary key(id)
);