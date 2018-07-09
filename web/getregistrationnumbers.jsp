<%-- 
    Document   : addstudents
    Created on : 01-Jun-2017, 19:03:44
    Author     : kolis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Results</title>
        <jsp:useBean class="edu.mou.rps.model.Student" id="st" scope="session">

        </jsp:useBean>
        <jsp:useBean  class="edu.mou.rps.model.Courses" id="course" scope="session">

        </jsp:useBean>

    </head>
    <body style="background-color:#00bfff ;color: buttonface; align-content: center">
        <h1> CHOOSE A REGISTRATION NUMBER TO ENTER RESULTS</h1>
        <fieldset>

            <h1 style='font-style: normal'>Department: 
                ${st.department}</h1>
            <h1>Program: ${st.program}</h1>
            <h1>Level Selected: ${st.level}</h1>
            <h1>Semester Select:${course.semester} </h1>
            <form action="/ResultPresentationSystem/GetSelectedRegistrationNumber">
                <select name="regnumbers" style="font: inherit;font-size: 30px">
                    <c:forEach var="item" items="${st.registrationNumbers}" >
                        <c:if test="${st.isResultsExist(item)== false}" >

                            <option>${item}</option>
                        </c:if>



                    </c:forEach>
                </select>
                <br>


                <input type="submit" style="font-size: 30px; font-family: inherit" name="submit">
            </form>

            <br>



        </fieldset>





    </body>
</html>
