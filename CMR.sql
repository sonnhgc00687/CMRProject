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
--3.PVC
--4.DLT 
insert into tblEmployee values('sonnguyen','123456','Son Nguyen', 0)
insert into tblEmployee values('mainghia','123456','Mai Nghia', 1)
insert into tblEmployee values('sondao','123456','Son Dao', 2)
insert into tblEmployee values('ducphuc','123456','Duc Phuc', 3)
insert into tblEmployee values('hoangha','123456','hoangha', 4)
go
create table tblFaculty
(
faculty_code nvarchar(8) primary key,
faculty_title nvarchar(50),
faculty_pvc nvarchar(50) references tblEmployee(username),
faculty_dlt nvarchar(50) references tblEmployee(username),
[start_date] date,
[end_date] date,
[status] int
)
insert into tblFaculty values('FPT2016', 'Honours Programme', 'ducphuc', 'hoangha','2016-01-01', '2016-12-31', 1)
go
create table tblCourse
(
course_code nvarchar(8) primary key,
course_faculty nvarchar(8) references tblFaculty(faculty_code),
course_title nvarchar(50),
course_leader nvarchar(50) references tblEmployee(username),
course_mod nvarchar(50) references tblEmployee(username),
[start_date] date,
[end_date] date,
[status] int,
)
insert into tblCourse values('COMP1640', 'FPT2016', 'Enterprise Web Software Development', 'mainghia', 'sondao','2016-01-16', '2016-05-04', 1)
insert into tblCourse values('COMP1649', 'FPT2016', 'Interaction Design', 'mainghia', 'sondao', '2016-01-15', '2016-05-06', 1)
go
create table tblCMR
(
cmr_code nvarchar(8) primary key references tblCourse(course_code),
student_count int,
comment nvarchar(1000),
[status] int
)
go
create table tblStaticalData
(
id nvarchar(8) primary key references tblCMR(cmr_code), 
id_mark int,
mean int,
median float,
standard_deviation int
)
go
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
