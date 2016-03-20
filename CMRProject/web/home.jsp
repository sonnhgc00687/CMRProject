<%-- 
    Document   : home
    Created on : Feb 23, 2016, 11:30:11 PM
    Author     : Son
--%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="masterpages/header.jsp"/>
<div class="row">
    <ul id="navigationTab" class="nav nav-tabs" role="tablist">
        <li><a href="#">
                Home <img src="img/ic_next.png" width="20px"/>
            </a>
        </li>
    </ul>

    <div id="reviewContainer">
        <div class="row featurette">
            <div class="col-md-3">
                <img id="reviewAvarta" src="img/review01.jpg" class="img-circle img-responsive" width="180px" height="180px">
            </div>
            <div class="col-md-9">
                <h2 class="featurette-heading">Hello! I am Tuan.<span class="text-muted">See for yourself.</span></h2>
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-9">
                <h2 class="featurette-heading">Hi! My name is Jaya.<span class="text-muted">Checkmate.</span></h2>
                <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
            </div>
            <div class="col-md-3">
                <img id="reviewAvarta" src="img/review02.jpg" class="img-circle img-responsive" width="180px" height="180px">
            </div>
        </div>

        <hr class="featurette-divider">
    </div>
</div>
<jsp:include page="masterpages/footer.jsp" />               