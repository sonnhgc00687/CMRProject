
<%-- 
    Document   : home
    Created on : Mar 26, 2016, 11:30:11 PM
    Author     : Son
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content" id="reportFilter">
    <div class="row" >

        <form action="StatisticalReport" method="post" >
            <div id="startDate" class="col-md-3">
                <div class="form-group">
                    <label>From</label>
                    <input class="form-control" placeholder="Start Date" type="date" required="" name="startDate" maxlength="50"/>            </div>
            </div> 
            <div id="endDate" class="col-md-3">
                <div class="form-group">
                    <label>To</label>
                    <input class="form-control" placeholder="End Date" type="date" required="" name="endDate" maxlength="50"/>            </div>
            </div>
            <div id="filterFaculty" class="col-md-4">
                <div class="form-group">
                    <label>Faculty</label>
                    <select class="form-control" required="" name="courseFaculty">
                        <option value="" disabled selected>Course Faculty</option>
                        <c:forEach items="${facultyList}" var="faculty">
                            <option value="${faculty.facultyCode}">${faculty.facultyTitle}</option>
                        </c:forEach>                
                    </select>
                </div>
            </div>  
            <div id="searchReport" class="col-md-2">
                <div class="form-group">
                    <label style="color: transparent">Search</label>
                    <input class="form-control" type="submit" value="Search"/>
                </div>
            </div>  
        </form>
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
                        <i class="fa fa-clock-o"></i> ${facultyTitle}
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
                        <i class="fa fa-clock-o"></i>  ${facultyTitle}
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
                        <i class="fa fa-clock-o"></i>  ${facultyTitle}
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
                        <i class="fa fa-clock-o"></i> All Faculty
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
                        <i class="fa fa-clock-o"></i> All Faculty
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
                    <i class="fa fa-clock-o"></i>  All Faculty
                </div>
            </div>
        </div>
    </div>
</div>



<jsp:include page="masterpages/footer.jsp"/>

