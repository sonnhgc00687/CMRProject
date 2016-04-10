<%-- 
    Document   : new_home
    Created on : Mar 26, 2016, 10:29:41 AM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <link href="css/animate.min.css" rel="stylesheet"/>
        <link href="css/light-bootstrap-dashboard.css" rel="stylesheet"/>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />
        <link href="css/css.css" rel="stylesheet"/>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    </head>
    <body ng-app="myApp" ng-controller="myCtrl">
        <%
            if (request.getSession() == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        %>
        <div class="wrapper">
            <div class="sidebar" data-color="gray" data-image="img/background.jpg">

                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="Login" class="simple-text">
                            CMR
                        </a>
                    </div>

                    <ul class="nav">                        
                        <li id="faculty">
                            <a href="GetAllUserAndFaculty">
                                <i class="pe-7s-study"></i>
                                <p>Faculty</p>
                            </a>
                        </li>
                        <li id="course">
                            <a href="GetAllCourse">
                                <i class="pe-7s-notebook"></i>
                                <p>Course</p>
                            </a>
                        </li>
                        <li id="cmr">
                            <a href="GetAllCMR">
                                <i class="pe-7s-note2"></i>
                                <p>CMR</p>
                            </a>
                        </li>
                        <li id="staff" ng-class="class" ng-if="${userRole} == 0">
                            <a href="GetAllUser">
                                <i class="pe-7s-users"></i>
                                <p>Staff</p>
                            </a>
                        </li>                        
                        <li id="report">
                            <a href="StatisticalReport">
                                <i class="pe-7s-news-paper"></i>
                                <p>Report</p>
                            </a>
                        </li>
                    </ul>  
                </div>
            </div>