
<%-- 
    Document   : home
    Created on : Mar 26, 2016, 11:30:11 PM
    Author     : Son
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content">
    <div class="col-md-3">
        <div class="card">
            <div class="header">
                <h4 class="title">Course</h4>
                <p class="category"></p>
            </div>
            <div class="content">
                <h1 id="courseNumber" ></h1>  
                <hr>
                <div class="stats">
                    <i class="fa fa-clock-o"></i> Faculty
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="masterpages/footer.jsp"/>

