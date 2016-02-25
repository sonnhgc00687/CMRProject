<%-- 
    Document   : login
    Created on : Feb 23, 2016, 10:37:08 PM
    Author     : Son
--%>

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
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

  </head>

  <body>

    <div class="container">

      <form class="form-signin" role="form" action="Login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input class="form-control" name="username" placeholder="Email address" required="" autofocus="" maxlength="50">
        <input class="form-control" name="password" placeholder="Password" required="" type="password" maxlength="50">
        <label class="checkbox">
          <input value="remember-me" type="checkbox"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> 
</body>
</html>