<%-- Document : page6 Created on : Jun 21, 2022, 2:31:19 PM Author : thanhtra
--%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>JSP Page</title>
  </head>
  <body>
    <form>
      Num1: <input type="text" name="num1" value="${param.num1}" /> <br />
      Num2: <input type="text" name="num2" value="${param.num2}" /> <br />
      <c:catch var="ee">
        <c:if test="${not empty param.num1 and not empty param.num2}">
          <c:set var="division" value="${param.num1 / param.num2}" />
          Division: <c:out value="${division}" /> <br /> </c:if
        ><br />
      </c:catch>
      <input type="submit" value="Divide" />
      <c:if test="${not empty ee}">
        Error occurred<br />
        <c:out value="${ee}" />
      </c:if>
    </form>
  </body>
</html>
