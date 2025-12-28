/*
create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id));
*/
insert into user values(1000,sysdate(),'Sonia');
insert into user values(1001,sysdate(),'Rohan');
insert into user values(1002,sysdate(),'Monika');
insert into user values(1003,sysdate(),'Pappu');

/*create table post (post_id integer not null, description varchar(255), user_id integer, primary key (post_id))*/

insert into post values(2001,'First post',1001);
insert into post values(2002,'Second post',1001);
insert into post values(2003,'Third post',1001);
insert into post values(2004,'First post',1002);
insert into post values(2005,'Second post',1002);
insert into post values(2006,'Third post',1002);