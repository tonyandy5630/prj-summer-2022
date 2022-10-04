<%-- 
    Document   : createUser
    Created on : Aug 12, 2022, 8:33:40 AM
    Author     : phant
--%>

<%@page import="user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New User</title>
    </head>
    <body>
        <h1>Create new user</h1>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>        
        <form action="MainController" method="POST">
            User ID <input type="text" name="userID" required="" placeholder="User ID"/>
            <%= userError.getUserIDError()%></br>
            Full Name <input type="text" name="fullName" required="" placeholder="Full Name"/>
            <%= userError.getFullNameError()%></br>
            Role ID <input type="text" name="roleID" value="US" readonly=""/>
            <%= userError.getRoleIDError()%></br>
            Password <input type="password" name="password" required="" placeholder="Password"/></br>
            Confirm <input type="password" name="confirm" required="" placeholder="Confirm Password"/>
            <%= userError.getConfirmError()%></br>
            Status <input type="text" value="true" readonly=""/></br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
