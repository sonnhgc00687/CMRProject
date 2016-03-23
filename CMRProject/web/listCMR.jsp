<%-- 
    Document   : listCMR
    Created on : Mar 13, 2016, 4:18:26 PM
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
    <c:forEach items="${listCMR}" var="cmr">
        <div id="courseInfo" class="col-xs-6 col-lg-4">
            <h3>${cmr.cmr_code}</h3>
            <p>Course: ${cmr.course_code} - ${cmr.course_title}</p>
            <p>Faculty: ${cmr.course_faculty}</p>
            <p>
            <td></td>
            <!--<p><a class="btn btn-default" href="AddCMR?&courseID=${c.id}" role="button">Add CMR for this course</a></p>-->
            <p><a class="btn btn-default" href="GetCMRDetail?&courseID=${cmr.cmr_code}" role="button">View details »</a></p>
        </div>
    </c:forEach>
</div>
<jsp:include page="masterpages/footer.jsp" />    
