<%-- 
    Document   : login
    Created on : Feb 23, 2016, 10:37:08 PM
    Author     : Son
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">


        <title>Signin Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">
        <link href="css/light-bootstrap-dashboard.css" rel="stylesheet"/>
        <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />
        <link href="css/css.css" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    </head>

    <body>
        <img id="background" src ="img/bd.png">
        </div>
        <div class="container">
            <div class="pager">
                <img id="logo" src="img/cmr.png" class="img-responsive" width="210px" height="210px"/>
            </div>
            <form class="form-signin" role="form" action="Login" method="post">
                <h2 class="form-signin-heading" id="loginText">SIGN IN</h2>
                <input id="username" class="form-control" name="username" placeholder="Username" required="" autofocus="" maxlength="50">
                <input id="password" class="form-control" name="password" placeholder="Password" required="" type="password" maxlength="50">
                <label class="checkbox">
                    <input value="remember-me">
                </label>
                <button id="btnLogin" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div> 

        <script src="js/js.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/light-bootstrap-dashboard.js"></script>
    </body>
</html>