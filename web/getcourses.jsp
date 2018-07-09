<%-- 
    Document   : addresults
    Created on : 30-May-2017, 21:00:05
    Author     : kolis
--%>

<%@page import="edu.mou.rps.model.Programs"%>
<%@page import="edu.mou.rps.model.Semester"%>
<%@page import="edu.mou.rps.model.Levels"%>
<%@page import="edu.mou.rps.model.Courses"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input Results</title>
    </head>
    <body  style="background-color:#038acc;">
        <h1>Please Select a Course to enter the Student's Course</h1>
        <select name="courses">
            <%
                for (String x : Courses.getCourses(Levels.levelSelected, Semester.semesterSelected,Programs.programSelected)) {
                    if (x == null) {
                        continue;
                    } else {
                        out.println("<option>" + x + "</option>");
                    }
                }
            %>

        </select>
    </body>
</html>
