<%-- 
    Document   : admin_dashboard
    Created on : 28-May-2017, 09:44:40
    Author     : kolis
--%>


<%@page import="edu.mou.rps.model.Levels"%>
<%@page import="edu.mou.rps.model.Levels"%>
<%@page import="edu.mou.rps.model.Departments"%>
<%@page import="edu.mou.rps.model.Programs"%>
<%@page import="edu.mou.rps.model.Semester"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%! String x[]; %>
        <%! String programs[];%>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <style>
            body{
                background-color: #fff;
            }
            .wrap .contact-form input{
                width:80%;
                margin:auto;
            }
            .wrap .contact-form H1{
                text-align: center;
                padding: 10px;
                margin:10px;
            }
            .wrap .contact-form .btn-submit{
                width:85%;
                margin-left:6%;
            }
            .contact-form{
                margin-top:100px;
                margin-bottom: 50px;
            }
            .footer{
                margin-top: 550px;
            }
            .image-slider{
                margin-top:50px;
            }
            .wrap .left-nav a{
                font-size: 19px;
            }
        </style>

    </head>
    <body>

        <h1 style="font-family: sans-serif; font-size: 30px"><a href="admin_dashboard2.jsp">Add Student Results</h1> 
        <h1 style="font-family: sans-serif; font-size: 30px"><a href="admin_dashboard3.jsp">Update Student Results</h1>

        <div class="footer"> 



            <p>Ugoji Catherinemary .N-U13/NAS/COM/036</p>  





            <!---end-wrap---->
        </div>
    </body>
</html>
