<%-- 
    Document   : page2
    Created on : Jun 21, 2022, 4:38:34 PM
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
        <jsp:useBean id="b" class="basic.Book" scope="request"/>
        <jsp:getProperty name="b" property = "id"  />
        <jsp:getProperty name="b" property = "title"  />
        <jsp:getProperty name="b" property = "price"  />
        <hr/>
        <h1> ${"lmao"} </h1>
        <h2> ${100}</h2>
        <h3>${10*3}</h3>
        <h3>${10>3}</h3>
        <h3>${10%2==0 and 10<20}</h3>
        <h3>${b.title}</h3>
        <h1>${requestScope.b}</h1>
        <h1>count param : ${param.count} </h1>
        <h2>${ b.changeCase() }</h2>
        <jsp:include page="footer.jsp" />
    </body>
</html>
