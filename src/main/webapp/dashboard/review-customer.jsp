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
<section class="profile-container">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="profile-header">
                    <h2 class="profile-name" id="profile-name">${customer.firstName} ${customer.lastName}</h2>
                </div>
                <!-- Profile Details (Visible before editing) -->
                <div id="profileDetails" class="profile-details">
                    <br>
                    <h4>About:</h4>
                    <br>
                    <p><strong id="customer-firstname">First Name:</strong> <span id="customer-firstname-value">${customer.firstName}</span></p>
                    <p><strong id="customer-lastname">Last Name:</strong> <span id="customer-lastname-value">${customer.lastName}</span></p>
                    <p><strong id="customer-email">Email:</strong> <span id="customer-email-value">${customer.email}</span></p>
                    <p><strong id="customer-address">Address:</strong> <span id="customer-address-value">${customer.address}</span></p>
                    <p><strong id="customer-phone">Phone:</strong> <span id="customer-phone-value">${customer.phone}</span></p>
                    <p><strong id="customer-date">Date Of Birth:</strong> <span id="customer-date-value">${customer.dateOfBirth}</span></p>
                    <p><strong id="customer-job">Job:</strong> <span id="customer-job-value">${customer.job}</span></p>
                    <p><strong id="customer-interests">Interests:</strong> <span id="customer-interests-value">${customer.interests}</span></p>
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
