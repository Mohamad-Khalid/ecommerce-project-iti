
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="../assets/css/themify-icons.css">
    <link rel="stylesheet" href="../assets/css/nice-select.css">
    <link rel="stylesheet" href="../assets/css/nouislider.min.css">
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/style.css" />
    <style>
            /* Popup styles */
            .popup {
                display: none; /* Hidden by default */
                position: fixed;
                left: 50%;
                top: 50%;
                transform: translate(-50%, -50%);
                background-color: #3C5B6F;
                padding: 20px;
                border: 1px solid #153448;
                border-radius: 5px;
                z-index: 1000; /* Make sure it's on top */
                color: white;
            }

            .cart-item {
                display: flex;
                align-items: center; /* Center the icon vertically */
            }

            .cart-item-icon {
                width: 100px;  /* Set the appropriate width */
                height: 100px; /* Keep the height proportional */
                object-fit: cover; /* Optional: maintains the aspect ratio */
                border-radius: 5px; /* Optional: gives a rounded effect */
            }

        </style>
</head>

<body onload="calculateTotalPrice();">

    <!-- Start Header Area -->
    <c:import url="header.jsp" />
	<!-- End Header Area -->

    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Shopping Cart</h1>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Cart Area =================-->
    <section class="cart_area">
        <div class="container">
            <div class="cart_inner">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Product</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Total</th>
                            </tr>
                        </thead>
                        <script>
                            function updateQuantity(itemId, action) {
                                var result = document.getElementById('sst-' + itemId);
                                var sst = result.value;

                                var inputField = $('#sst-' + itemId);
                                var currentQuantity = parseInt(inputField.val());

                                // Update the quantity value locally
                                if (action === 'increase') {
                                    if( !isNaN( sst )) currentQuantity++;
                                    else return false;
                                } else if (action === 'decrease' && currentQuantity > 1) {
                                    if( !isNaN( sst ) && sst > 1 ) currentQuantity--;
                                    else return false;
                                }
                                // Make the asynchronous request to the server
                                $.ajax({
                                    url: 'updateQuantity', // Servlet URL
                                    type: 'POST',
                                    data: {
                                        id: itemId,
                                        quantity: currentQuantity
                                    },
                                    success: function(response) {
                                        if(response.newTotal === "-1"){
                                            //$('#err-' + itemId).text("quantity out of stock!");
                                            showStockError();
                                        }
                                        else{
                                            // Update the total price on success
                                            $('#total-' + itemId).text((Number.parseFloat(response.newTotal)/100).toFixed(2) + ' EGP');
                                            // Update the input field with the new quantity
                                            inputField.val(currentQuantity);
                                            calculateTotalPrice();
                                            //$('#err-' + itemId).text("");
                                        }
                                    },
                                    error: function() {
                                        alert("Error updating quantity!");
                                    }
                                });
                            }

                            function removeItem(itemId, action) {
                                            // Make the asynchronous request to the server
                                            $.ajax({
                                                url: 'deleteCartItem', // Servlet URL
                                                type: 'POST',
                                                data: {
                                                    id: itemId
                                                },
                                                success: function(response) {
                                                    location.reload(true);
                                                },
                                                error: function() {
                                                    alert("Error removing item!");
                                                }
                                            });
                                        }

                            function calculateTotalPrice() {
                                    // Select all elements with the class 'item-price'
                                    const priceElements = document.querySelectorAll('.item-price');

                                    let totalPrice = 0;

                                    // Loop through the NodeList and sum up the price values
                                    priceElements.forEach(function(priceElement) {
                                        // Get the inner text, remove the dollar sign and convert to a float
                                        const price = parseFloat(priceElement.innerText.replace(/[$,]/g, ''));
                                        totalPrice += price; // Add to totalPrice
                                    });

                                    // Display the total price
                                    //document.getElementById('total-price').innerText = `Total Price: $`;
                                    document.getElementById('total-price').innerText = totalPrice.toFixed(2)+" EGP";
                                }
                                function showStockError() {
                                        var popup = document.getElementById("stock-error");
                                        popup.style.display = "block"; // Show the popup

                                        // Hide the popup after 3 seconds (3000 milliseconds)
                                        setTimeout(function() {
                                            popup.style.display = "none"; // Hide the popup
                                        }, 3000);
                                    }
                        </script>
                        <tbody>
                        <c:forEach var="item" items="${cartItems}">
                            <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex cart-item">
                                            <img src="${item.image}" alt="${item.name}" class="cart-item-icon">
                                        </div>
                                        <div class="media-body">
                                            <p>${item.name}</p>
                                        </div>
                                    </div>
                                    <div class="hidden-item-id" style="display:none;">
                                        <input type="hidden" value="${item.id}">
                                    </div>
                                </td>

                                <td>
                                    <h5><fmt:formatNumber value="${item.price/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/> EGP</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <input type="text" name="qty" id="sst-${item.id}" maxlength="12" value="${item.quantity}" title="Quantity:" class="input-text qty" readonly>
                                        <button onclick="updateQuantity(${item.id}, 'increase');" class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                        <button onclick="updateQuantity(${item.id}, 'decrease');" class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                    </div>
                                    <div id="stock-error" class="popup">
                                        quantity out of stock!
                                    </div>

                                </td>
                                <!--    <td>
                                    <h5 id = "err-${item.id}"></h5>
                                </td>-->
                                <td>
                                    <h5 id = "total-${item.id}" class = "item-price"><fmt:formatNumber value="${item.price/100 * item.quantity}" type="number" minFractionDigits="2" maxFractionDigits="2"/> EGP</h5>
                                </td>
                                <td>
                                    <a class="gray_btn" href="" onclick="event.preventDefault(); removeItem(${item.id});">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                            <tr class="bottom_button">
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <div class="cupon_text d-flex align-items-center">
                                        <input type="text" placeholder="Coupon Code" id="coVal">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <h5>Subtotal</h5>
                                </td>
                                <td>
                                    <h5 id = "total-price"></h5>
                                </td>
                                <td>

                                </td>
                            </tr>
                            <tr class="out_button_area">
                                <td>
                                    <c:if test = "${errorResponse!=null}">
                                        <div id="loginError" class="text-danger"><h5 class="text-danger">${errorResponse.message}</h5></div>
                                        <c:remove var="errorResponse" scope="session"/>
                                    </c:if>

                                </td>
                                <td>

                                </td>
                                <c:choose>
                                    <c:when test="${not empty cartItems}">
                                        <td>

                                        </td>
                                        <td>

                                        </td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>

                                        </td>
                                    </c:otherwise>
                                </c:choose>
                                <td>
                                    <div class="checkout_btn_inner d-flex align-items-center">
                                        <a class="gray_btn" href="index.jsp">Continue Shopping</a>
<!--                                        <a class="primary-btn" href="#">Proceed to checkout</a>-->
                                        <form action="orderDetails" method="get" id="coForm">
                                            <input type="hidden" name="coupon" id="hiddenValue">
<%--                                            <c:if test = "${errorResponse!=null}">--%>
<%--                                                <div id="loginError" class="text-danger">${errorResponse.message}</div>--%>
<%--                                                <c:remove var="errorResponse" scope="session"/>--%>
<%--                                            </c:if>--%>
<%--                                            <!--  <input type="submit" class="primary-btn" value="Proceed to checkout"></input>-->--%>
                                            <c:choose>
                                                <c:when test="${not empty cartItems}">
                                                    <button type="button" onclick="viewOrderDetails()" class="primary-btn">Proceed To Checkout</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="submit" class="gray_btn" value="Proceed to checkout" disabled>
                                                </c:otherwise>
                                            </c:choose>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>

    <script>
        // document.getElementById('coVal').addEventListener("blur", function(event) {
        //     // Get the value from the specified HTML element
        //     var valueFromDiv = document.getElementById('coVal').value;
        //     // Set it to the hidden input
        //     document.getElementById('hiddenValue').value = valueFromDiv;
        //     // alert(document.getElementById('hiddenValue').value);
        // });

        function viewOrderDetails(){
            var valueFromDiv = document.getElementById('coVal').value;
            console.log(valueFromDiv)
            window.location.href = window.location.origin + "/ecommerce/web/orderDetails?coupon=" + valueFromDiv;
        }

    </script>


    <!--================End Cart Area =================-->

    <!-- start footer Area -->
    <c:import url="footer.jsp" />
    <!-- End footer Area -->


    <script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--	 crossorigin="anonymous"></script>--%>
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