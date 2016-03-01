<%-- 
    Document   : addNewCourse
    Created on : Feb 28, 2016, 8:49:42 PM
    Author     : Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new course</title>
    </head>
    <body>
         <div class="container">
            <form action="AddCourse" method="post">
                <h2>Add New Course</h2>
                <input class="form-control" type="text" required="" placeholder="Course code" name="courseCode" maxlength="50"/>
                <input class="form-control" type="text" required="" placeholder="Course title" name="courseTitle" maxlength="50"/>
                <select class="form-control" required="" name="courseFaculty">
                    <option value="" disabled selected>Course Faculty</option>
                    <c:forEach items="${facultyList}" var="faculty">
                        <option value="${faculty.facultyCode}">${faculty.facultyTitle}</option>
                    </c:forEach>                
                </select>
                <select class="form-control" required="" name="courserLeader">
                    <option value="" disabled selected>Course leader</option>
                    <c:forEach items="${leader}" var="user">
                        <option value="${user.userName}">${user.fullName}</option>
                    </c:forEach>                
                </select>
                <select class="form-control" required="" name="courseMod">
                    <option value="" disabled selected>Course mod</option>
                    <c:forEach items="${moderator}" var="user">
                        <option value="${user.userName}">${user.fullName}</option>
                    </c:forEach>
                </select>
                <input class="form-control" type="date" required="" placeholder="Start date" name="startDate" maxlength="50"/>
                <input class="form-control" type="date" required="" placeholder="End date" name="endDate" maxlength="50"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add course</button>
            </form>
        </div>
    </body>
</html>
