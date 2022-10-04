<%-- 
    Document   : loginpage
    Created on : May 31, 2022, 2:06:05 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            <table>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="txtemail" /></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="text" name="txtpassword" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="login" /></td>
                </tr>
            </table>
            <p><%= request.getAttribute("error") != null ? request.getAttribute("error") : ""%></p>
        </form>
        <h3><a href="register.html">Register</a></h3>
    </body>
</html>
