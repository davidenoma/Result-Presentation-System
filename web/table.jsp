<%-- 
    Document   : reseult
    Created on : Jun 1, 2017, 12:44:10 PM
    Author     : David Enoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML>
<html>
    <head>
        <title>Web Based Result Presentation System</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <meta name="keywords" content="Web Based Result Presentation Sysytem" />
        <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="datatables/dataTables.bootstrap.css">
        <link rel="stylesheet" type="text/css" href="datatables/jquery.dataTables.css">
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
                            <li><a href="dean.jsp"><img src="images/marker1.png" title="livehelp" />Lecturer Login</a></li>
                            <li><a href="hods.jsp"><img src="images/marker1.png" title="Blog" />HODs Login</a></li>
                            <li><a href="dean.jsp"><img src="images/marker1.png" title="customer report" />Dean Login</a></li>
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
                        <li><a href="dean_generate.jsp">Faculty Result sheet</a></li>
                        <li><a href="dean_summary.jsp">Faculty Summary Result Slides</a></li>
                        <li><a href="dean_result.jsp">View Faculty Result</a></li>
                        <li><a href="dean_print.jsp">Print</a></li>
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
                            <h1 style="text-align:center;font-size: 18px">RESULT</h1><BR>
                            
                        <table style="overflow: scroll" id="example1" class="table table-bordered table-hover table-responsive">
                    <thead class="bg-info">
                    <tr>
                        <th>id</th>
                        <th>Date Created</th>
                        <th>Amount</th>
                        <th>Due Date</th>
                        <th>Expected Amount @level one</th>
                        <th>Expected Amount @level two</th>
                        <th>Plan</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                        <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>9</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>anne</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>david</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                         <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>6</td>
                            <td>7</td>
                            <td>8</td>
                            <td>0</td>
                        </tr>
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
    <script>$(function () { $("#example1").DataTable();});</script>
    
</body>
</html>

