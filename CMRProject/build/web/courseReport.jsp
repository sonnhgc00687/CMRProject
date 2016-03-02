<%-- 
    Document   : addNewCourseDemo
    Created on : Mar 1, 2016, 3:22:11 PM
    Author     : Hoang Ha Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Course Monitoring Report</title>
        <link rel="stylesheet" href="css/normalize.css">
        <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <form action="index.html" method="post">

            <h1>Course Monitoring Report</h1>

            <fieldset>
                <legend><span class="number">1</span>Course Monitoring Report</legend>
                <label for="name">Academic Session:</label>
                <input type="text" id="name" name="academic_session">

                <label for="code">Course Code and Title:</label>
                <input type="text" id="mail" name="code_title">

                <label for="leader">Course Leader:</label>
                <input type="text" id="password" name="course_leader">

                <label for="name">Student Count:</label>
                <input type="text" id="name" name="user_name">

            </fieldset>

            <fieldset>
                <legend><span class="number">2</span>Statistical Data</legend>
                <table style="width:100%">
                    <tr>
                        <td></td>
                        <td>CW1</td>
                        <td>CW2</td>
                        <td>CW3</td>
                        <td>CW4</td>
                        <td>Exam</td>
                        <td>Overall</td>
                    </tr>
                    <tr>
                        <td>Mean</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>Median</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>Standard Deviation</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                </table> 
            </fieldset>

            <fieldset>
                <legend><span class="number">3</span>Grade Distribution Data</legend>
                <table style="width:100%">
                    <tr>
                        <td></td>
                        <td>0-9</td>
                        <td>10-19</td>
                        <td>20-29</td>
                        <td>30-39</td>
                        <td>40-49</td>
                        <td>50-59</td>
                        <td>60-69</td>
                        <td>70-79</td>
                        <td>80-89</td>
                        <td>90+</td>
                    </tr>
                    <tr>
                        <td>CW1</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>CW2</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>CW3</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>CW4</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>Exam</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                    <tr>
                        <td>Overall</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                        <td><input type="checkbox"</td>
                    </tr>
                </table> 
            </fieldset>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
