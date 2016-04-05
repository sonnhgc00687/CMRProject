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

        <div id="addNewCmr">
            <form  action="ApproveCMR" method="post">
                <div id="addCmrForm" class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">COURSE MONITORING REPORT</h4>
                            <p class="category">CMR for <a href="#">${courseTitle}</a> course</p>
                        </div>
                        <div class="content">

                            <div class="row">
                                <input class="form-control" value="${courseId}" readonly="" name="id" type="text" style="display: none">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input class="form-control" type="text" value="${courseTitle}" readonly="" name="courseCode" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Leader</label>
                                        <input class="form-control" type="text" value="${courseLeader}" readonly="" name="courseTitle" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Number Of Student</label>
                                        <input class="form-control" type="text" value="${studentCount}" readonly="" name="studentCount" maxlength="50">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Comment</label>
                                        <textarea rows="5" class="form-control" name="comment" readonly="">${comment}</textarea>
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="cmrStatisticDetail" class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">STATISTICAL DATA</h4>
                        </div>
                        <div class="content"> 
                            <div class="row">
                                <div class="table-responsive table-full-width">          
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th>#</th> <th>CW1</th> <th>CW2</th> <th>CW3</th> <th>CW4</th> <th>EXAM</th> <th>OVERALL</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Mean</td> 
                                                <td>${mean1}</td> <td>${mean2}</td> 
                                                <td>${mean3}</td> <td>${mean4}</td> 
                                                <td>${mean5}</td> <td>${mean6}</td>
                                            </tr>
                                            <tr>
                                                <td>Median</td> 
                                                <td>${median1}</td> <td>${median2}</td>
                                                <td>${median3}</td> <td>${median4}</td> 
                                                <td>${median5}</td> <td>${median6}</td>
                                            </tr>
                                            <tr>
                                                <td>Standard Deviation</td> 
                                                <td>${sd1}</td> <td>${sd2}</td>
                                                <td>${sd3}</td> <td>${sd4}</td> 
                                                <td>${sd5}</td> <td>${sd6}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="cmrGradeDetail" class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">GRADE DISTRIBUTION DATA</h4>
                            </div>
                            <div class="content"> 
                                <div class="row">
                                    <div class="table-responsive table-full-width">          
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th> <th>0 - 9</th> <th>10 - 19</th> <th>20 - 29</th> <th>30 - 39</th> <th>40 - 49</th> <th>50 - 59</th> <th>60 - 69</th> <th>70 - 79</th> <th>80 - 89</th> <th>90+</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>CW1</td> 
                                                    <td>${mark_1_0}</td> <td>${mark_1_1}</td>
                                                    <td>${mark_1_2}</td> <td>${mark_1_3}</td> 
                                                    <td>${mark_1_4}</td> <td>${mark_1_5}</td> 
                                                    <td>${mark_1_6}</td> <td>${mark_1_7}</td> 
                                                    <td>${mark_1_8}</td> <td>${mark_1_9}</td>
                                                </tr>
                                                <tr>
                                                    <td>CW2</td> 
                                                    <td>${mark_2_0}</td> <td>${mark_2_1}</td>
                                                    <td>${mark_2_2}</td> <td>${mark_2_3}</td> 
                                                    <td>${mark_2_4}</td> <td>${mark_2_5}</td> 
                                                    <td>${mark_2_6}</td> <td>${mark_2_7}</td> 
                                                    <td>${mark_2_8}</td> <td>${mark_2_9}</td>                                                
                                                </tr>
                                                <tr>
                                                    <td>CW3</td> 
                                                    <td>${mark_3_0}</td> <td>${mark_3_1}</td>
                                                    <td>${mark_3_2}</td> <td>${mark_3_3}</td> 
                                                    <td>${mark_3_4}</td> <td>${mark_3_5}</td> 
                                                    <td>${mark_3_6}</td> <td>${mark_3_7}</td> 
                                                    <td>${mark_3_8}</td> <td>${mark_3_9}</td>                                                
                                                </tr>
                                                <tr>
                                                    <td>CW4</td> 
                                                    <td>${mark_4_0}</td> <td>${mark_4_1}</td>
                                                    <td>${mark_4_2}</td> <td>${mark_4_3}</td> 
                                                    <td>${mark_4_4}</td> <td>${mark_4_5}</td> 
                                                    <td>${mark_4_6}</td> <td>${mark_4_7}</td> 
                                                    <td>${mark_4_8}</td> <td>${mark_4_9}</td>
                                                </tr>
                                                <tr>
                                                    <td>EXAM</td> 
                                                    <td>${mark_5_0}</td> <td>${mark_5_1}</td>
                                                    <td>${mark_5_2}</td> <td>${mark_5_3}</td> 
                                                    <td>${mark_5_4}</td> <td>${mark_5_5}</td> 
                                                    <td>${mark_5_6}</td> <td>${mark_5_7}</td> 
                                                    <td>${mark_5_8}</td> <td>${mark_5_9}</td>
                                                </tr>
                                                <tr>
                                                    <td>OVERALL</td> 
                                                    <td>${mark_6_0}</td> <td>${mark_6_1}</td>
                                                    <td>${mark_6_2}</td> <td>${mark_6_3}</td> 
                                                    <td>${mark_6_4}</td> <td>${mark_6_5}</td> 
                                                    <td>${mark_6_6}</td> <td>${mark_6_7}</td> 
                                                    <td>${mark_6_8}</td> <td>${mark_6_9}</td>                                                
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>  
                            </div>
                        </div>

                        <input type="submit" class="col-md-3" id="btnApprove" value="APPROVE">
                    </div>  

                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
    </div>

</div>

<jsp:include page="masterpages/footer.jsp"/>
