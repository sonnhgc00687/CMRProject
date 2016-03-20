<%-- 
    Document   : register
    Created on : Mar 20, 2016, 7:13:47 PM
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
        <li><a href="#">
                Registration <img src="img/ic_next.png" width="20px"/>
            </a>
        </li>
    </ul>

    <form id="addAccountGroup" action="Register" method="post">
        <h3>New Account</h3>
        <input class="form-control" type="text" required="" placeholder="Username" name="username" maxlength="50"/>
        <input class="form-control" type="password" required="" placeholder="Password" name="password" maxlength="50"/>
        <input class="form-control" type="password" required="" placeholder="Re-Password" name="re_password" maxlength="50"/>
        <input class="form-control" type="text" required="" placeholder="Full Name" name="name" maxlength="50"/>
        <select class="form-control" required="" name="role">
            <option value="" disabled selected>Role</option>
            <%--<c:forEach items="${facultyList}" var="faculty">
                <option value="${faculty.facultyCode}">${faculty.facultyTitle}</option>
            </c:forEach>         --%>       
        </select>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add Account</button>
    </form>
</div>

<jsp:include page="masterpages/footer.jsp" />    
