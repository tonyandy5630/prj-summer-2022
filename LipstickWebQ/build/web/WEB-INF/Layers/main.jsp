<%-- 
    Document   : main
    Created on : Jun 12, 2022, 2:05:06 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="<c:url value="/images/download.png"/>"/>
        <link href="<c:url value="/css/stylemain.css"/>" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>  
        <div class="header">
            <div class="header__main">
                <p class="header__title">Lipstick shop</p>  
                <div class="header__btn "> 
                    <c:if test="${empty user }">
                        <a href="<c:url value="/user/login.do"/>" class="btn-item text-center">Login</a>
                        <a href="<c:url value="/user/register.do"/>" class="btn-item text-center">Register</a>
                    </c:if >
                    <c:if test="${not empty user }">
                        <a class="btn-item text-center" style="cursor: default">${user}</a> 
                        <a href="<c:url value="/user/logout.do"/>" class="btn-item text-center">Logout</a>
                    </c:if>
                </div>
            </div>
            <div class="header__text">
                <h1>A lifetime of discounts? It's Genius</h1>
                <p>Great rewarded for your travel- unlock instant savings of 10% or more with a free CterBooking account </p>
            </div>
            <div class="header__slideshow">

                <div class="left">
                    <i class="fa-solid fa-angle-left"></i>
                </div>
                <div class="right">
                    <i class="fa-solid fa-angle-right"></i>
                </div>
                <div class="slide ">
                    <img class="slide-img fade1" src=" <c:url value="/images/sale-lipstick.jpg"/>">
                </div>
                <div class="slide">
                    <img class="slide-img fade1" src=" <c:url value="/images/lipstick.jpg"/>">
                </div>
                <div class="slide">
                    <img class="slide-img fade1" src=" <c:url value="/images/lipstick-2.jpg"/>">
                </div>
                <div class="slide">
                    <img class="slide-img fade1" src=" <c:url value="/images/lipstick-3.jpg"/>">
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
        <div class="footer">
            <span class="copyright">Copyrights &COPY; By Lipstick Shop. All Rights Reserved.</span>
        </div>
    </body>
    <script>
        let index = 1;
        showSlide(index);
        function plusSides(n) {
            showSlide(index += n);
        }
        ;

        function showSlide(n) {
            let i;
            if (n > $('.slide').length)
                index = 1;
            if (n < 1)
                index = $('.slide').length;
            for (i = 0; i < $('.slide').length; i++) {
                $('.slide').eq(i).css('display', 'none');
            }
            $('.slide').eq(index - 1).css('display', 'block');

        }
        ;
        $('.left').click(function () {
            plusSides(1);
        });
        $('.right').click(function () {
            plusSides(-1);
        });
        setInterval(function () {
            $('.right').click();
        }, 5000);
    </script>
</html>
