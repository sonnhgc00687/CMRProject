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
                <p class="category">List crm of <a href="#">Honours Programme</a> Faculty</p>
            </div>
            <div class="content table-responsive table-full-width">
                <table id="tableCmr" class="table table-hover table-striped">
                    <thead>
                    <th>Crm</th>
                    <th>Code</th>
                    <th>Title</th>
                    <th>Faculty</th>
                    <th>Detail</th>     
                    </thead>
                    <tbody>
                        <c:forEach items="${listCMR}" var="cmr">
                            <tr>
                                <td>${cmr.cmr_code}</td>
                                <td>${cmr.course_code}</td>
                                <td>${cmr.course_title}</td>
                                <td>${cmr.course_faculty}</td>
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
