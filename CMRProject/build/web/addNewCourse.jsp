<%-- 
    Document   : addNewCourse
    Created on : Feb 28, 2016, 8:49:42 PM
    Author     : Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/css.css"/>
    </head>
    <body>
        <%
            if (request.getSession() == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>

        <nav class="navbar navbar-fixed-top navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">CMR</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" id="btnAddDropdown" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="img/ic_plus.png" width="25px" height="25px"/>
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><li><li class="active">
                                    <form id="btnNewCourse" action="GetAllUserAndFaculty" method="post">
                                        <button id="" type="submit">New Course</button>
                                    </form>
                                </li></li></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                    </li>     
                    <li class="active"><a href="#">${username}</a></li>
                    </ul>
                </div>

            </div>
        </nav>

        <div class="container">

            <div class="row row-offcanvas row-offcanvas-right">

                <div class=".col-md-6 .col-md-offset-4">
                    <p class="pull-right visible-xs">                       
                        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
                    </p>
                    <div class="jumbotron">
                        <h1>Hello, world!</h1>
                        <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
                    </div>
                    <div class="row">
                        <div class="container">
                            <form id="addCourseGroup" action="AddCourse" method="post">
                                <h3>Add New Course</h3>
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
                    </div>
                </div>

            </div>
            <hr>

            <footer>
                <p>© 2015 Company, Inc.</p>
            </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/docs.min.js"></script>

    </body>
</html>
