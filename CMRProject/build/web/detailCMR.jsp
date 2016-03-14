<%-- 
    Document   : detailCMR
    Created on : Mar 14, 2016, 5:38:24 PM
    Author     : Hoang Ha Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMR Detail</title>
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
                            <form id="addCMRGroup" action="AddCMR" method="post">


                                <div id="tableCMRInfo" class="panel panel-default">

                                    <div class="panel-heading"><h3><center>DETAIL</center></h3></div>

                                    <!-- Table -->
                                    <div class="table-responsive">          
                                        <table class="table table-bordered">
                                            <tbody>
                                                <tr>
                                                    <td>Academic Session</td> <td><input class="form-control" type="text"  value="${courseId}" readonly="" name="id" maxlength="50"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Course Title</td> <td><input class="form-control" type="text"  value="${courseTitle}" disabled="" name="" min="0" max="100"/></td> 
                                                </tr>
                                                <tr>
                                                    <td>Course Leader</td> <td><input class="form-control" type="text"  value="${courseLeader}" disabled="" name="" min="0" max="100"/></td> 
                                                </tr>
                                                <tr>
                                                    <td>Student count</td> <td><input class="form-control" type="number"  placeholder="" name="studentCount" min="0" max="100"/></td> 
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div id="tableStatisticalData" class="panel panel-default">

                                    <!-- Default panel contents -->
                                    <div class="panel-heading">Statistical Data</div>

                                    <!-- Table -->
                                    <div class="table-responsive">          
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>#</th> <th>CW1</th> <th>CW2</th> <th>CW3</th> <th>CW4</th> <th>EXAM</th> <th>OVERALL</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Mean</td> 
                                                    <td><input class="form-control" type="number" value="${mean1}"  placeholder="" name="mean1" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${mean2}"  placeholder="" name="mean2" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number" value="${mean3}"  placeholder="" name="mean3" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${mean4}"  placeholder="" name="mean4" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number" value="${mean5}"  placeholder="" name="mean5" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${mean6}"  placeholder="" name="mean6" min="0" max="100"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Median</td> 
                                                    <td><input class="form-control" type="number" value="${median1}"  placeholder="" name="median1" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${median2}"  placeholder="" name="median2" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number" value="${median3}"  placeholder="" name="median3" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${median4}"  placeholder="" name="median4" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number" value="${median5}" placeholder="" name="median5" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${median6}"  placeholder="" name="median6" min="0" max="100"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Standard Deviation</td> 
                                                    <td><input class="form-control" type="number" value="${sd1}"  placeholder="" name="sd1" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${sd2}"  placeholder="" name="sd2" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number" value="${sd3}"  placeholder="" name="sd3" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${sd4}"  placeholder="" name="sd4" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number" value="${sd5}"  placeholder="" name="sd5" min="0" max="100"/></td> <td><input class="form-control" type="number" value="${sd6}" placeholder="" name="sd6" min="0" max="100"/></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div id="tableGradeData" class="panel panel-default">

                                    <div class="panel-heading">Grade Distribution Data</div>

                                    <!-- Table -->
                                    <div class="table-responsive">          
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>#</th> <th>0 – 9</th> <th>10 - 19</th> <th>20 - 29</th> <th>30 - 39</th> <th>40 - 49</th> <th>50 - 59</th> <th>60 - 69</th> <th>70 - 79</th> <th>80 - 89</th> <th>90+</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>CW1</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_1_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_1_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_1_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_1_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_1_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_1_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_1_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_1_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_1_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_1_9" min="0" max="100"/></td>
                                                </tr>
                                                <tr>
                                                    <td>CW2</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_2_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_2_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_2_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_2_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_2_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_2_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_2_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_2_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_2_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_2_9" min="0" max="100"/></td>                         
                                                </tr>
                                                <tr>
                                                    <td>CW3</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_3_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_3_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_3_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_3_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_3_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_3_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_3_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_3_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_3_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_3_9" min="0" max="100"/></td>                            
                                                </tr>
                                                <tr>
                                                    <td>CW4</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_4_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_4_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_4_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_4_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_4_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_4_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_4_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_4_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_4_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_4_9" min="0" max="100"/></td>
                                                </tr>
                                                <tr>
                                                    <td>EXAM</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_5_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_5_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_5_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_5_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_5_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_5_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_5_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_5_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_5_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_5_9" min="0" max="100"/></td>
                                                </tr>
                                                <tr>
                                                    <td>OVERALL</td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_6_0" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_6_1" min="0" max="100"/></td>
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_6_2" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_6_3" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_6_4" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_6_5" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_6_6" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_6_7" min="0" max="100"/></td> 
                                                    <td><input class="form-control" type="number"  placeholder="" name="mark_6_8" min="0" max="100"/></td> <td><input class="form-control" type="number"  placeholder="" name="mark_6_9" min="0" max="100"/></td>                          
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </form>
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
    </div>
</body>
</html>
