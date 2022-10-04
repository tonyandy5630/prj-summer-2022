<%-- 
    Document   : show
    Created on : Jun 18, 2022, 8:18:11 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/styleShow.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Lipstick shop</title>
    </head>

    <body>
        <div class="header">
            <div class="header__main">
                <p class="header__title">Lipstick shop</p>
            </div>
        </div>    
        <div class="body">
            <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
        </div>
        <div class="footer">
            <span class="copyright">Copyrights &COPY; By Lipstick Shop. All Rights Reserved.</span>
        </div>
    </div>
</body>
</html>
