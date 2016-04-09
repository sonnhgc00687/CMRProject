<%-- 
    Document   : new_home
    Created on : Mar 26, 2016, 10:29:41 AM
    Author     : Son
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/leftbar.jsp"/>
<jsp:include page="masterpages/header.jsp"/>

<div class="content" id="cmrContainer">
    <div class="container-fluid">
        <div class="card">
            <div class="header">
                <p class="category" style="float: left">LIST CMR ${facultyName} </p>

                <div id="cardFilter" class="card dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i id="filter" class="pe-7s-filter"></i>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="GetAllCMR?=&filter=approved">Approved CMR (Only CM, DLT , PVC, Admin)</a></li>
                        <li><a href="GetAllCMR?=&filter=commented">Completed CMR</a></li>
                        <li><a href="GetAllCMR?=&filter=all">All CMR (Only Admin)</a></li>
                    </ul>
                </div>

                <div id="search" class="col-md-4">
                    <div class="form-group">
                        <i class="pe-7s-search"></i>
                        <input class="form-control" placeholder="Search" type="text" required="" name="searchCMR" maxlength="100">
                    </div>
                </div>
            </div>
            <div class="content table-responsive table-full-width">
                <table id="tableCmr" class="table table-hover table-striped">
                    <thead>
                    <th>Crm</th>
                    <th>Code</th>
                    <th>Title</th>
                    <th>Faculty</th>
                    <th>Create Date</th>
                    <th>Detail</th>     
                    </thead>
                    <tbody>
                        <c:forEach items="${listCMR}" var="cmr">
                            <tr>
                                <td>${cmr.cmr_code}</td>
                                <td>${cmr.course_code}</td>
                                <td>${cmr.course_title}</td>
                                <td>${cmr.course_faculty}</td>
                                <td>${cmr.date}</td>
                                <td><a class="btn btn-default" href="GetCMRDetail?&courseID=${cmr.cmr_code}" role="button">Detail</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="masterpages/footer.jsp"/>
