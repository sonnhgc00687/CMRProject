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
                <p class="category">List Faculty of FPT University</p>
            </div>
            <div class="content table-responsive table-full-width">
                <table id="tableCourse" class="table table-hover table-striped">
                    <thead>
                    <th>Code</th>
                    <th>Title</th>
                    <th>PVC</th>
                    <th>DLT</th>
                    <th>Start</th>
                    <th>End</th>
                    <th>Course</th>
                    <th>CMR</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${facultyList}" var="f">
                            <tr>
                                <td>${f.facultyCode}</td>
                                <td>${f.facultyTitle}</td>
                                <td>${f.facultyPVC}</td>
                                <td>${f.facultyDLT}</td>
                                <td>${f.facultyStartDate}</td>
                                <td>${f.facultyEndDate}</td>
                                <td><a class="btn btn-default" href="GetAllCourse?&filterFaculty=${f.facultyCode}" role="button">View Courses</a></td>
                                <td><a class="btn btn-default" href="GetAllCMR?&filterFaculty=${f.facultyCode}" role="button">View CMR</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div ng-if="${userRole} == 0" id="addNewAccout">
            <form  action="GetAllUser" method="post">
                <div id="addAccountContainer" class="col-md-9">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">New Faculty</h4>
                        </div>
                        <div class="content">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Code</label>
                                        <input class="form-control" placeholder="Faculty Code" type="text" required="" name="facultyCode" value="${facultyCode}" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input class="form-control" placeholder="Faculty Title" type="text" required="" name="facultyTitle" value="${facultyTitle}" maxlength="50">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>Start</label>
                                        <input class="form-control" placeholder="Start Date" type="text" required="" name="startDate" value="${start}" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>PVC</label>
                                        <select class="form-control" required="" name="pvc">
                                            <option value="" disabled selected>Pro-Vice Chancellor</option>
                                            <c:forEach items="${pvcList}" var="pvc">
                                                <option value="${pvc.userName}">${pvc.fullName}</option>
                                            </c:forEach>                
                                        </select>
                                    </div>
                                </div>    
                            </div>

                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>End</label>
                                        <input class="form-control" placeholder="End Date" type="text" required="" name="endDate" value="${end}" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label>DLT</label>
                                        <select class="form-control" required="" name="dlt">
                                            <option value="" disabled selected>Director of Learning and Quality</option>
                                            <c:forEach items="${dltList}" var="dlt">
                                                <option value="${dlt.userName}">${dlt.fullName}</option>
                                            </c:forEach>                
                                        </select>
                                    </div>
                                </div>  
                            </div>


                            <input id="addFaculty" type="submit" value="Add Faculty" style="display: none" />
                            <a style="color: red">${message}</a>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div ng-if="${userRole} == 0" class="col-md-3" id="addCourseContainer">

            <div ng-click="addAccount()" id="btnShowAddAccount" class="card">
                <div class="header">
                    <h4 class="title">ADD FACULTY</h4>
                    <p class="category"></p>
                </div>
                <div class="content">
                    <h1 >+</h1>  
                </div>
            </div>

            <div ng-click="" id="btnAddAccount" class="card">
                <div class="content">
                    <h4 class="title">ADD</h4>
                </div>
            </div>

            <div ng-click="" id="btnCancelAddAccount" class="card">
                <div class="content">
                    <h4 class="title">CANCEL</h4>  
                </div>
            </div>

        </div>

    </div>
</div>

<jsp:include page="masterpages/footer.jsp"/>
