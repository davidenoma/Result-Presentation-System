<%-- 
    Document   : successpage
    Created on : 30-Jun-2017, 03:00:21
    Author     : kolis
--%>

<%@page import="edu.mou.rps.Utilities.Presentation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Slides Page</title>
        <jsp:useBean class="edu.mou.rps.model.Departments" id="department" scope="session">

        </jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Programs" id="programs" scope="session"></jsp:useBean>
        <jsp:useBean class="edu.mou.rps.model.Staff" id="staff" scope="session"></jsp:useBean>
    </head>
    <body>
        <h1>Slides Generated Successfully</h1>
        <%
            Presentation ps = new Presentation();
            String s = "file:///" + ps.getFileLocation();
        %>
        <h2>You can find the Power Point document at: <%=ps.getFileLocation()%></h2>


        <a href="file:///C:\Users\kolis\Documents\NetBeansProjects\ResultPresentationSystem\" >Click to open</a>

        <h3><a href="hodslidespage.jsp"> BACK</a></h3>

    </body>
</html>
