<%--
  Created by IntelliJ IDEA.
  User: Fatma Amr
  Date: 9/15/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="../assets/css/all.css">
</head>
<body>
<!-- Start Header Area -->
<header class="header_area sticky-header">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->

                <div class="logo-container">
                    <a class="navbar-brand logo_h" href="index.jsp"
                    ><img src="../assets/img/electro-logo.png" alt="" class="logo-image"
                    /></a>
                </div>

                <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div
                        class="collapse navbar-collapse offset"
                        id="navbarSupportedContent"
                >
                    <ul class="nav navbar-nav menu_nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item submenu dropdown">
                            <a
                                    href="#"
                                    class="nav-link dropdown-toggle"
                                    data-toggle="dropdown"
                                    role="button"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                            >Shop</a
                            >
                            <ul class="dropdown-menu">
                                <li class="nav-item">
                                    <a class="nav-link" href="category.jsp">Shop Category</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="single-product.jsp"
                                    >Product Details</a
                                    >
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="checkout.jsp"
                                    >Product Checkout</a
                                    >
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="confirmation.jsp"
                                    >Confirmation</a
                                    >
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item submenu dropdown">
                            <a
                                    href="#"
                                    class="nav-link dropdown-toggle"
                                    data-toggle="dropdown"
                                    role="button"
                                    aria-haspopup="true"
                                    aria-expanded="false"
                            >Pages</a
                            >
                            <ul class="dropdown-menu">
                                <li class="nav-item">
                                    <a class="nav-link" href="auth/login.jsp">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="tracking.jsp">Tracking</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">Contact</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item">
                            <a href="cart.jsp" class="cart"><span class="ti-bag"></span></a>
                        </li>
                        <li class="nav-item">
                            <button class="search">
                                <a href="profile.jsp" class="cart"><span class="lnr fa-regular fa-user" id="search"></span></a>
                            </button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- End Header Area -->
</body>
</html>
