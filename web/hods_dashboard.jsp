<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="edu.mou.rps.controllers.*" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <jsp:useBean class="edu.mou.rps.model.Staff" id="staff" scope="session"></jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Student" id="student" scope="session"></jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Courses" id="course" scope="session"></jsp:useBean>
            <style>
                table{
                    width: 67%;			
                }
                .clare{
                    color: #333;
                }
                .clare td{
                    font-family: inherit;
                    box-shadow: 0 1px 7px;
                    border-width: 10px;
                    background-color: #25292B;
                    color: #fff;
                    text-align: center;
                }
                .wrap .content .singlelink .section group example .col_1_of_1 span_1_of_1 {
                    font-size: 18px;
                    font-weight: bold;
                    float:right;

                }
                .col-1{
                    width:30%;
                    border:1px solid #333;
                    float:left;
                    padding:40px;
                    box-shadow: 10px 10px 9px #ccc;
                    margin:30px;
                }
                .col-1 .ms{
                    font-size: 50px;
                    font-weight: bold;





                </style>
                <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
                <meta name="keywords" content="legend iphone web template, Andriod web template, Smartphone web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
                <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>

            </head>
            <body>
            <%!String x;%>
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
                            <li class="active"><a href="hods_dashboard.jsp">Home</a></li>
                            <li ><a href="hodsresultsheet.jsp">View Department's Result Sheet</a></li>
                            <!--<li><a href="dep_generate.jsp">Generate Department Result Sheet</a></li>-->
                            <li><a href="hodslidespage.jsp">Result Summary Slide</a></li>
                            <!-- <li><a href="hods_view.jsp">View Result</a></li>-->
                            <li><a href="#">Print Result</a></li>
                        </ul>
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
            </div>
            <!---end-header---->
            <div class="wrap">
                <!---start-content---->
                <div class="content">
                    <div class="singlelink">
                        <div class="section group example" >
                            <div class="col_1_of_1 span_1_of_1">

                                <h3 style="font-size: 50px" >Welcome <%=Validation.jobRolePlaceHolder%> of <%=Validation.departmentPlaceHolder%> Department</h3>


                                    <a href="#">
                                        <div class="col-1">
                                            <h2>TOTAL  NUMBER OF STUDENTS</h2>
                                            <h1 class="ms">${student.numberOfStudentsInDepartment}</h1>
                                            <hr>
                                            <div class="foot">
                                                <p>HERE IS THE TOTAL NUMBER OF STUDENTS IN THE DEPARTMENT</p>
                                            </div>
                                        </div>
                                        <div class="col-1">
                                            <h2>TOTAL  NUMBER OF COURSES OFFERED</h2>
                                            <%
                                                course.setNumberOfCoursesInDepartment(Validation.departmentPlaceHolder);
                                            %>
                                            <h1 class="ms">${course.numberOfCoursesInDepartment}</h1>
                                            <hr>
                                            <div class="foot">
                                                <p>HERE IS THE TOTAL NUMBER OF COURSES OFFERED IN THE DEPARTMENT</p>
                                            </div>
                                        </div>
                                    </a>
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
            </body>
        </html>

