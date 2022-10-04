<%-- 
    Document   : profilePage
    Created on : Jun 10, 2022, 9:50:09 PM
    Author     : ACER
--%>

<%@page import="sample.dao.AccountDao"%>
<%@page import="sample.dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name = (String) session.getAttribute("name");
            String success="undified";
            if(request.getParameter("success") != null)
            { %>
                <h3 style="color:red"> Update successfully</h3>
        <%  }
            String email = (String) session.getAttribute("email");
            Cookie[] c = request.getCookies();
            boolean login = false;
            Account acc = null;
            if (name == null) {
                for( Cookie aCookie : c)
                {
                    if(aCookie.getName().equals("selector"))
                    {
                         String token = aCookie.getValue();
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
            {
                login = true;
            }
            if(!login)
            { %>
                    <h1 style="color:red;"> Please log in to use this page</h1>
                    <a href="index.jsp">Log in</a>
        <%  }
            else
            {
                
                if(acc == null)
                {
                    int accID = (int)session.getAttribute("accID");
                    acc = AccountDao.getAccountByID(accID);
                }
                %>
                <form action="mainController" method="get"> 
                    <h1> <%= acc.getFullname() %>'s PROFILE </h1>
                    <div class="inline-container"> 
                        <h3> Fullname : <%= acc.getFullname() %></h3>
                        <input type="text" placeholder="Enter new fullname"  name="fullname">
                     </div>
                    
                    <h3> Email: <%= acc.getEmail() %></h3>
                    <div class="inline-container">   
                        <h3> Phone number: <%=acc.getPhone() %> </h3>
                        <input type="text" placeholder="Enter new Phone"  name="phone">
                    </div>
                        <input type="hidden" value="<%=acc.getAccid() %>" name="accid">
                        <input type="submit" value="updateProfile" name="action">
                </form>
        <%  } %>
        <a href="personalPage.jsp"> Back to personal page</a>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
</html>
