<%-- 
    Document   : homepage
    Created on : Jun 12, 2022, 2:41:33 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/css/styleHome.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Lipstick shop</title>
    </head>
    <body> 
        <form action="<c:url value="/home/search.do"/>" class="search text-center">
            <input class="bar-input" placeholder="Nhập thông tin.." type="text" name="find" value="${Search}"/>
            <input class="bar-submit" type="submit" value="Search" />
        </form>
        <div class="cart fade1">
            <div class="quantity text-center">
                <c:if test="${empty cart}">
                    0 
                </c:if>
                <c:if test="${not empty cart}">
                    ${quantity}
                </c:if>
            </div>
            <a href="<c:url value="/home/showCart.do"/>" ><i class="fa-solid fa-cart-shopping"></i></a>
        </div>
        <div class="body">

            <div class="showitems ">

                <div class="category ">
                    <strong>Danh mục sản phẩm</strong>
                    <div class="border"></div>
                    <ul>
                        <c:forEach items="${listBrand}" var="brand" >
                            <li><a href="<c:url value="/home/homePage.do?brandID=${brand.branID}"/>">${brand.brandName}</a></li>
                            </c:forEach>
                        <li><a href="<c:url value="/home/homePage.do"/>">Show All</a></li>
                    </ul>
                </div>
                <div class="list ">
                    <c:forEach items="${listProduct}" var="product" >
                        <div class="item text-center">
                            <div class="item-img">
                                <img src=<c:url value="/${product.images}"/>>
                            </div>
                            <p>${product.name}</p>
                            <p><fmt:formatNumber value="${product.price}" pattern="#,### VND" /></p>
                            <a class="btn btn-default" href="<c:url value="/home/buy.do?productID=${product.productid}"/>">buy</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
    <script>
        $(document).scroll(function () {
            $('.cart').css('display', 'block');
        });
    </script>
</html>
