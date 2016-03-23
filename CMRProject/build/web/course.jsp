<%-- 
    Document   : home
    Created on : Feb 23, 2016, 11:30:11 PM
    Author     : Son
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/header.jsp" />    
<div class="row">
    <ul id="navigationTab" class="nav nav-tabs" role="tablist">
        <li><a href="#">
                Home <img src="img/ic_next.png" width="20px"/>
            </a></li>
        <li><a href="#">
                Course <img src="img/ic_next.png" width="20px"/>
            </a></li><!--
        <li><a href="#">
                Messages <img src="img/ic_next.png" width="20px"/>
            </a></li>-->
    </ul>
    <ul>
        <input class="form-search" type="search" placeholder="Search for Course"/>
        <div class="btn">
            <button type="submit" class="btn btn-default">Search</button>
        </div>
    </ul>

    <c:forEach items="${courseList}" var="c">
        <div id="courseInfo" class="col-xs-6 col-lg-4">
            <h3>${c.courseTitle}</h3>
            <p>Start Date: ${c.courseStarted}</p>
            <p>Finish Date: ${c.courseFinished}</p>
            <td></td>
            <p><a class="btn btn-default" href="AddCMR?&courseID=${c.id}" role="button">Add CMR for this course</a></p>
            <p><a class="btn btn-default" href="#" role="button">View details �</a></p>
        </div>
    </c:forEach>
</div>
<jsp:include page="masterpages/footer.jsp" />    