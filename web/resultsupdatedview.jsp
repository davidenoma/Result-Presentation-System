<%-- 
    Document   : resultsupdatedview
    Created on : 17-Jun-2017, 07:25:47
    Author     : kolis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean class="edu.mou.rps.model.Results" id="result"  scope="session">

        </jsp:useBean>
        <title>Results Updated</title>
    </head>
    <body>
        <h1>Results updated for ${result.regNumber}</h1>
        <a href="admin_dashboard3.jsp">Update More</a>
        
    </body>
</html>
