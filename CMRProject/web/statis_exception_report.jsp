
<%-- 
    Document   : home
    Created on : Mar 26, 2016, 11:30:11 PM
    Author     : Son
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content">
    <div class="row" >    
        <div id="search" class="col-md-6">
            <div class="form-group">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <i class="pe-7s-filter" ></i>
                </a>
                <ul class="dropdown-menu">
                    <c:forEach items="${facultyList}" var="f">
                        <li><a href="">${f.facultyTitle}</a></li>
                    </c:forEach>
            </ul>
                <input class="form-control" placeholder="Search" type="submit" required="" name="searchCourse" value="Faculty" maxlength="100">
            </div>
        </div>      
        <div id="endDate" class="col-md-3">
            <div class="form-group">
                <input class="form-control" placeholder="End Date" type="date" required="" name="startDate" maxlength="50"/>            </div>
        </div>
        <div id="startDate" class="col-md-3">
            <div class="form-group">
                <input class="form-control" placeholder="Start Date" type="date" required="" name="startDate" maxlength="50"/>            </div>
        </div>      
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="header">
                    <h4 class="title">NUMBER OF COMPLETED CMR</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 id="courseNumber" >${noOfCompletedCMR}</h1>  
                    <hr>
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> 2016 of FPT2016
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="header">
                    <h4 class="title">NUMBER OF ALL CMR</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 id="courseNumber" >${noOfAllCMR}</h1>  
                    <hr>
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> 2016 of FPT2016
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="card">
                <div class="header">
                    <h4 class="title">CMR PERCENTAGE COMPLETED</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <div id="cmrBar">
                        <div id="completedPercent" style="width: ${percentageCompleted}%;"></div>
                        <h6 id="percent">${percentageCompleted}%</h6>
                    </div>
                    <hr>
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> 2016 of FPT2016
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="header">
                    <h4 class="title">NUMBER OF COURSE WITHOUT CM OR CL</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 id="courseNumber" >${noOfCourseWithoutCLCM}</h1>  
                    <hr>
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> 2016 of FPT2016
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card">
                <div class="header">
                    <h4 class="title">NUMBER OF COURSE WITHOUT CMR</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 id="courseNumber" >${noOfCourseWithoutCMR}</h1>  
                    <hr>
                    <div class="stats">
                        <i class="fa fa-clock-o"></i> 2016 of FPT2016
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12">
        <div class="card">
            <div class="header">
                <h4 class="title">NUMBER OF COURSE WITHOUT COMPLETED CMR</h4>
                <p class="category"></p>
            </div>
            <div class="content">
                <h1 id="courseNumber" >${noOfCourseWithoutCompletedCMR}</h1>  
                <hr>
                <div class="stats">
                    <i class="fa fa-clock-o"></i> 2016 of FPT2016
                </div>
            </div>
        </div>
    </div>
</div>

</div>



<jsp:include page="masterpages/footer.jsp"/>

