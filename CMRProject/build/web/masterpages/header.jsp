<%-- 
    Document   : header
    Created on : Mar 13, 2016, 9:32:20 PM
    Author     : Son
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
                        <li id="tabHome"><a href="Login">Home</a></li>
                        <li id="tabCourse"><a href="GetAllCourse">Course</a></li>
                        <li id="tabCMR"><a href="GetAllCMR">CMR</a></li>
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