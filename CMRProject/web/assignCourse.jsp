<%-- 
    Document   : assignCourse
    Created on : Mar 13, 2016, 1:47:51 PM
    Author     : Son
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/header.jsp" />    
<div class="row">
    <ul id="navigationTab" class="nav nav-tabs" role="tablist">
        <li><a href="#">
                Home <img src="img/ic_next.png" width="20px"/>
            </a></li>
        <!--                            <li><a href="#">
                                            Profile <img src="img/ic_next.png" width="20px"/>
                                        </a></li>
                                    <li><a href="#">
                                            Messages <img src="img/ic_next.png" width="20px"/>
                                        </a></li>-->
    </ul>

    <div id="assignContainer">
        <div id="courseAssign" class="col-xs-6 col-lg-6">
            <h3>${course.courseTitle}</h3>
            <p>Code: ${course.courseCode}</p>
            <p>Faculty: ${course.courseFaculty}
            <p>Start Date: ${course.courseStarted}</p>
            <p>Finish Date: ${course.courseFinished}</p>
            <td></td>
        </div>

        <div id="assignForm" class="col-xs-6 col-lg-6">
            <h3> </h3>
            <select class="form-control" required="" name="courserLeader">
                <option value="" disabled selected>Course leader</option>
                <c:forEach items="${leader}" var="user">
                    <option value="${user.userName}">${user.fullName}</option>
                </c:forEach>                
            </select>
            <select class="form-control" required="" name="courseMod">
                <option value="" disabled selected>Course mod</option>
                <c:forEach items="${moderator}" var="user">
                    <option value="${user.userName}">${user.fullName}</option>
                </c:forEach>
            </select>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Assign</button>
        </div>
    </div>

    <hr class="featurette-divider">
</div>
<jsp:include page="masterpages/footer.jsp" />    
