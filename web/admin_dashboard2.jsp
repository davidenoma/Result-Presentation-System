<%-- 
    Document   : admin_dashboard2
    Created on : 01-Jun-2017, 13:34:22
    Author     : kolis
--%>


<%@page import="edu.mou.rps.model.Levels"%>
<%@page import="edu.mou.rps.model.Departments"%>
<%@page import="edu.mou.rps.model.Programs"%>
<%@page import="edu.mou.rps.model.Semester"%>
<%@page import="java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <%! String x[]; %>
        <%! String programs[];%>
        <%
            Departments departments = new  Departments();
            Programs programs = new Programs();
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="align-self: center">Get Students</title>

    </head>
    <body>
        <h1 style="align-self: center" >Get Student Registration Numbers</h1>
        <fieldset>

            <form style="align-content: center; align-items: center" action="/ResultPresentationSystem/GetStudents" method="get">


                <h2 style="font-size: 30px;"> Select Department <select  style="font-size: 30px; font-family: inherit;" name="departments">
                        <%for (String y :departments.getDepartments()) {
                                if (y == null) {
                                    continue;
                                } else {
                                    out.println("<option>" + y + "</option>");
                                }
                            }
                            //RequestDispatcher rd = request.getRequestDispatcher("sampleinclude.jsp");
                            // rd.forward(request, response);
                        %>
                    </select>
                </h2>
                <h2 style="font-size: 30px;">Select Program <select name="programs" style="font-size: 30px; font-family: inherit;">

                        <% for (String y : programs.getAllPrograms()) {
                                if (y == null) {
                                    break;
                                } else {
                                    out.println("<option>" + y + "</option>");
                                }
                            }
                        %>
                    </select>
                </h2>
                <h2 style="font-size: 30px;">Select Level
                    <select  name="level" style="font-size: 30px; font-family: inherit;">
                        <option>100</option>
                        <option>200</option>
                        <option>300</option>
                        <option>400</option>
                    </select>
                </h2>
                <h2 style="font-size: 30px;">Select Semester

                    <select name="semester" id="semester" style="font: inherit;font-size: 30px">
                        <option value="1">1 </option>
                        <option value="2"> 2</option>
                    </select>

                </h2>

                <input type="submit" style="font-size: 30px; font-family: inherit" name="Get Students' List">
            </form>
        </fieldset>
                        <div class="footer"> 
        <div class="wrap"> 
            <div class="footer-left">
                <ul>

                </ul>
            </div>
            <div class="footer-right">
                <p>Ugoji Catherinemary .N-U13/NAS/COM/036
                </p>
            </div>
            <div class="clear"> </div>
        </div>
        <div class="clear"> </div>
        <!---end-wrap---->
    </div>
    </body>
</html>