<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="icon" href="../assets/img/electro-logo.png" />
    <!-- Author Meta -->
    <meta name="author" content="CodePixar">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Electro</title>

    <!--
            CSS
            ============================================= -->
    <link rel="stylesheet" href="../assets/css/linearicons.css">
    <link rel="stylesheet" href="../assets/css/owl.carousel.css">
    <link rel="stylesheet" href="../assets/css/themify-icons.css">
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/css/nice-select.css">
    <link rel="stylesheet" href="../assets/css/nouislider.min.css">
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/style.css" />
</head>

<body onload="setCoupon()">

    <!-- Start Header Area -->
    <c:import url="header.jsp" />
	<!-- End Header Area -->

    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Checkout</h1>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Checkout Area =================-->
    <section class="checkout_area section_gap">
        <div class="container">
            <div class="billing_details">
                <div class="row">
                    <div class="col-lg-7">
                        <div class="order_box">
                            <h2>Your Order</h2>
                            <ul class="list">
                                <li><a href="#">Product <span>Total</span></a></li>
                                <c:forEach var="item" items="${cartItems}">
                                    <li>
                                        <a href="#">${item.name}
                                            <span class="middle">x ${item.quantity}</span>
                                            <span class="last">EGP <fmt:formatNumber value="${(item.price/100) * item.quantity}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                            <c:choose>
                            <c:when test="${not empty coupon}">
                                <ul class="list list_2">
                                    <li><a href="#">Subtotal <span>EGP <fmt:formatNumber value="${totalPrice/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                </ul>
                                <ul class="list list_2">
                                    <li><a href="#">Discount(${coupon}) <span>EGP -<fmt:formatNumber value="${discount/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                </ul>
                                <ul class="list list_2">
                                    <li><a href="#">Total <span>EGP <fmt:formatNumber value="${newTotalPrice/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <ul class="list list_2">
                                    <li><a href="#">Total <span>EGP <fmt:formatNumber value="${totalPrice/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/></span></a></li>
                                </ul>
                            </c:otherwise>
                            </c:choose>
                            <!-- Payment options -->
                            <form action="order" method="post">
                                <input name="coupon" value="${coupon}" type="hidden" id="coVal" >
                                <button type="submit" class="primary-btn">PROCEED TO PAYMENT</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!--================End Checkout Area =================-->

    <!-- start footer Area -->
    <c:import url="footer.jsp" />
    <!-- End footer Area -->

    <script>
        function getQueryParam(param) {
            const urlParams = new URLSearchParams(window.location.search);
            return urlParams.get(param);
        }
        function setCoupon() {
            var coup = getQueryParam("coupon");
            document.getElementById("coVal").value = coup;
        }

    </script>


    <script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
    <script src="../assets/js/vendor/bootstrap.min.js"></script>
    <script src="../assets/js/jquery.ajaxchimp.min.js"></script>
    <script src="../assets/js/jquery.nice-select.min.js"></script>
    <script src="../assets/js/jquery.sticky.js"></script>
    <script src="../assets/js/nouislider.min.js"></script>
    <script src="../assets/js/jquery.magnific-popup.min.js"></script>
    <script src="../assets/js/owl.carousel.min.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="../assets/js/gmaps.min.js"></script>
    <script src="../assets/js/main.js"></script>
</body>

</html>