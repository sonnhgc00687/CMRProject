<%-- 
    Document   : home
    Created on : Feb 23, 2016, 11:30:11 PM
    Author     : Son
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <%
            if (request.getSession() == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>

        <h1>Welcome, ${username}</h1>
        <br>
        List Course: 
        <br/><br/>

        <table class="table table-striped" BORDER=5 BORDERCOLOR=BLACK>
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Course Leader</td>
                <td>Course Moderator</td>
                <td>Start Date</td>
                <td>End Date</td>
            </tr>
            <c:forEach items="${courseList}" var="c">
                <tr>
                    <td>${c.courseCode}</td>
                    <td>${c.courseTitle}</td>
                    <td>${c.courseLeader}</td>
                    <td>${c.courseModerator}</td>
                    <td>${c.courseStarted}</td>
                    <td>${c.courseFinished}</td>
                </tr>
            </c:forEach>
        </table> 
        <br/>
        <form action="GetAllUserAndFaculty" method="post">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add new course</button>
        </form>
    </body>
</html>
