/* if not exists concept */
create database IF NOT EXISTS xyz;
/* select a database */
use xyz;
/* if exists concept */
drop table if exists employee;
/* create table and primary key concept */
create table employee(
id INT auto_increment, 
name varchar(50),
salary INT,
primary key (id)
);
/* alter table concept */
alter table employee modify column id INT PRIMARY KEY  auto_increment;
/* inserting data into table */
insert into employee (name,salary) values('adam', 25000);
insert into employee (name,salary) values('bob', 30000);
insert into employee (name,salary) values('casey', 40000);
select * from employee;

/* Foreign key  and default value concept */
create table temp(
	emp_id int,
    salary int default 35000,
    foreign key(emp_id) references employee(id)
);
/* constraints concept */
create table person(
	id INT primary key,
    city varchar(100),
    age int,
    constraint age_check check(age>=18 and city='Bangalore')
);
create table person2(
	age int check(age>=18)
);
/* prep data for subsequent lessons */
create database if not exists college;
use college;
drop table if exists student;
create table student(
	rollNo int primary key,
    name varchar(50),
    marks int not null,
    grade varchar(1),
    city varchar(20)
);

insert into student(rollNo, name,marks, grade, city) values(101,'Anil',77,'C','Pune');
insert into student(rollNo, name,marks, grade, city) values(102,'Bhumika',88,'A','Mumbai');
insert into student(rollNo, name,marks, grade, city) values(103,'Chetan',90,'B','Mumbai');
insert into student(rollNo, name,marks, grade, city) values(104,'Dhruv',85,'A','Delhi');
insert into student(rollNo, name,marks, grade, city) values(105,'Emanuel',12,'F','Delhi');
insert into student(rollNo, name,marks, grade, city) values(106,'Farah',82,'B','Delhi');
select * from student;

/* select distinct */
select distinct city from student;

/* filter data using where clause */
select * 
from student 
where marks >80;

select *
from student
where marks > 80 and city='Delhi';

/* operators */
select * from student where marks+10 > 80;
select * from student where marks = 90;
select * from student where marks between 80 and 90;
select * from student where city in("Mumbai","Pune","Miami");
select * from student where city not in("Mumbai",'Pune');
/* limit */
select * from student limit 3;

select *
from student
order by city
desc;

/* Top 3 students with highest marks */
select *
from student
order by marks desc
limit 3;

/* Aggregate functions count(), max(), min(), sum(), avg() */
select max(marks) from student;
select min(marks) from student;
select avg(marks) from student;
select sum(marks) from student;
select count(name) from student;

/* Group By example: count number of students in each city */
select city,count(name) as students
from student
group by city;

select city,grade,count(name) as students
from student
group by city, grade;

/* Average marks of student in each city */
select city, avg(marks)
from student
group by city;

/* Query to find average marks in each city in scending order */
select city,avg(marks) as avg_marks
from student
group by city
order by avg_marks asc;

create table if not exists payment(
	customer_id int,
    customer varchar(50),
    mode varchar(20),
    city varchar(100),
    primary key(customer_id)
);
insert into payment values(101,'Olivia','Netbanking','Portland');
insert into payment values(102,'Ethan','Credit Card','Miami');
insert into payment values(103,'Maya','Credit Card','Seattle');
insert into payment values(104,'Liam','Netbanking','Denver');
insert into payment values(105,'Sophia','Credit Card','Boston');
insert into payment values(106,'Caleb','Debit Card','Boston');
insert into payment values(107,'Ava','Debit Card','Mumbai');
insert into payment values(108,'Lucas','Netbanking','Pune');
insert into payment values(109,'Isabella','Netbanking','Bangalore');
insert into payment values(110,'Jackson','Credit Card','Delhi');
/* display number of payments for each payment method */
select mode, count(customer_id) as payment_frequency
from payment
group by mode;

select grade, count(rollNo) as count
from student
group by grade;

/* Having clause: Used to apply condition over groups unlike where which applies condition on rows */
/* Count number of students in each city where max marks cross 90 */
select city, count(rollNo)
from student
group by city
having max(marks) > 80;

select * from student where city in (select city
from student
group by city
having max(marks) > 80);

/* General Query order 

select column(s)
from table_name
where condition(s)
group by column(s)
having condition
order by column(s) desc

*/
select customer, mode as payment_mode
from payment
where mode not in ('Netbanking')
group by customer, payment_mode
having mode ='Credit Card'
order by customer asc;

select city, name
from student
where grade='A'
group by city,name 
having max(marks) > 80
order by name asc;

/* Update operations */
set sql_safe_updates=0;
update student
set grade='O'
where grade='A';
select * from student;

update student
set grade='B'
where marks between 80 and 90;

update student
set marks=marks+1;
select * from student;

/* Delete Query */

delete from student
where marks <30;
use college;

/* Foreign key concept */
create table if not exists department(
	dept_id int primary key,
    dept_name varchar(50)
);

create table if not exists teacher(
	id int primary key,
    name varchar(50),
    dept_id int,
    foreign key(dept_id) references department(dept_id)
);

/* Cascade in foreign key */
create table if not exists teacher(
	id int primary key,
    name varchar(50),
    dept_id int,
    foreign key(dept_id) references department(dept_id)
    on delete cascade
    on update cascade
);

/* Alter command */
/* Add new column to existing table */
alter table student
add column age int;
/* remove column from existing table */
alter table student
drop column age;

/* rename table name */
alter table student
rename to STUDENT;

/* Rename existing column in a table */
alter table student
change column age student_age int not null;

/* Modify datatype/constaraint of a column */
alter table student
modify age int not null;

alter table student
add column age int not null default 18;

alter table student
modify column age tinyint;

alter table student
change age student_age int null null default 18;

alter table student
drop column student_age;

alter table student
rename to student_info;

select * from student_info;

/* delete table data */
truncate table student_info;

/* Difference between delete from and truncate to delete table data
https://www.geeksforgeeks.org/difference-between-delete-and-truncate/
*/

/* Joins in SQL */

/* Inner Join(Common of both tables) */
create table if not exists course(
	id int primary key,
    course varchar(50)
);
insert into course values(102, 'English');
insert into course values(105, 'Hindi');
insert into course values(103, 'Punjabi');
insert into course values(107, 'French');

select * from student_info;
select * from course;

select * from
student_info
inner join course
on student_info.rollNo=course.id;

select * from
student_info as s
inner join course as c
on s.rollNo=c.id;

/* Left Join(All data in left table including common with right table) */
select * from
student_info as s
left join course as c
on s.rollNo=c.id;

/* Right Join(All data in right table including common with left table) */
select * from
student_info as s
right join course as c
on s.rollNo=c.id;

/* Full Join(Returns data from both tables including common) left join union right join*/
select * from
student_info as s
left join course as c
on s.rollNo=c.id
union
select * from
student_info as s
right join course as c
on s.rollNo=c.id;

/* Left exclusive join(Data from only left table excluding common) */
select * from
student_info as s
left join course as c
on s.rollNo=c.id
where c.id is null;

/* Right exclusive join(Data from only right table excluding common) */
select * from
student_info as s
right join course as c
on s.rollNo=c.id
where s.rollNo is null;

/* Full exclusive join(Left and right table data excluding common) */
select * from
student_info as s
left join course as c
on s.rollNo=c.id
where c.id is null
union
select * from
student_info as s
right join course as c
on s.rollNo=c.id
where s.rollNo is null;

/* Self join(join table with copy of itself) */
/* Find manager of every employee */
create table if not exists employee(
	id int,
    name varchar(50),
    manager_id int,
    primary key(id)
);

insert into employee values(101,'adam',103);
insert into employee values(102,'bob',104);
insert into employee values(103,'casey',null);
insert into employee values(104,'donald',103);

select a.name as manager_name, b.name as employee_name
from employee as a
join employee as b
on a.id=b.manager_id;

/* Sub queries 1.Where 2.From 3.Select */

/* get names of all students who scored more than class average */
select name from student_info where marks > (select avg(marks) from student_info);
/* Find the names of all students with even roll numbers */
select name,rollNo from student_info where rollNo in (select rollNo from student_info where rollNo%2=0);
/* Find the max marks from the students of Delhi */
select max(marks) 
from (
select * 
from student_info
where city='Delhi'
) as student_info_derived;

select(select max(marks) from student_info) as max_marks, name from student_info;

/* Views */
create view student_view as
select rollNo, name, marks from student_info;

select * from student_view;

drop view student_view;