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
            </a>
        </li>
        <!--                            <li><a href="#">
                                            Profile <img src="img/ic_next.png" width="20px"/>
                                        </a></li>
                                    <li><a href="#">
                                            Messages <img src="img/ic_next.png" width="20px"/>
                                        </a></li>-->
    </ul>

    <form action="AssignCourse" method="post">
        <div id="assignContainer">
            <div id="courseAssign" class="col-xs-6 col-lg-6">                                    
                <h3><input style="border: 0" name="courseTitle" type="text" readonly="" value="${course.courseTitle}" /></h3>
                <p>Code: <input style="border: 0" name="courseCode" type="text" readonly="" value="${course.courseCode}" /></p>
                <p>Faculty: <input style="border: 0" name="courseFaculty" type="text" readonly="" value="${course.courseFaculty}" /></p>
                <p>Start Date: <input style="border: 0" name="startDate" type="text" readonly="" value="${startDate}" /></p>
                <p>Finish Date: <input style="border: 0" name="endDate" type="text" readonly="" value="${endDate}" /></p>
                <p>Description: <input style="border: 0" name="description" type="text" readonly="" value="${course.description}" /></p>                                    
            </div>

            <div id="assignForm" class="col-xs-6 col-lg-6">

                <h3> </h3>
                <select class="form-control"  name="courserLeader">
                    <option value="" disabled selected>Course leader</option>
                    <c:forEach items="${leader}" var="user">
                        <option value="${user.userName}">${user.fullName}</option>
                    </c:forEach>                
                </select>
                <select class="form-control"  name="courseMod">
                    <option value="" disabled selected>Course mod</option>
                    <c:forEach items="${moderator}" var="user">
                        <option value="${user.userName}">${user.fullName}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="assign">Assign</button>
                <br/>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="cancel">Cancel</button>
            </div>
        </div>
    </form>

    <hr class="featurette-divider">
</div>

<jsp:include page="masterpages/footer.jsp" />    
