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
insert into tblEmployee values('sonnguyen','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Son Nguyen','sonnhgc00687@fpt.edu.vn', 0)
insert into tblEmployee values('mainghia','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Mai Nghia','nghiamtgc00662@fpt.edu.vn', 1)
insert into tblEmployee values('sondao','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Son Dao', 'sondtgc00678@fpt.edu.vn', 2)
insert into tblEmployee values('ducphuc','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Duc Phuc','phucbdgc00669@fpt.edu.vn', 3)
insert into tblEmployee values('hoangha','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','hoangha','hanhgc00661@fpt.edu.vn', 4)
insert into tblEmployee values('maimai','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Mai Mai','misugi296@gmail.com', 1)
insert into tblEmployee values('huyhuy','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92','Huy Huy', 'sondtgc00678@fpt.edu.vn', 2)
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
insert into tblFaculty values('FPT2015', 'Top-Up Programme', 'ducphuc', 'hoangha','2015-01-01', '2015-12-31', 1)
insert into tblFaculty values('FPT2014', 'Aptech Programme', 'ducphuc', 'hoangha','2014-01-01', '2014-12-31', 1)
go
create table tblCourse
(
id int primary key IDENTITY,
course_code nvarchar(8),
course_faculty nvarchar(8)references tblFaculty(faculty_code),
course_title nvarchar(50),
course_leader nvarchar(50) references tblEmployee(username) NULL,
course_mod nvarchar(50) references tblEmployee(username) NULL,
[start_date] date,
[end_date] date,
description nvarchar(100),
[status] int,
)
select * from tblCourse
insert into tblCourse values('COMP1640', 'FPT2016', 'Enterprise Web Software Development', 'mainghia', 'sondao','2016-01-16', '2016-05-04', 'Course of Web development', 1)
insert into tblCourse values('COMP1649', 'FPT2016', 'Interaction Design', NULL, NULL, '2016-01-15', '2016-05-06', 'Course of Interaction Design', 1)
insert into tblCourse values('COMP1650', 'FPT2016', 'Mobile App Dev', 'mainghia', 'sondao', '2016-01-15', '2016-05-06', 'Course of Development of Mobile App', 1)
insert into tblCourse values('COMP1610', 'FPT2015', 'Java App Dev', 'maimai', 'huyhuy', '2015-01-15', '2015-05-06', 'Course of Development of Java App', 1)
insert into tblCourse values('COMP1600', 'FPT2015', 'C sharp App Dev', 'mainghia', 'sondao', '2015-01-15', '2015-05-06', 'Course of Development of C sharp App', 1)
insert into tblCourse values('COMP1590', 'FPT2015', 'C++ App Dev', 'maimai', 'huyhuy', '2015-01-15', '2015-05-06', 'Course of Development of C++ App', 1)
insert into tblCourse values('COMP1550', 'FPT2014', 'Web Interface', 'mainghia', 'sondao', '2014-01-15', '2014-05-06', 'Course of Development of Web UI', 1)
insert into tblCourse values('COMP1557', 'FPT2014', 'Basic Java', 'maimai', 'sondao', '2014-01-15', '2014-05-06', 'Course of Basic Java App', 1)
insert into tblCourse values('COMP1520', 'FPT2014', 'Basic C++', 'mainghia', 'huyhuy', '2014-01-15', '2014-05-06', 'Course of Basic C++', 1)

go

create table tblCMR
(
cmr_code int primary key references tblCourse(id),
student_count int,
comment nvarchar(1000),
createDate date,
[status] int,
cmtstatus int
)

go
Insert into tblCMR values(7,25,'Most students passed the course with high grade','2014-05-07',0,0)
Insert into tblCMR values(8,30,'Most students did not pass the course with high grade','2014-05-10',0,0)
Insert into tblCMR values(9,30,'Most students did not passed the course with high grade','2014-05-08',0,0)

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
insert into tblStaticalData values (7,1,7,7.5,7)
insert into tblStaticalData values (7,5,7,7.5,7)
insert into tblStaticalData values (7,6,8,8.5,8)
insert into tblStaticalData values (8,1,4,5,5)
insert into tblStaticalData values (8,5,4,5,5)
insert into tblStaticalData values (8,6,4,5,5)
insert into tblStaticalData values (9,1,5,5,5)
insert into tblStaticalData values (9,5,5,5,5)
insert into tblStaticalData values (9,6,5,5,5)
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

Go
Insert into tblGradeData values (7,1,0,0,0,0,0,0,90,10,0,0)
Insert into tblGradeData values (7,5,0,0,0,0,0,0,80,20,0,0)
Insert into tblGradeData values (7,6,0,0,0,0,0,0,0,30,70,0)
Insert into tblGradeData values (8,1,0,0,0,20,80,0,0,0,0,0)
Insert into tblGradeData values (8,5,0,0,0,20,80,0,0,0,0,0)
Insert into tblGradeData values (8,6,0,0,0,20,80,0,0,0,0,0)
Insert into tblGradeData values (9,1,0,0,0,0,20,80,0,0,0,0)
Insert into tblGradeData values (9,5,0,0,0,0,20,80,0,0,0,0)
Insert into tblGradeData values (9,6,0,0,0,0,20,80,0,0,0,0)

Go

create table tblComment
(
cmr_code int primary key references tblCMR(cmr_code),
comment nvarchar(1000),
)

Go

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

Go

exec getCourseDetail 1

Go

create procedure getCMRDetail
@cmr_code int
as
begin
select cmr_code, course_title, fullname, student_count, comment,tblCMR.createDate, tblCMR.[status], tblCMR.[cmtstatus],tblStaticalData.id_mark as staticalData_id_mark, mean, median, standard_deviation, tblGradeData.id_mark, mark0,
mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8, mark9 from tblCMR inner join tblStaticalData on 
tblCMR.cmr_code = tblStaticalData.cmr_id inner join tblGradeData on tblCMR.cmr_code = tblGradeData.cmr_id
inner join tblCourse on tblCMR.cmr_code = tblCourse.id inner join tblEmployee on tblCourse.course_leader = tblEmployee.username
where tblStaticalData.id_mark = tblGradeData.id_mark and cmr_code = @cmr_code
end
Go

exec getCMRDetail 7

Go

select * from tblCMR
select * from tblCourse where course_title like '%%'
select * from tblStaticalData
select * from tblGradeData
select * from tblEmployee

Go

create procedure getCMRCompletedByFacultyByYear
@year date , @year2 date , @facultyCode nvarchar(8)
as
begin
SELECT COUNT(*) AS countNum FROM 
(select  cmr_code, student_count, comment, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty, c.start_date, c.end_date from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id  where cmr.cmtstatus = 1 and c.course_faculty = @facultyCode and c.end_date >= @year and c.end_date < @year2
) AS CompletedCMR
end
Go
exec getCMRCompletedByFacultyByYear '2016','2017', 'FPT2016'

Go

create procedure getAllCMRByFacultyByYear
@year date , @year2 date , @facultyCode nvarchar(8)
as
begin
SELECT COUNT(*) AS countNum FROM 
(select  cmr_code, student_count, comment, cmr.[status],cmr.[cmtstatus],c.course_code,c.course_title,c.course_faculty, c.start_date, c.end_date from tblCMR cmr inner join tblCourse c on cmr.cmr_code = c.id and c.course_faculty = @facultyCode and c.end_date >= @year and c.end_date < @year2
) AS CompletedCMR
end

Go

exec getAllCMRByFacultyByYear '2016','2017', 'FPT2016'

Go

create procedure getAllCourseWithoutCLorCM
as
begin
SELECT COUNT(*) AS countNum FROM 
(select  * from tblCourse where course_leader = '' OR course_mod = ''
) AS CourseWithoutCLCM
end

Go

exec getAllCourseWithoutCLorCM

Go

create procedure getAllCourseWithoutCMR
as
begin
SELECT COUNT(*) AS countNum FROM 
(Select * from tblCourse where id NOT IN (Select c.id from tblCourse c inner join tblCMR cmr on c.id = cmr.cmr_code)
) AS CourseWithoutCMR
end
Go

exec getAllCourseWithoutCMR

Go

create procedure getAllCourseWithNotCompletedCMR
as
begin
SELECT COUNT(*) AS countNum FROM 
(Select * from tblCourse where id NOT IN (Select c.id from tblCourse c inner join tblCMR cmr on c.id = cmr.cmr_code where cmr.cmtstatus = 1)
) AS CourseWithoutCMR
end

Go

exec getAllCourseWithNotCompletedCMR

Go

create procedure getCourseDetailWithoutCLCM 
@courseID int
as
begin
select course_code, faculty_title, course_title,tblCourse.[start_date], tblCourse.[end_date], [description], tblCourse.[status]
from tblCourse inner join tblFaculty on tblCourse.course_faculty = tblFaculty.faculty_code
where tblCourse.id = @courseID
end
  
Go
    
exec getCourseDetailWithoutCLCM 7

Go

create procedure getNumberOfCourseByFaculty
as
begin
SELECT faculty_title, COUNT(*) AS countNum FROM  
(select course_code, faculty_title from tblCourse inner join tblFaculty on tblCourse.course_faculty = tblFaculty.faculty_code
) AS CourseWithoutCMR Group by faculty_title
end

exec getNumberOfCourseByFaculty