<%-- 
    Document   : header
    Created on : Mar 26, 2016, 10:54:33 AM
    Author     : Son
--%>

<div class="main-panel">
    <nav class="navbar navbar-default navbar-fixed">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Course Monitoring Report System</a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="">
                            ${userSession}
                        </a>
                    </li>                

                    <li>
                        <a href="Logout" method="GET">
                            Log out
                        </a>
                    </li>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="notify" ng-if="${errorCode} != 0" data-notify-position="top-right" data-notify="container" class="col-xs-11 col-sm-4 alert alert-danger alert-with-icon animated fadeInDown" role="alert">
        <button id="closeNotify" onclick="closeNotify()" type="button" aria-hidden="true" class="close" data-notify="dismiss">×</button>
        <span class="pe-7s-attention" data-notify="icon"></span>
        <span data-notify="message">${message}</span>
        <a href="#" target="_blank" data-notify="url"></a>
    </div>

    <script>
        function closeNotify() {
            document.getElementById('notify').style.display = 'none';
        }
    </script>