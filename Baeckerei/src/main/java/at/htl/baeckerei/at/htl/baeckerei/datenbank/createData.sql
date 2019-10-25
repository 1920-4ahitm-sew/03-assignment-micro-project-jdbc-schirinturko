--SQL

drop table kunde;

create table kunde(
    id int,
    name varchar(20)
);

insert into kunde (id,name) values(1,'Lisa');
insert into kunde (id,name) values(2,'Stefan');

select * from kunde;