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
            <form  action="AddCMR" method="post">
                <div id="addCmrForm" class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">COURSE MONITORING REPORT</h4>
                            <p class="category">Add an CMR for <a href="#">${courseTitle}</a> course</p>
                        </div>
                        <div class="content">

                            <div class="row">
                                <input class="form-control" value="${courseId}" readonly="" name="id" type="text" style="display: none">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Title</label>
                                        <input class="form-control" type="text" value="${courseTitle}" readonly="" required="" name="courseCode" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Leader</label>
                                        <input class="form-control" type="text" value="${courseLeader}" readonly="" required="" name="courseTitle" maxlength="50">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Number Of Student</label>
                                        <input class="form-control" placeholder="Number Of Student" type="number" required="" name="studentCount" maxlength="50">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label>Comment</label>
                                        <textarea rows="5" class="form-control" name="comment" placeholder="Comment the cmr here..."></textarea>
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="addCmrStatistic" class="col-md-12">
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
                                                <td><input class="form-control" placeholder="" name="mean1" min="0" max="100" type="number" set="0.01"></td> <td><input class="form-control" placeholder="" name="mean2" min="0" max="100" type="number"></td> 
                                                <td><input class="form-control" placeholder="" name="mean3" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mean4" min="0" max="100" type="number"></td> 
                                                <td><input class="form-control" placeholder="" name="mean5" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mean6" min="0" max="100" type="number"></td>
                                            </tr>
                                            <tr>
                                                <td>Median</td> 
                                                <td><input class="form-control" placeholder="" name="median1" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="median2" min="0" max="100" type="number"></td>
                                                <td><input class="form-control" placeholder="" name="median3" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="median4" min="0" max="100" type="number"></td> 
                                                <td><input class="form-control" placeholder="" name="median5" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="median6" min="0" max="100" type="number"></td>
                                            </tr>
                                            <tr>
                                                <td>Standard Deviation</td> 
                                                <td><input class="form-control" placeholder="" name="sd1" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="sd2" min="0" max="100" type="number"></td>
                                                <td><input class="form-control" placeholder="" name="sd3" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="sd4" min="0" max="100" type="number"></td> 
                                                <td><input class="form-control" placeholder="" name="sd5" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="sd6" min="0" max="100" type="number"></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="addCmrStatistic" class="col-md-12">
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
                                                    <td><input class="form-control" placeholder="" name="mark_1_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_1_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_1_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_1_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_1_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_1_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_1_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_1_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_1_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_1_9" min="0" max="100" type="number"></td>
                                                </tr>
                                                <tr>
                                                    <td>CW2</td> 
                                                    <td><input class="form-control" placeholder="" name="mark_2_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_2_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_2_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_2_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_2_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_2_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_2_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_2_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_2_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_2_9" min="0" max="100" type="number"></td>                                                
                                                </tr>
                                                <tr>
                                                    <td>CW3</td> 
                                                    <td><input class="form-control" placeholder="" name="mark_3_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_3_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_3_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_3_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_3_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_3_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_3_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_3_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_3_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_3_9" min="0" max="100" type="number"></td>                                                
                                                </tr>
                                                <tr>
                                                    <td>CW4</td> 
                                                    <td><input class="form-control" placeholder="" name="mark_4_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_4_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_4_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_4_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_4_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_4_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_4_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_4_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_4_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_4_9" min="0" max="100" type="number"></td>
                                                </tr>
                                                <tr>
                                                    <td>EXAM</td> 
                                                    <td><input class="form-control" placeholder="" name="mark_5_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_5_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_5_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_5_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_5_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_5_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_5_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_5_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_5_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_5_9" min="0" max="100" type="number"></td>
                                                </tr>
                                                <tr>
                                                    <td>OVERALL</td> 
                                                    <td><input class="form-control" placeholder="" name="mark_6_0" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_6_1" min="0" max="100" type="number"></td>
                                                    <td><input class="form-control" placeholder="" name="mark_6_2" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_6_3" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_6_4" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_6_5" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_6_6" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_6_7" min="0" max="100" type="number"></td> 
                                                    <td><input class="form-control" placeholder="" name="mark_6_8" min="0" max="100" type="number"></td> <td><input class="form-control" placeholder="" name="mark_6_9" min="0" max="100" type="number"></td>                                                
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <input id="btnCreateCmr" type="submit" style="display: none"></div>

                    <div class="col-md-3 ng-scope" id="assignCourseButton" style="float: right">
                        <div ng-click="createCmr()" id="btnAssign" class="card">
                            <div class="header">
                                <h4 class="title">CREATE</h4>
                            </div>
                        </div>
                    </div>
                    
                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
    </div>

</div>

<jsp:include page="masterpages/footer.jsp"/>
