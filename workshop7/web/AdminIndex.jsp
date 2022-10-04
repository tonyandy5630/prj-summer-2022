<%-- 
    Document   : AdminIndex
    Created on : Jul 11, 2022, 3:39:21 PM
    Author     : ACER
--%>

<%@page import="sample.dao.AccountDao"%>
<%@page import="sample.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            Cookie[] cookies = request.getCookies();
            Account acc = null;
            boolean login  = false;
            if( name == null )
            {
                for(Cookie c : cookies)
                {
                    if(c.getName().equals("selector"))
                    {
                        String token = c.getValue();
                        acc = AccountDao.getAccountByToken(token);
                        if(acc != null)
                        {
                            name = acc.getFullname();
                            email = acc.getEmail();
                            login = true;
                        }
                    }
                }
            }
            else
                login = true;
            
            if(!login)
            {
                %>
                 <p class="loginWarning"> <font color="red"> you must login as admin to view this page </font></p>
                <a href="index.jsp">Log in</a>
        <%
            }
            else
            {
        %>
        <%--<c:import url="header_loginedAdmin.jsp" ></c:import>--%>
        <%@include file="header_loginedAdmin.jsp" %>
        <section class="right">
            <img src="images/background.jpg" alt ="" class="background" >   
        </section>
        <%@include file="footer.jsp" %>
        <%}%>
    </body>
</html>
