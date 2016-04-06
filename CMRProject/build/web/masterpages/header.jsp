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
<!--                <ul class="nav navbar-nav navbar-left">    
                    <li>
                        <a href="">
                            <i class="fa fa-search"></i>
                        </a>
                    </li>
                </ul>-->

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