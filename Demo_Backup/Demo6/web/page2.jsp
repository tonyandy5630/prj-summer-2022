<%-- Document : page2 Created on : Jun 21, 2022, 1:06:10 PM Author : thanhtra
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <jsp:useBean id="b" class="basic.Book" scope="request" />
    <jsp:getProperty name="b" property="id" />
    <jsp:getProperty name="b" property="title" />
    <jsp:getProperty name="b" property="price" />
    <h1>Count <%= request.getParameter("count")%></h1>

    <h1>${"Anh yeu em"}</h1>

    <h2>${3}</h2>
    <h3>${10+20}</h3>
    <h4>${10>4}</h4>
    <h5>${(10>0 and 1<4)}</h5>
    <h6>${b.title}</h6>
    <h1>${ param.count }</h1>
    <h2>${b.changeCase()}</h2>
    <jsp:include page="page3.jsp" />
  </body>
</html>
