<%-- 
    Document   : loginpage
    Created on : May 31, 2022, 4:46:42 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <p>email:<input type="text" name="txtemail"/></p>
            <p>password:<input type="password" name="txtpassword"/></p>
            <p><input type="checkbox"/>save me</p>
            <p><input type="submit" value="login"/></p>
        </form>
       <p><%=  (request.getAttribute("error")!=null) ?request.getAttribute("error"):""  %></p>
       <p>
           <%
             String s = (String)request.getAttribute("error");
             if(!s.isEmpty() && s != null)
             { 
                 out.println("<p>" + s + "</p>");
             }
           %>
       </p>
       <%
        String ss=(String)request.getAttribute("error");
       %>
       <p><%=  (ss!=null)?ss:"" %> </p>
    </body>
</html>
