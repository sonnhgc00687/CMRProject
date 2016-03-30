<%-- 
    Document   : new_home
    Created on : Mar 26, 2016, 10:29:41 AM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content" id="courseContainer">
    <div class="container-fluid">

        <div id="addNewCourse">
            <form  action="AssignCourse" method="get">
                <div id="courseDetail" class="col-md-9">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">Course Detail</h4>
                        </div>
                        <div class="content">

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Code</label>
                                        <input class="form-control" value="${courseCode}" placeholder="Course Code" type="text" required=""  readonly="" readonly=""  name="courseCode" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input class="form-control" value="${courseTitle}" placeholder="Course Title" type="text" required=""  readonly="" name="courseTitle" maxlength="50">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Faculty</label>
<<<<<<< HEAD
                                        <select disabled="" class="form-control" required="" name="courseFaculty">
                                            <option value="" disabled selected>${courseFaculty}</option>
=======
                                        <select class="form-control" required="" name="courseFaculty">
                                            <option value="${courseFaculty}" disabled selected>${courseFaculty}</option>
>>>>>>> 1199e4fef3f10d879d9a1eac71c4b24a63a41f86
                                            <c:forEach items="${facultyList}" var="faculty">
                                                <option value="${faculty.facultyCode}">${faculty.facultyTitle}</option>
                                            </c:forEach>                
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Start</label>
                                        <input class="form-control" value="${courseStarted}" placeholder="Start Date" type="text" required=""  readonly="" name="startDate" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>End</label>
                                        <input class="form-control" value="${courseFinished}" placeholder="End Date" type="text" required=""  readonly="" name="endDate" maxlength="50">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea rows="5" class="form-control" readonly="" placeholder="Here is a course's description...">${description}</textarea>
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

                <div id="assignTo" class="col-md-3">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">Assign To</h4>
                        </div>
                        <div class="content">
                            <div class="row">
                                <div class="form-group">
                                    <label>Leader</label>
                                    <select class="form-control" required="" name="courseLeader">
                                        <option value="${courseLeader}" disabled selected>${courseLeader}</option>
                                        <c:forEach items="${leader}" var="leader">
                                            <option value="${leader.userName}">${leader.fullName}</option>
                                        </c:forEach>                
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">
                                    <label>Moderator</label>
                                    <select class="form-control" required="" name="courseModerator">
                                        <option value="${courseModerator}" disabled selected>${courseModerator}</option>
                                        <c:forEach items="${moderator}" var="moderator">
                                            <option value="${moderator.userName}">${moderator.fullName}</option>
                                        </c:forEach>                
                                    </select>
                                </div>
                            </div>


                            <input id="assignCourse" type="submit" name="assign" style="display: none"/>

                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div> 


                <div class="col-md-3" id="assignCourseButton">
                    <div ng-click="assignCourse()" id="btnAssign" class="card" style="display: block">
                        <div class="header">
                            <h4 class="title">ASSIGN</h4>
                            <p class="category"></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3" id="assignCourseButton">
                    <div ng-click="" id="btnAssign" class="card" style="display: block">
                        <div class="header">
                            <h4 class="title">CANCEL</h4>
                            <p class="category"></p>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="masterpages/footer.jsp"/>