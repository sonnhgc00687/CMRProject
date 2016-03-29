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
        <div class="card">
            <div class="header">
                <!--<h4 class="title">Striped Table with Hover</h4>-->
                <p class="category">List course of <a href="#">Honours Programme</a> Faculty</p>
            </div>
            <div class="content table-responsive table-full-width">
                <table id="tableCourse" class="table table-hover table-striped">
                    <thead>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Start Date</th>
                    <th>Finish Date</th>
                    <th>Detail</th>     
                    <th>Add CMR</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${courseList}" var="c">
                            <tr>
                                <td>${c.courseCode}</td>
                                <td>${c.courseTitle}</td>
                                <td>${c.courseStarted}</td>
                                <td>${c.courseFinished}</td>
                                <td><a class="btn btn-default" href="GetCourseDetail?&courseID=${c.id}" role="button">Detail</a></td>
                                <td><a class="btn btn-default" href="AddCMR?&courseID=${c.id}" role="button">Add CMR</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="addNewCourse">
            <div id="addCourseForm" class="col-md-9">
                <div class="card">
                    <div class="header">
                        <h4 class="title">New Course</h4>
                    </div>
                    <div class="content">
                        <form  action="AddCourse" method="post">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Code</label>
                                        <input class="form-control" placeholder="Course Code" type="text" required="" name="courseCode" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input class="form-control" placeholder="Course Title" type="text" required="" name="courseTitle" maxlength="50">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
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
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Start</label>
                                        <input class="form-control" placeholder="Start Date" type="text" required="" name="startDate" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>End</label>
                                        <input class="form-control" placeholder="End Date" type="text" required="" name="endDate" maxlength="50">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Description</label>
                                        <textarea rows="5" class="form-control" placeholder="Here is a course's description..."></textarea>
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                    </div>
                </div>
            </div>

            <div id="assignCourseForm" class="col-md-9">
                <div class="card">
                    <div class="header">
                        <h4 class="title">Assign To</h4>
                    </div>
                    <div class="content">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Leader</label>
                                    <select class="form-control" required="" name="courseLeader">
                                        <option value="" disabled selected>Course Leader</option>
                                        <c:forEach items="${leader}" var="leader">
                                            <option value="${leader.fullName}">${leader.fullName}</option>
                                        </c:forEach>                
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Moderator</label>
                                    <select class="form-control" required="" name="courseModerator">
                                        <option value="" disabled selected>Course Moderator</option>
                                        <c:forEach items="${moderator}" var="moderator">
                                            <option value="${moderator.fullName}">${moderator.fullName}</option>
                                        </c:forEach>                
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="row">

                        </div>

                        <input id="skipCourse" type="submit" name="skip" style="display: none"/>
                        <input id="assignCourse" type="submit" name="assign" style="display: none"/>

                        <div class="clearfix"></div>
                        </form>
                    </div>
                </div>
            </div> 
        </div>

        <div class="col-md-3" id="addCourseContainer">

            <div ng-click="showAddCourseForm()" id="btnShowAddCourse" class="card">
                <div class="header">
                    <h4 class="title">ADD COURSE</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 >+</h1>  
                </div>
            </div>

            <div ng-click="addCourse()" id="btnAddCourse" class="card">
                <div class="content">
                    <h4 class="title">ADD</h4>
                </div>
            </div>

            <div ng-click="cancelAddCourse()" id="btnCancelAddCourse" class="card">
                <div class="content">
                    <h4 class="title">CANCEL</h4>  
                </div>
            </div>

            <div ng-click="assignCourse()" id="btnAssignCourse" class="card">
                <div class="content">
                    <h4 class="title">ASSIGN</h4>  
                </div>
            </div>

            <div ng-click="skipAddCourse()" id="btnSkipAssign" class="card">
                <div class="content">
                    <h4 class="title">SKIP</h4>  
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="masterpages/footer.jsp"/>
