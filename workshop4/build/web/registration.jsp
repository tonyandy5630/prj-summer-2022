<%-- 
    Document   : registration
    Created on : Jun 2, 2022, 3:20:05 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <section>
            <form action="mainController" method="post" class="formregister">
                <table>
                    <tr>
                        <td> email</td>
                        <td> <input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>
                            Password
                        </td>
                        <td> <input type="text" name="password"></td>
                    </tr>
                    <tr>
                        <td>
                            Fullname
                        </td>
                        <td> <input type="text" name="fullname"></td>
                    </tr>
                    <tr>
                        <td>
                            Phone
                        </td>
                        <td> <input type="text" name="phone"></td>
                    </tr>
                    <tr> <td colspan="2"><input type="submit" value="register" name="action"> </td></tr>
                </table>
            </form>
        </section>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
