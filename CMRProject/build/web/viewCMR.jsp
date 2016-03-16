<%-- 
    Document   : viewCMR
    Created on : Mar 6, 2016, 12:02:40 PM
    Author     : Son
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/header.jsp" />    
<div class="row">
    <c:forEach items="${courseList}" var="c">
        <div id="courseInfo" class="col-xs-6 col-lg-4">
            <h3>${c.courseTitle}</h3>
            <p>Start Date: ${c.courseStarted}</p>
            <p>Finish Date: ${c.courseFinished}</p>
            <td></td>
            <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
    </c:forEach>
</div>
<jsp:include page="masterpages/footer.jsp" />    