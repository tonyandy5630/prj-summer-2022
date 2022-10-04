<%-- 
    Document   : login
    Created on : Jun 18, 2022, 10:43:19 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp"%>
        </header>
        <section>
            <form action="mainController" method="post" class="form">
                <p style="color:red;">
                <%= (request.getAttribute("WARNING"))==null?"":request.getAttribute("WARNING") %>
                </p>
                <table>
                    <tr>
                        <td> email</td>
                        <td>
                            <input type="text" name="email">
                        </td>
                    </tr>
                    <tr>
                        <td> password </td>
                        <td>
                            <input type="text" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="login" name="action"> 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="checkbox" value="savelogin" name="savelogin"> Stayed signed in
                        </td>
                    </tr>
                </table>
            </form>
        </section>
        <footer>
            <%@include file="footer.jsp"%>
        </footer>
    </body>
</html>
