<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon -->
    <link rel="shortcut icon" href="../../assets/img/electro-logo.png">
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

    <!-- CSS -->
    <link rel="stylesheet" href="../../assets/css/linearicons.css">
    <link rel="stylesheet" href="../../assets/css/owl.carousel.css">
    <link rel="stylesheet" href="../../assets/css/themify-icons.css">
    <link rel="stylesheet" href="../../assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/css/nice-select.css">
    <link rel="stylesheet" href="../../assets/css/nouislider.min.css">
    <link rel="stylesheet" href="../../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../../assets/css/main.css">
    <link rel="stylesheet" href="../../assets/css/all.css">
    <link rel="stylesheet" href="../../assets/css/style.css">
</head>

<body>

<!-- Start Header Area -->
<header class="header_area sticky-header">
    <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->

                <div class="logo-container">
                    <a class="navbar-brand logo_h" href="../index.jsp"
                    ><img src="../../assets/img/electro-logo.png" alt="" class="logo-image"
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
                            <a class="nav-link" href="../index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../category.jsp">Shop</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../contact.jsp">Contact</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="nav-item">
                            <button class="search">
                                <a href="#" class="cart"><span class="ti-bag"></span></a>
                            </button>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%--                        <li class="nav-item">--%>
                        <%--                            <a href="cart" class="cart"><span class="ti-bag"></span></a>--%>
                        <%--                        </li>--%>
                        <c:if test="${not empty sessionScope['customer-id']}">
                            <li class="nav-item">
                                <button class="search">
                                    <a href="#" class="cart"><span class="lnr fa-regular fa-user" id="search"></span></a>
                                </button>
                            </li>
                        </c:if>
                    </ul>

                </div>
            </div>
        </nav>
    </div>
</header>
<!-- End Header Area -->

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Register</h1>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!-- Start Registration Box Area -->
<section class="login_box_area section_gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="login_box_img">
                    <img class="img-fluid" src="../../assets/img/login.jpg" alt="">
                    <div class="hover">
                        <h4>Already have an account?</h4>
                        <p>Login to access your account.</p>
                        <a class="primary-btn" href="../login.html">Log In</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="login_form_inner">
                    <h3>Create an Account</h3>
                    <form class="row login_form" action="/ecommerce/web/auth/register" method="post" id="registrationForm">
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email" oninput="checkValidEmail()" required>
                            <div id="emailError" class="text-danger"></div>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password" pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,30}" title="Password must contain at least one digit, one lowercase letter, one uppercase letter, and be between 8 and 30 characters long." required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
                            <div id="confirmPasswordError" class="text-danger"></div>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="text" class="form-control" id="address" name="address" placeholder="Address" required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Phone" pattern="[0-9]{11}" title="Phone number must be 11 digits long." required>
                        </div>
                        <div class="col-md-12 form-group">
                            <input class="form-control" type="date" id="date" name="date" placeholder="Date Of Birth"
                                   max="2013-01-01" min="1900-01-01" required />
                        </div>
                        <div class="col-md-12 form-group">
                            <input class="form-control" type="text" id="job" name="job" placeholder="Job" />
                        </div>
                        <div class="col-md-12 form-group">
                            <input class="form-control" type="text" id="interests" name="interests" placeholder="Interests" />
                        </div>

                        <div class="col-md-12 form-group">
                            <div class="creat_account">
                                <input type="checkbox" id="terms" name="terms" required>
                                <label for="terms">I agree to the terms and conditions</label>
                            </div>
                        </div>
                        <div class="col-md-12 form-group">
                            <button type="submit" class="primary-btn">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Registration Box Area =================-->

<!-- Start footer Area -->
<footer class="footer-area section_gap">
    <div class="container">
        <div class="row">
            <!-- Footer content remains the same as provided -->
        </div>
        <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
            <p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="../https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </p>
        </div>
    </div>
</footer>
<!-- End footer Area -->

<script src="../../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="../../assets/js/vendor/bootstrap.min.js"></script>
<script src="../../assets/js/jquery.ajaxchimp.min.js"></script>
<script src="../../assets/js/jquery.nice-select.min.js"></script>
<script src="../../assets/js/jquery.sticky.js"></script>
<script src="../../assets/js/nouislider.min.js"></script>
<script src="../../assets/js/jquery.magnific-popup.min.js"></script>
<script src="../../assets/js/owl.carousel.min.js"></script>
<!--gmaps Js-->
<script src="../https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
<script src="../../assets/js/gmaps.min.js"></script>
<script src="../../assets/js/main.js"></script>
<script>
    var mailIsAvailable = true
    function checkValidEmail() {
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var responseText = this.responseText;
                if(responseText == "true"){
                    mailIsAvailable = true;
                    document.getElementById("emailError").innerText = "";
                }
                else {
                    mailIsAvailable = false;
                    document.getElementById("emailError").innerText = "This email is not available";

                }
            }
        };
        xhttp.open(
            "GET",
            "register?email=" + document.getElementById("email").value,
            true
        );
        xhttp.send();
    }
    $(document).ready(function () {
        // Check for password match on input
        $('#confirmPassword, #password').on('input', function () {
            checkPasswords();
        });

        // Prevent form submission if passwords don't match
        $('#registrationForm').on('submit', function (e) {
            if (!mailIsAvailable) {
                e.preventDefault();  // Prevent form submission
                alert('This email is not available.');
            }
            else if (!checkPasswords()) {
                e.preventDefault();  // Prevent form submission
                alert('Passwords do not match. Please correct it before submitting.');
            }
        });

        // Function to check if passwords match
        function checkPasswords() {
            var password = $('#password').val();
            var confirmPassword = $('#confirmPassword').val();

            if (password !== confirmPassword) {
                $('#confirmPasswordError').text('Passwords do not match');
                $('#confirmPassword').addClass('is-invalid');
                return false;
            } else {
                $('#confirmPasswordError').text('');
                $('#confirmPassword').removeClass('is-invalid');
                return true;
            }
        }
    });
</script>
</body>

</html>
