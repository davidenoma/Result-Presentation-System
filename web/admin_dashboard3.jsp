<%-- 
    Document   : admin_dashboard3
    Created on : 11-Jun-2017, 22:54:06
    Author     : kolis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student Results</title
 
    </head>
    <body>
        <fieldset>
            <form action="/ResultPresentationSystem/UpdateResults" method="POST">
        <h1>Enter the Registration Number of the Student to Update his/her Scores</h1>
         <br/>
         <h3>Reg Number</h3>
         <input type="text" name="regNumber" value="" size="30" /> <p style="color: green">(Example: U16/NAS/GEM/009)</p>
        
        <h3>Select Semester <select name="semester">
            <option>1</option>
            <option>2</option>
        </select></h3>
        
    <input type="submit"  value="Submit" style="font: inherit; font-size: inherit"/>
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
