<%-- 
    Document   : login
    Created on : Jun 2, 2022, 1:23:24 AM
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
        <header>
            <%@include  file="header.jsp" %>
        </header>
        <section>
            <form action="mainController" method="post">
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
                        <td colspan="2"><input type="submit" value="login" name="action"/></td>
                    </tr>
                </table>
            </form>
        </section>
        <footer>
            <%@include  file="footer.jsp" %>
        </footer>
    </body>
</html>
