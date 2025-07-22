
use intern;
show tables;
create table department_s(
id int primary key,
name varchar(20),
dob date,
city varchar(20));
insert into department_s(id,name,dob,city)
values
(15,"shyam",'2004-06-22',"vzm"),
(36,"balaram",'2003-05-15',"salur"),
(37,"akbar",'2003-12-22',"parvatipuram");
alter table department_s rename to student_shyam;
select * from student_shyam;
create table department_s(
dept_id int primary key,
dept_name varchar(20),
hod varchar(20));
insert into department_s(dept_id,dept_name,hod)
values
(05,"cse","ramarao"),
(02,"eee","ramana"),
(03,"ece","rajan babu");
select * from department_s;
create table department_s(
dept_id int primary key,
dept_name varchar(20),
hod varchar(20));
insert into department_s(dept_id,dept_name,hod)
values
(05,"cse","ramarao"),
(02,"eee","ramana"),
(03,"ece","rajan babu");

-- 5.SQL Basics: DDL & DML

create table course_shyam(
course_id int primary key,
course_name varchar(20),
instructor varchar(20));
insert into course_shyam(course_id,course_name,instructor)
values
(1,"java","navin reddy"),
(2,"javascript","shradha"),
(3,"python","harry");
select * from course_shyam;
alter table course_shyam add duration int;
desc course_shyam;
alter table course_shyam modify course_id int not null auto_increment;
update course_shyam set duration=10 where course_id=1;
update course_shyam set duration=13 where course_id=2;
update course_shyam set duration=15 where course_id=3;

update student_shyam set name="AK bar" where id =37;
select * from student_shyam;
delete from course_shyam where course_id=3;
select timestampdiff(year,dob,curdate()) as age from student_shyam;  
alter table student_shyam add age int;
desc student_shyam;
set sql_safe_updates=0;
update student_shyam 
set age=timestampdiff(year,dob,curdate());
update student_shyam set dob='2002-06-23' where id=37;
select name,dob from student_shyam order by age desc;
select name from student_shyam order by age limit 2;


drop table department_s;
drop table student_shyam;
drop table course_shyam;
create table department_shyam(
dept_id int,
dept_name varchar(15));
alter table department_shyam
modify column dept_id varchar(5) primary key; 
alter table department_shyam
modify column dept_name varchar(20); 
insert into department_shyam(dept_id,dept_name)
values
("D1", "Computer Science"),
("D2", "Mathematics"),
("D3", "Physics");
select * from department_shyam;
create table courses_shyam(
course_id varchar(5) primary key,
course_name varchar(25),
dept_id varchar(5),
foreign key (dept_id) references department_shyam(dept_id));
insert into courses_shyam
values
("C1", "DBMS", "D1"),
("C2", "Linear Algebra", "D2"),
("C3", "Quantum Mechanics", "D3");
select * from courses_shyam;
create table student_shyam(
student_id varchar(5) primary key,
student_name varchar(25),
dob date,
age int,
dept_id varchar(5),
foreign key (dept_id) references department_shyam(dept_id));
select *from student_shyam;
alter table courses_shyam
add column duration int;
update courses_shyam set duration=15 where course_id="C1";
update courses_shyam set duration=13 where course_id="C2";
update courses_shyam set duration=10 where course_id="C3";
update student_shyam set student_name="Sneha Reddy" where student_id="S2";
DELETE FROM COURSES_SHYAM WHERE COURSE_ID="C3";


-- 6. SELECT Queries & Filtering

SELECT STUDENT_NAME FROM STUDENT_SHYAM WHERE AGE>21;
SELECT STUDENT_NAME,DOB FROM STUDENT_SHYAM ORDER BY AGE;
SELECT STUDENT_NAME,DOB FROM STUDENT_SHYAM ORDER BY AGE LIMIT 2;


-- 7. Aggregates & GROUP BY

SELECT COUNT(*),DEPT_ID FROM STUDENT_SHYAM GROUP BY DEPT_ID;
SELECT AVG(AGE),DEPT_ID FROM STUDENT_SHYAM GROUP BY DEPT_ID;
SELECT MAX(AGE) FROM STUDENT_SHYAM;
SELECT MIN(AGE) FROM STUDENT_SHYAM;

-- 8. Transaction Control Language


CREATE TABLE ACCOUNTS_SHYAM(
ACCOUNT_ID INT PRIMARY KEY,
HOLDER_NAME VARCHAR(20),
BALANCE FLOAT );
INSERT INTO ACCOUNTS_SHYAM
VALUES
(1,"ALICE",5000),
(2,"BOB",3000),
(3,"CHARLIE",4000);
SELECT * FROM ACCOUNTS_SHYAM;
set autocommit =0;
COMMIT;
UPDATE ACCOUNTS_SHYAM SET BALANCE=(BALANCE-1000) WHERE ACCOUNT_ID=1;
UPDATE ACCOUNTS_SHYAM SET BALANCE=(BALANCE+1000) WHERE ACCOUNT_ID=2;
ROLLBACK;
begin;
UPDATE ACCOUNTS_SHYAM SET BALANCE=(BALANCE-1000) WHERE ACCOUNT_ID=1;
savepoint after_debit;
UPDATE ACCOUNTS_SHYAM SET BALANCE=(BALANCE+1000) WHERE ACCOUNT_ID=2;
UPDATE ACCOUNTS_SHYAM SET BALANCE=(BALANCE+500) WHERE ACCOUNT_ID=3;
rollback to after_debit;
commit;


-- 10. Data Integrity & Constraints


alter table courses_shyam
add column course_code varchar(20);
update courses_shyam set course_code="CS101" where course_id="c1";
update courses_shyam set course_code="MATH205" where course_id="c2";
update courses_shyam set course_code="PHY303" where course_id="c3";
alter table courses_shyam
drop column course_code;
insert into courses_shyam values
("C3", "Quantum Mechanics", "D3",10);
select * from courses_shyam;
alter table courses_shyam
 modify column course_code varchar(20) unique;

alter table courses_shyam
add column credits int check (credits>=1 and credits<=5);
update courses_shyam set credits=4 where course_id="c1";
update courses_shyam set credits=3 where course_id="c2";
update courses_shyam set credits=5 where course_id="c3";


--  9. Joins, Set Operations & Advanced Querying


select s.student_name , d.dept_name 
from student_shyam s
inner join department_shyam d
on s.dept_id=d.dept_id;
select s.student_name,d.dept_name
from department_shyam d
right join student_shyam s
on s.dept_id=d.dept_id;

select count(s.student_id) as count,d.dept_name from
student_shyam s right join
department_shyam d
on s.dept_id=d.dept_id
group by d.dept_name;

-- common table expression

with student_count as(
select count(s.student_id) as count,d.dept_name from
student_shyam s right join
department_shyam d
on s.dept_id=d.dept_id
group by d.dept_name
)
select *from student_count;
  
create table employee_shyam(
emp_id varchar(10) primary key,
emp_name varchar(25),
dept_name varchar(20),
manager_id varchar(10)
);
insert into employee_shyam values
("e101","shyam","developer",""),
("e102","balaram","testing","e101"),
("e103","akbar","testing","e102"),
("e104","manoj","hr","e101"),
("e105","sai","developer","e101"),
("e106","lahar","IT","e105");
SELECT * FROM EMPLOYEE_SHYAM;
select e1.emp_name as Employee,e.emp_name as Manager
from employee_shyam as e
join employee_shyam as e1
on e.emp_id=e1.manager_id;


select dept_id,avg(age) from student_shyam group by dept_id;
select dept_id,age,student_name from student_shyam s 
where age >(
select avg(age) from student_shyam where dept_id=s.dept_id group by dept_id);

with stud_count as(
select dept_id,count(*) from student_shyam group by dept_id)

select * from stud_count;

--  11. Views


create view student_detail as(
select s.student_id,s.student_name,d.dept_id
from student_shyam s
inner join department_shyam d
on s.dept_id=d.dept_id);

select * from student_detail;
update student_detail set student_name="shyam" where student_id="S1"; 
select * from student_shyam;
