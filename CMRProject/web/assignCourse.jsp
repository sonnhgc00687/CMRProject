<%-- 
    Document   : assignCourse
    Created on : Mar 13, 2016, 1:47:51 PM
    Author     : Son
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assign Course</title>
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
                        <li class="active"><a href="Login">Home</a></li>
                        <li><a href="GetAllCourse">Course</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" id="btnAddDropdown" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="img/ic_plus.png" width="25px" height="25px"/>
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li class="active">
                                    <form id="btnNewCourse" action="GetAllUserAndFaculty" method="post">
                                        <button id="" type="submit">New Course</button>
                                    </form>
                                </li>
                                <li><form id="btnNewCourse" action="AddCMR" method="get">
                                        <button id="" type="submit">New CMR</button>
                                    </form></li>
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
                        <h1>Welcome to FPT University!</h1>
                        <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
                    </div>
                    <div class="row">
                        <ul id="navigationTab" class="nav nav-tabs" role="tablist">
                            <li><a href="#">
                                    Home <img src="img/ic_next.png" width="20px"/>
                                </a></li>
                            <!--                            <li><a href="#">
                                                                Profile <img src="img/ic_next.png" width="20px"/>
                                                            </a></li>
                                                        <li><a href="#">
                                                                Messages <img src="img/ic_next.png" width="20px"/>
                                                            </a></li>-->
                        </ul>

                        <div id="assignContainer">
                            <div id="courseAssign" class="col-xs-6 col-lg-6">
                                <h3>${course.courseTitle}</h3>
                                <p>Code: ${course.courseCode}</p>
                                <p>Faculty: ${course.courseFaculty}
                                <p>Start Date: ${course.courseStarted}</p>
                                <p>Finish Date: ${course.courseFinished}</p>
                                <td></td>
                            </div>

                            <div id="assignForm" class="col-xs-6 col-lg-6">
                                <h3> </h3>
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
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Assign</button>
                            </div>
                        </div>

                        <hr class="featurette-divider">
                    </div>
                </div>
            </div>
        </div>
        <hr>

        <footer>
            <p>© 2015 Company, Inc.</p>
        </footer>

    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/docs.min.js"></script>

</body>
</html>
