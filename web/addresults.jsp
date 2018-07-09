<%-- 
    Document   : addresults
    Created on : 02-Jun-2017, 21:05:30
    Author     : kolis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.mou.rps.model.Courses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Enter Marks</title>
    <jsp:useBean class="edu.mou.rps.model.Student" id="st" scope="session">

    </jsp:useBean>
    <jsp:useBean  class="edu.mou.rps.model.Courses" id="course" scope="session">

    </jsp:useBean>
    <jsp:useBean class ="edu.mou.rps.model.Results" id="result" scope="session">
    </jsp:useBean>
    



   



    <body  style="background-color:#00bfff ;color: buttonface; align-content: center">
        <h1>Department: ${st.department}</h1>
        <h1>Program: ${course.program}</h1>
        <h1>Level: ${course.level}</h1>
        <h1>Semester: ${course.semester}</h1>
        <h1>Enter marks for selected student:</h1>
            
        <form action="/ResultPresentationSystem/SetResults">
            <table border="1" width="2"  cellspacing="2"  style="overflow: scroll" id="example1" class="table table-bordered table-hover table-responsive">
                <thead class="bg-info">
                    <tr>
                        <th>COURSE </th>
                        <th>MARKS</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <c:forEach items="${course.courses}" var="item">
                        <c:if test="${item!=null}" >
                            <tr>
                                <td name="course">${item}</td>
                                <td><input type="text" name="${item}"></td>
                            </tr>
                        </c:if>

                    </c:forEach>


                </tbody>
            </table>
            <input type="submit" name="submit">

        </form>

    </body>
</html>
