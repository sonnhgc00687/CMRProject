create database Project_CMR
go
use Project_CMR
go
create table tblEmployee
(
username nvarchar(50) primary key,
[password] nvarchar(50),
fullname nvarchar(50),
role int
)
--0.Admin
--1.Course Leader
--2.Course Moderator 
insert into tblEmployee values('sonnguyen','123456','Son Nguyen', 0)
insert into tblEmployee values('mainghia','123456','Mai Nghia', 1)
insert into tblEmployee values('sondao','123456','Son Dao', 2)
go
create table tblCourse
(
course_code nvarchar(8) primary key,
course_title nvarchar(50),
course_leader nvarchar(50) references tblEmployee(username),
course_mod nvarchar(50) references tblEmployee(username),
[start_date] date,
[end_date] date,
[status] int,
)
insert into tblCourse values('COMP1640', 'Enterprise Web Software Development', 'mainghia', 'sondao','2016-01-16', '2016-05-04', 1)
insert into tblCourse values('COMP1649', 'Interaction Design', 'mainghia', 'sondao', '2016-01-15', '2016-05-06', 1)
go
create table tblCMR
(
cmr_code nvarchar(8) primary key,
course_code nvarchar(8) references tblCourse(course_code),
course_title nvarchar(50),
course_leader nvarchar(50),
student_count int,
comment nvarchar(1000)
)
go
create table tblStaticalData
(
id int primary key,
mean int,
median float,
standard_deviation int
)

create table tblGradeData
(
id nvarchar(8) primary key references tblCMR(cmr_code),
id_mark int,
mark0 int,
mark1 int,
mark2 int,
mark3 int,
mark4 int,
mark5 int,
mark6 int,
mark7 int,
mark8 int,
mark9 int
)
