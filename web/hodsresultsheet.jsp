<%-- 
    Document   : addstudents
    Created on : 01-Jun-2017, 19:03:44
    Author     : kolis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.mou.rps.controllers.Validation"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <jsp:useBean class="edu.mou.rps.model.Departments" id="departments" scope="session">

        </jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Programs" id="program" scope="session"></jsp:useBean>
            <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
            <meta name="keywords" content="Web Based Result Presentation Sysytem" />
            <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
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
                            <li ><a href="hods_dashboard.jsp">Home</a></li>
                            <li class="active"><a href=#>View Department's Result Sheet</a></li>
                            <!--<li><a href="dep_generate.jsp">Generate Department Result Sheet</a></li>-->
                            <li><a href="hodslidespage.jsp">Result Summary Slide</a></li>
                            <!-- <li><a href="hods_view.jsp">View Result</a></li>-->
                            <li><a href="#">Print Result</a></li>
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
                                    <h1 style="text-align:center;font-size: 18px">VIEW RESULT</h1><BR>
                                    <form action="/ResultPresentationSystem/GetHODResults" method="POST">

                                        <div class="input-catch">
                                            <div class="label">
                                                <label>PROGRAM</label>
                                            </div>
                                            <div class="label2">
                                                <select class="input" name="program">
                                                <c:forEach var="deptProgram" items="${program.departmentPrograms}">
                                                    <option>${deptProgram}</option>
                                                </c:forEach>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="input-catch">
                                        <div class="label">
                                            <label>LEVEL</label>
                                        </div>
                                        <div class="label2">
                                            <select class="input" name="level">
                                                <option>100</option>
                                                <option>200</option>
                                                <option>300</option>
                                                <option>400</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="input-catch">
                                        <div class="label">
                                            <label>SEMESTER</label>
                                        </div>
                                        <div class="label2">
                                            <select class="input" name="semester">
                                                <option>1</option>
                                                <option>2</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="input-catch">
                                        <div class="label"></div>
                                        <div class="label2">
                                            <button type="submit" class="btn"> SEARCH</button>
                                        </div>
                                    </div>

                                </form>
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
    </body>
</html>

