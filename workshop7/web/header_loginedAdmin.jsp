<%-- 
    Document   : header_loginedAdmin
    Created on : Jul 11, 2022, 3:41:57 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Inconsolata:wght@500&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/a5f6897527.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/scripts/scripts.js" defer></script>
        <title>JSP Page</title>
    </head>
    <body>
        <!--Header section  -->
        <div class="header-container">
            <div class="header">
                <div class="header__img" style="background-image : url(images/headerAdmin.jpg);"></div>
                <div class="header__welcome">
                    <h1>Welcome, ${sessionScope.name} </h1>
                </div>
                <div class="btn">
                    <span class="btn__title">
                        <a href="mainController?action=logout">Log out</a>
                    </span>
                </div>
                <div class="navbar-container">
                    <div class="header__nav_bar">
                        <div class="nav__tab">
                            <a id="manageAccount" href="mainController?action=manageAccounts">
                                <div class="nav__content">
                                    <span class="tab__icon">
                                        <i class="fa-solid fa-user-gear"></i>
                                    </span>
                                    <div class="tab__title">
                                        <h4>Manage Accounts</h4>
                                    </div>
                                    <div class="tab__desc">
                                        <p>Search and block or unblock account(s)</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="nav__tab">
                            <a id="manageOrders" href="mainController?action=manageOrders">
                                <div class="nav__content">
                                    <span class="tab__icon">
                                        <i class="fa-solid fa-box"></i>
                                    </span>
                                    <div class="tab__title">
                                        <h4>Manage Orders</h4>
                                    </div>
                                    <div class="tab__desc">
                                        <p>Update ship date and order(s)’s status </p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="nav__tab">
                            <a id="managePlant" href="mainController?action=managePlants">
                                <div class="nav__content">
                                    <span class="tab__icon">
                                        <i class="fa-solid fa-leaf"></i>
                                    </span>
                                    <div class="tab__title">
                                        <h4>Manage Plants</h4>
                                    </div>
                                    <div class="tab__desc">
                                        <p>Search, add, delete plant(s)</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="nav__tab">
                            <a id="manageCate" href="mainController?action=manageCategories">
                                <div class="nav__content">
                                    <span class="tab__icon">
                                        <i class="fa-solid fa-bookmark"></i>
                                    </span>
                                    <div class="tab__title">
                                        <h4>Manage Categories</h4>
                                    </div>
                                    <div class="tab__desc">
                                        <p>Search, add, delete one or many categories</p>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- End of header -->
    </body>
</html>
