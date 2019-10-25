--SQL

drop table kunde;

create table kunde(
    id int constraint kunde_pk primary key,
    name varchar(20) not null
);

insert into kunde (id,name) values(1,'Lisa');
insert into kunde (id,name) values(2,'Stefan');

select * from kunde;