<%-- 
    Document   : addNewCourse
    Created on : Feb 28, 2016, 8:49:42 PM
    Author     : Phuc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/header.jsp"/>
<div class="row">
    <ul id="navigationTab" class="nav nav-tabs" role="tablist">
        <li><a href="#">
                Home <img src="img/ic_next.png" width="20px"/>
            </a>
        </li>
        <li><a href="#">
                New Course <img src="img/ic_next.png" width="20px"/>
            </a>
        </li>
    </ul>
    <form id="addCourseGroup" action="AddCourse" method="post">
        <h3>Add New Course</h3>
        <input class="form-control" type="text" required="" placeholder="Course code" name="courseCode" maxlength="50"/>
        <input class="form-control" type="text" required="" placeholder="Course title" name="courseTitle" maxlength="50"/>
        <select class="form-control" required="" name="courseFaculty">
            <option value="" disabled selected>Course Faculty</option>
            <c:forEach items="${facultyList}" var="faculty">
                <option value="${faculty.facultyCode}">${faculty.facultyTitle}</option>
            </c:forEach>                
        </select>
        <!--                                <select class="form-control" required="" name="courserLeader">
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
    </select>-->
        <input class="form-control" type="date" required="" placeholder="Start date" name="startDate" maxlength="50"/>
        <input class="form-control" type="date" required="" placeholder="End date" name="endDate" maxlength="50"/>
        <textarea class = "form-control" rows = "3"></textarea>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add course</button>
    </form>      
</div>
<jsp:include page="masterpages/footer.jsp" />    