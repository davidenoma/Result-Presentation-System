

<%@page import="edu.mou.rps.controllers.Validation"%>
<%@page import="java.sql.Statement"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Statement"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <meta name="keywords" content="Web Based Result Presentation Sysytem" />
        <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" type="text/css" href="datatables/jquery.dataTables.css">
      
        <jsp:useBean class="edu.mou.rps.model.Courses" id="course" scope="session"></jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Grades" id="grade" scope="session"></jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Programs" id="program" scope="session"></jsp:useBean>
        

            <style>
                .form-field{
                    width:80%;
                    border-top:2px solid #333;
                    margin-left: auto;
                    margin-right: auto;
                    padding:20px;
                }
                .form-field .input-catch{
                    width:60%;
                    margin:auto;
                }
                .form-field .input-catch .label{
                    width:20%;
                    float:left;
                    margin: 10px;
                }
                .form-field .input-catch .label2{
                    width:80%;
                    float:left;

                }
                .form-field .input-catch .label2 .input{
                    width:100%;
                    float:left;
                    height: 30px;
                    margin: 10px;
                }
                .btn{
                    width:100%;
                    background-color:#86bad2;
                    height:30px;
                    border:none;
                    margin-left:10px;
                }
            </style>
        </head>
        <body>
            <!---start-wrap---->


            <!---start-header---->
            <div class="header">
                <div class="wrap">
                    <!---start-logo---->
                    <div class="logo">
                        <a href="index.jsp"><img src="images/logo.png" title="logo" /></a>
                    </div>
                    <!---end-logo---->
                    <!---start-search---->
                    <div class="top-search-bar">
                        <div class="header-top-nav">
                            <ul>
                                <li><a href="index.jsp"><img src="images/marker1.png" title="customer report" />LOGOUT</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
            <div class="clear"> </div>
            <div class="header-nav">
                <div class="wrap">
                    <div class="left-nav">
                        <ul>
                            <li class="active"><a href="dean_dashboard.jsp">Back To Home</a></li>


                            <li><a href="deanresultsheet.jsp">Back to Faculty Result Sheet</a></li>
                            <li><a href="#"  onclick="window.print();">Print</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right-social-icons">
                    <ul>
                        <li><a class="icon1" href="#"> </a></li>
                        <li><a class="icon2" href="#"> </a></li>
                        <li><a class="icon3" href="#"> </a></li>
                        <li><a class="icon4" href="#"> </a></li>
                    </ul>
                </div>
                <div class="clear"> </div>
            </div>
            <!---start-search---->

            <!---end-header---->
            <div class="wrap">
                <!---start-content---->
                <div class="content">
                    <div class="singlelink">
                        <div class="section group example">
                            <div class="col_1_of_1 span_1_of_1">
                                <div class="form-field">
                                    <h1 style="text-align:center;font-size: 18px" id="title">RESULTS FOR THE COURSES OF FACULTY OF NATURAL SCIENCES' ${course.department} DEPARTMENT's ${program.programName} ${course.level} LEVEL </h1><BR>

                                <table id="example1" >
                                    <thead class="bg-info" >
                                        <tr>
                                            <th>S/N</th>
                                            <th>Course Code </th>
                                         
                                            <th>Total Students</th>
                                            <th>Pass</th>
                                            <th>Fail</th>
                                            <th>A</th>
                                            <th>B</th>
                                            <th>C</th>
                                            <th>D</th>
                                            <th>E</th>
                                            <th>F</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tbody">
                                        <c:forEach begin="1" end ="${course.courseCodeCount-1}" var="index" >

                                            <tr>
                                                <c:if test="${not empty course.courseTitles}" >
                                                    <td>${index}</td>
                                                    <td>${course.courseCodes[index]}</td>
                                   
                                                    <td>   ${grade.totalNumber[index]}</td>
                                                    <td>${grade.totalNumberOfPass[index]}</td>
                                                    <td>${grade.totalNumberOfFails[index]}</td>
                                                    <td>${grade.totalNumberOfA[index]}</td>
                                                    <td>${grade.totalNumberOfB[index]}</td>
                                                    <td>${grade.totalNumberOfC[index]}</td>
                                                    <td>${grade.totalNumberOfD[index]}</td>
                                                    <td>${grade.totalNumberOfE[index]}</td>
                                                    <td>${grade.totalNumberOfF[index]}</td>

                                                </c:if>


                                            </tr>


                                        </c:forEach>
                                        <%
                                            request.getSession().invalidate();
                                        %>
                                    </tbody>

                                </table>  
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clear"> </div>
            </div>
        </div>
        <!---End-content---->
        <div class="clear"> </div>
        <div class="footer"> 
            <div class="wrap"> 
                <div class="footer-left">
                    <ul>

                    </ul>

                </div>
                <div class="footer-right">
                    <p>Ugoji Catherinemary .N-U13/NAS/COM/036</p>
                </div>
                <div class="clear"> </div>
            </div>
            <div class="clear"> </div>
            <!---end-wrap---->
        </div>
        <script src="js/jQuery.js"></script>
        <script src="datatables/dataTables.bootstrap.min.js"></script>
        <script src="datatables/jquery.dataTables.min.js"></script>
        <script>$(function () {
                                    $("#example1").DataTable();
                                });</script>
    </body>
</html>

