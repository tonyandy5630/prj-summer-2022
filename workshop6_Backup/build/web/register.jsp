<%-- 
    Document   : register
    Created on : Jun 17, 2022, 8:31:26 PM
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
        <header> <h1>Register</h1> </header>
       <form action ="mainController" method="post">
           <table>
                <tr>
                   <td> Email </td>
                   <td><input type="text" name ="email" required="" pattern="^(\\w)+@(a-zA-Z]+([.](\\w)+){1,2}" value="<%= (request.getAttribute("email")==null)?"":request.getAttribute("email") %>"> <br></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="text" name ="password" required="" > <br>
                    </td>
                </tr>
                <tr>
                    <td>Full Name </td>
                    <td>
                        <input type="text" name ="fullname" value="<%= (request.getAttribute("fullname")==null)?"":request.getAttribute("fullname") %>"> <br>
                    </td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>
                        <input type="text" name ="phone" value="<%= (request.getAttribute("phone")==null)?"":request.getAttribute("phone")%>"> <br> 
                    </td>
                </tr>
                <tr>
                    <td>
                         <p><%= (request.getAttribute("ERROR")==null)?"":request.getAttribute("ERROR") %><p>
                    </td>
                </tr>
           </table>
            <input type="submit" value="register" name="action"> <br>
        </form>
    </body>
</html>
