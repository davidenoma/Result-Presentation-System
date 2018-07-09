

<%@page import="edu.mou.rps.controllers.Validation"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <meta name="keywords" content="Web Based Result Presentation Sysytem" />
        <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
        <jsp:useBean class="edu.mou.rps.model.Staff" id="staff" scope="session"></jsp:useBean>
         <jsp:useBean class="edu.mou.rps.model.Results" id="result" scope="session"></jsp:useBean>
         <jsp:useBean class="edu.mou.rps.model.Departments" id="department_" scope="session"></jsp:useBean>
         <jsp:useBean class="edu.mou.rps.model.Student" id="student_" scope="session"></jsp:useBean>
        <style>
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
                float:right;
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
                        <li class="active"><a href="dean_dashboard.jsp">Home</a></li>
                        <li><a href="deanresultsheet.jsp">Faculty Result sheet</a></li>
                        <li><a href="deanslidespage.jsp">Faculty Result Slides</a></li>
                        
                        <!--<li>li><a href="reseult.jsp">View Faculty Result</a></li>-->
                        <li><a href="#" onclick="window.print()">Print</a></li>
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
                        <h3 style="font-size:38px">Welcome Dean of the Faculty of Natural Sciences</h3>
                        <a href="#">
                        <div class="col-1">
                            <h2>TOTAL  NUMBER OF RESULTS FOR BOTH SEMESTERS OF THE 2017/2018 SESSION</h2>
                            <h1 class="ms">${result.totalResultsSubmitted}</h1>
                            <hr>
                            <div class="foot">
                                <p>HERE IS THE TOTAL RESULTS SUBMITTED IN THE FACULTY</p>
                            </div>
                        </div>
                        </a>
                        
                        <a href="#">
                        <div class="col-1">
                            <h2>TOTAL  NUMBER OF STUDENTS</h2>
                            <h1 class="ms">${student_.totalNumberOfStudents}</h1>
                            <hr>
                            <div class="foot">
                                <p>HERE IS THE TOTAL NUMBER OF STUDENTS IN THE FACULTY</p>
                            </div>
                        </div>
                         </a>
                        
                        <a href="#">
                        <div class="col-1">
                            <h2>TOTAL  NUMBER OF DEPARTMENTS</h2>
                            <h1 class="ms">${department_.numberOfDepartments}</h1>
                            <hr>
                            <div class="foot">
                                <p>HERE IS THE TOTAL NUMBER OF DEPARTMENTS IN THE FACULTY</p>
                            </div>
                        </div>
                        </a>    
                        
                  
                        <a href="#">
                        <div class="col-1">
                            <h2>TOTAL  NUMBER OF HODS</h2>
                            <h1 class="ms">${staff.totalNumberOfHods}</h1>
                            <hr>
                            <div class="foot">
                                <p>HERE IS THE TOTAL NUMBER OF HOD'S WHO HAVE SUBMITTED RESULTS</p>
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

