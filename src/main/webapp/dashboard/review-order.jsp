<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Mobile Specific Meta -->
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Favicon-->
    <link rel="shortcut icon" href="../assets/img/electro-logo.png" />
    <!-- Author Meta -->
    <meta name="author" content="CodePixar" />
    <!-- Meta Description -->
    <meta name="description" content="" />
    <!-- Meta Keyword -->
    <meta name="keywords" content="" />
    <!-- meta character set -->
    <meta charset="UTF-8" />
    <!-- Site Title -->
    <title>Electro</title>
    <!--
		CSS
		============================================= -->
    <link rel="stylesheet" href="../assets/css/linearicons.css" />
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
    <link rel="stylesheet" href="../assets/css/themify-icons.css" />
    <link rel="stylesheet" href="../assets/css/bootstrap.css" />
    <link rel="stylesheet" href="../assets/css/owl.carousel.css" />
    <link rel="stylesheet" href="../assets/css/nice-select.css" />
    <link rel="stylesheet" href="../assets/css/nouislider.min.css" />
    <link rel="stylesheet" href="../assets/css/ion.rangeSlider.css" />
    <link rel="stylesheet" href="../assets/css/ion.rangeSlider.skinFlat.css" />
    <link rel="stylesheet" href="../assets/css/magnific-popup.css" />
    <link rel="stylesheet" href="../assets/css/main.css" />
    <link rel="stylesheet" href="../assets/css/all.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <style>
        /* Profile Page Styling */
        .profile-container {
            padding: 50px 0;
            background-color: #f7f7f7;
        }
        .profile-header {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-picture {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin-bottom: 20px;
        }
        .profile-name {
            font-size: 24px;
            font-weight: bold;
        }

        .profile-form input,.cancel-btn  {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .profile-form label {
            font-weight: bold;
        }
        .save-btn {
            padding: 10px 20px;
            background-color: #067e46;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .cancel-btn {
            padding: 10px 20px;
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .profile-details {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<!-- Start Header Area -->
<c:import url="admin-header.jsp" />
<!-- End Header Area -->

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div
                class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end"
        >
            <div class="col-first">
                <h1>Review Customer</h1>
            </div>
        </div>
    </div>
</section>

<!-- Profile Page Content -->
<section class="order-container">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="order-header">
                    <br>
                    <h2 class="order-id">Order ID: ${order.id}</h2>
                </div>
                <!-- Order Details (Visible before editing) -->
                <div id="orderDetails" class="order-details">
                    <br>
                    <h4>Order Summary:</h4>
                    <br>
                    <p><strong id="order-date">Order Date:</strong> <span id="order-date-value">${order.date}</span></p>
                    <p><strong id="order-customer">Customer:</strong> <span id="order-customer-value">${order.customer.firstName} ${order.customer.lastName}</span></p>
                    <p><strong id="order-total-price">Total Price:</strong> <span id="order-total-price-value">${order.totalPrice}</span></p>
                    <p><strong id="order-status">Order Status:</strong> <span id="order-status-value">${order.state}</span></p>
                    <br>
                    <h4>Order Items:</h4>
                    <br>
                    <ul id="order-items-list">
                        <!-- Iterate over orderItems and display them -->
                        <c:forEach items="${order.orderItems}" var="item">
                            <li>
                                <p><strong>Product:</strong> ${item.product.name}</p>
                                <p><strong>Quantity:</strong> ${item.quantity}</p>
                                <p><strong>Price:</strong> ${item.currentPrice}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- start footer Area -->



<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"
></script>
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
