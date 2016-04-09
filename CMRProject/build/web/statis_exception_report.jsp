
<%-- 
    Document   : home
    Created on : Mar 26, 2016, 11:30:11 PM
    Author     : Son
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="header">
                    <h4 class="title">COMPLETED CMR</h4>
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
                    <h4 class="title">CMR</h4>
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
                    <h4 class="title">COMPLETED CMR</h4>
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
                    <h4 class="title">CMR</h4>
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
            <div class="card" style="margin-bottom: 0px;">
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

</div>



<jsp:include page="masterpages/footer.jsp"/>

