<%-- 
    Document   : updateresults
    Created on : 12-Jun-2017, 01:04:36
    Author     : kolis
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean class="edu.mou.rps.model.Results" id="result"  scope="session">

        </jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Results</title>
    </head>
    <body>
        <h1>View and update results for ${result.regNumber}</h1>
        <form action="/ResultPresentationSystem/NewResults" method="POST" >
              <table border="1" >
                <thead>
                    <tr>
                        <th>Course</th>
                        <th> Marks</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach begin="0" end ="${result.resultCount-1}" var="index" > 
                        <c:if test="${(result.marks[index] != 0)||( result.courses[index]!=null)}" >
                            <tr>
                                <td>${result.courses[index]}</td>
                                <td> <input name="${result.courses[index]}" value="${result.marks[index]}"> </td>
                            </tr>

                        </c:if>

                    </c:forEach>

                </tbody>
            </table>
            <button type="sumbit">UPDATE RESULTS</button>
        </form>
    </body>
</html>
