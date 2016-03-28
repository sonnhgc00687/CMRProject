create database Project_CMR
go
use Project_CMR
go
create table tblEmployee
(
username nvarchar(50) primary key,
[password] nvarchar(200),
fullname nvarchar(50),
email nvarchar(50),
role int
)
--0.Admin
--1.Course Leader
--2.Course Moderator
--3.PVC
--4.DLT 
insert into tblEmployee values('sonnguyen','123456','Son Nguyen',null, 0)
insert into tblEmployee values('mainghia','123456','Mai Nghia','nghiamtgc00662@fpt.edu.vn', 1)
insert into tblEmployee values('sondao','123456','Son Dao', 'sondtgc00678@fpt.edu.vn', 2)
insert into tblEmployee values('ducphuc','123456','Duc Phuc',null, 3)
insert into tblEmployee values('hoangha','123456','hoangha',null, 4)
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
id int primary key IDENTITY,
course_code nvarchar(8),
course_faculty nvarchar(8)references tblFaculty(faculty_code),
course_title nvarchar(50),
course_leader nvarchar(50),
/*references tblEmployee(username),*/
course_mod nvarchar(50),
/* references tblEmployee(username),*/
[start_date] date,
[end_date] date,
description nvarchar(100),
[status] int,
)
insert into tblCourse values('COMP1640', 'FPT2016', 'Enterprise Web Software Development', 'mainghia', 'sondao','2016-01-16', '2016-05-04', 'abc', 1)
insert into tblCourse values('COMP1649', 'FPT2016', 'Interaction Design', 'mainghia', 'sondao', '2016-01-15', '2016-05-06', 'abc', 1)
insert into tblCourse values('COMP1649', 'FPT2016', 'Interaction Design', 'mainghia', 'sondao', '2016-01-15', '2016-05-06', 'abc', 1)
go
create table tblCMR
(
cmr_code int primary key references tblCourse(id),
student_count int,
comment nvarchar(1000),
[status] int
)
go
create table tblStaticalData
(
id int primary key IDENTITY,
cmr_id int references tblCMR(cmr_code), 
id_mark int,
mean int,
median float,
standard_deviation int
)
go
create table tblGradeData
(
id int primary key IDENTITY,
cmr_id int references tblCMR(cmr_code),
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

create procedure getCourseDetail 
@courseID int
as
begin
select course_code, faculty_title, course_title, a.fullname as course_leader, b.fullname as course_mod,
tblCourse.[start_date], tblCourse.[end_date], [description], tblCourse.[status]
from tblCourse inner join tblFaculty on tblCourse.course_faculty = tblFaculty.faculty_code
inner join tblEmployee as a
on tblCourse.course_leader = a.username
inner join tblEmployee as b
on tblCourse.course_mod = b.username
where tblCourse.id = @courseID
end

exec getCourseDetail 1

create procedure getCMRDetail
@cmr_code int
as
begin
select cmr_code, course_title, fullname, student_count, comment, tblCMR.[status], tblStaticalData.id_mark as staticalData_id_mark, mean, median, standard_deviation, tblGradeData.id_mark, mark0,
mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8, mark9 from tblCMR inner join tblStaticalData on 
tblCMR.cmr_code = tblStaticalData.cmr_id inner join tblGradeData on tblCMR.cmr_code = tblGradeData.cmr_id
inner join tblCourse on tblCMR.cmr_code = tblCourse.id inner join tblEmployee on tblCourse.course_leader = tblEmployee.username
where tblStaticalData.id_mark = tblGradeData.id_mark and cmr_code = @cmr_code
end

select * from tblCMR
select * from tblCourse where course_title like '%%'
select * from tblStaticalData
select * from tblGradeData
select * from tblEmployee

SELECT tblCMR.cmr_code, tblCMR.student_count,tblCourse.course_title,tblCourse.course_faculty
FROM tblCMR
INNER JOIN tblCourse
ON tblCMR.cmr_code = tblCourse.id

exec getCMRDetail 1

exec getCourseDetail 2

select  cmr_code, student_count, comment, cmr.[status],c.course_code,c.course_title,c.course_faculty from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where c.course_mod = 'sondao' and cmr.status = 0

SELECT COUNT(*) AS countNum FROM 
(Select * from tblCourse) AS subquery