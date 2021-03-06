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
                <p class="category">List account of FPT University</p>
                
                <form action="SearchStaff" method="post">
                    <div id="search" class="col-md-4" style="display: ">
                        <div class="form-group">
                            <i class="pe-7s-search"></i>
                            <input class="form-control" placeholder="Search" type="text" required="" name="staffName" maxlength="100">
                            <input type="submit" style="display: none">
                        </div>
                    </div>
                </form>
            </div>
            
            <div class="content table-responsive table-full-width">
                <table id="tableCourse" class="table table-hover table-striped">
                    <thead>
                    <th>Username</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Role</th>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="u">
                            <tr>
                                <td>${u.userName}</td>
                                <td>${u.fullName}</td>
                                <td>${u.email}</td>
                                <td>${u.roleName}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div id="addNewAccout" ng-if="${userRole} == 0">
            <form  action="GetAllUser" method="post">
                <div id="addAccountContainer" class="col-md-9">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">New Account</h4>
                        </div>
                        <div class="content">
                            <div class="row">
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Fullname</label>
                                        <input class="form-control" placeholder="Fullname" type="text" required="" name="fullname" value="${fullname}" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Role</label>
                                        <select class="form-control" required="" name="role">
                                            <option value="" disabled selected>Role</option>
                                            <option value="0">Admin</option>
                                            <option value="1">Course Leader</option>
                                            <option value="2">Course Moderator</option>
                                            <option value="3">PVC</option>
                                            <option value="4">DLT</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input class="form-control" placeholder="Username" type="text" required="" name="username" value="${username}" maxlength="50"  aria-describedby="name-format" required aria-required=?true? pattern="[A-Za-z-0-9]+" title="Not include special characters">
                                    </div>
                                </div>
                                <div class="col-md-8">
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" placeholder="Email" type="email" required="" name="email" value="${email}" maxlength="120">
                                    </div>
                                </div>
                            </div>

                            <input id="addAccount" type="submit" value="Add Account" style="display: none " />
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-3" id="addCourseContainer" ng-if="${userRole} == 0">

            <div ng-click="addAccount()" id="btnShowAddAccount" class="card">
                <div class="header">
                    <h4 class="title">ADD ACCOUNT</h4>
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
