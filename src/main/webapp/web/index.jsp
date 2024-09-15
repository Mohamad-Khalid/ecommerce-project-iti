<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
  <head>
    <!-- Mobile Specific Meta -->
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Favicon-->
    <link rel="shortcut icon" href="../assets/img/fav.png" />
    <!-- Author Meta -->
    <meta name="author" content="CodePixar" />
    <!-- Meta Description -->
    <meta name="description" content="" />
    <!-- Meta Keyword -->
    <meta name="keywords" content="" />
    <!-- meta character set -->
    <meta charset="UTF-8" />
    <!-- Site Title -->
    <title>Karma Shop</title>
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
    <link rel="stylesheet" href="../assets/css/style.css" />
    <style>
      .img-container {
        width: 100%;
        aspect-ratio: 1/1;
      }

      @media screen and (min-width: 1200px) {
        .img-container {
          display: flex;
          justify-content: center;
          align-items: center;
        }
      }

      /* Popup styles */
      .popup {
        display: none;
        /* Hidden by default */
        position: fixed;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        background-color: #f1c40f;
        padding: 20px;
        border: 1px solid #e67e22;
        border-radius: 5px;
        z-index: 1000;
        /* Make sure it's on top */
      }
    </style>
  </head>

  <body>
  <c:import url="header.jsp" />
    <!-- Start Header Area -->
    <!-- End Header Area -->

    <!-- start banner Area -->
    <section class="banner-area">
      <div class="container">
        <div class="row fullscreen align-items-center justify-content-start">
          <div class="col-lg-12">
            <div class="active-banner-slider owl-carousel">
              <!-- single-slide -->
              <div class="row single-slide align-items-center d-flex">
                <div class="col-lg-5 col-md-6 ">
                  <div class="banner-content">
                      <h1>Best In Class<br />And Out.</h1>
                      <h4>
                        Play, learn and create
                        <br>
                        accelerated with AI and
                        <br>NIVIDA GetForce RTX
                        <br>Laptops.
                      </h4>
                  </div>
                </div>
              </div>
              <!-- single-slide -->
            </div>
          </div>
        </div>
      </div>
      <div id="stock-error" class="popup">
       quantity out of stock!
      </div>
    </section>
    <!-- End banner Area -->

    <!-- start features Area -->
    <section class="features-area section_gap">
      <div class="container">
        <div class="row features-inner">
          <!-- single features -->
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-features">
              <div class="f-icon">
                <img src="../assets/img/features/f-icon1.png" alt="" />
              </div>
              <h6>Free Delivery</h6>
              <p>Free Shipping on all order</p>
            </div>
          </div>
          <!-- single features -->
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-features">
              <div class="f-icon">
                <img src="../assets/img/features/f-icon2.png" alt="" />
              </div>
              <h6>Return Policy</h6>
              <p>Free Shipping on all order</p>
            </div>
          </div>
          <!-- single features -->
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-features">
              <div class="f-icon">
                <img src="../assets/img/features/f-icon3.png" alt="" />
              </div>
              <h6>24/7 Support</h6>
              <p>Free Shipping on all order</p>
            </div>
          </div>
          <!-- single features -->
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-features">
              <div class="f-icon">
                <img src="../assets/img/features/f-icon4.png" alt="" />
              </div>
              <h6>Secure Payment</h6>
              <p>Free Shipping on all order</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- end features Area -->

    <!-- Start category Area -->
    <section class="category-area">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-20">
            <div class="row">
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img
                    class="img-fluid w-100"
                    src="../assets/img/category/game.jpg"
                    alt=""
                  />
                  <a
                    href="category.jsp"
                    target="_blank"
                  >
                    <div class="deal-details">
                      <h6 class="deal-title">GAMING</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img
                    class="img-fluid w-100"
                    src="../assets/img/category/work.jpg"
                    alt=""
                  />
                  <a
                    href="category.jsp"
                    target="_blank"
                  >
                    <div class="deal-details">
                      <h6 class="deal-title">WORKSTATION</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img
                    class="img-fluid w-100"
                    src="../assets/img/category/buss.jpg"
                    alt=""
                  />
                  <a
                    href="category.jsp"
                    target="_blank"
                  >
                    <div class="deal-details">
                      <h6 class="deal-title">BUSINESS</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img
                    class="img-fluid w-100"
                    src="../assets/img/category/smart2.jpg"
                    alt=""
                  />
                  <a
                    href="category.jsp"
                    target="_blank"
                  >
                    <div class="deal-details">
                      <h6 class="deal-title">SMARTBOOK</h6>
                    </div>
                  </a>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </section>
    <!-- End category Area -->

    <!-- start product Area -->
    <section class="owl-carousel active-product-area section_gap">
      <!-- single product slide -->
      <div class="single-product-slider">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
              <div class="section-title">
                <h1>Latest Products</h1>
              </div>
            </div>
          </div>
          <div class="row" id="product-container">
            <!-- single product -->
            <script>
              function addToCart(itemId, buyQuantity, action) {
                // Make the asynchronous request to the server
                $.ajax({
                  url: 'addCartItem', // Servlet URL
                  type: 'POST',
                  data: {
                    id: itemId,
                    quantity: buyQuantity
                  },
                  success: function (response) {
                    if (response.succeeded === "1") {
                      //$('#err-' + itemId).text("quantity out of stock!");
                      showStockError("Added Successfully!");
                    }
                    else {
                      showStockError("quantity out of stock!");
                    }
                  },
                  error: function () {
                    alert("Error adding item!");
                  }
                });
              }
              function showStockError(msg) {
                var popup = document.getElementById("stock-error");
                popup.innerHTML = msg;
                popup.style.display = "block"; // Show the popup

                // Hide the popup after 3 seconds (3000 milliseconds)
                setTimeout(function () {
                  popup.style.display = "none"; // Hide the popup
                }, 3000);
              }
            </script>
            <c:if test="${homeProducts != null}">
              <c:forEach items="${homeProducts}" var="current">
                <div class="col-lg-3 col-md-6">
                  <div class="single-product">
                    <div class="img-container">
                      <img class="img-fluid" src="${current.getImage()}" alt="" />
                    </div>
                    <div class="product-details">
                      <h6>${current.getName()}</h6>
                      <div class="price">
                        <h6>&pound;${current.getPrice()/100}</h6>
                      </div>
                      <div class="prd-bottom">
                        <a href="" onclick="event.preventDefault(); addToCart(${current.getId()},1);"
                          class="social-info">
                          <span class="ti-bag"></span>
                          <p class="hover-text">add to Bag</p>
                        </a>
                        <a href="" class="social-info">
                          <span class="lnr lnr-heart"></span>
                          <p class="hover-text">Wishlist</p>
                        </a>
                        <a href="/ecommerce/web/single-product.html?id=${current.getId()}" class="social-info">
                          <span class="lnr lnr-move"></span>
                          <p class="hover-text">view more</p>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </c:if>
          </div>
        </div>
      </div>

      <!-- single product slide -->
      <div class="single-product-slider">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
              <div class="section-title">
                <h1>Latest Products</h1>
              </div>
            </div>
          </div>
          <div class="row" id="product-container2">
            <!-- single product -->
            <c:if test="${homeProducts2 != null}">
              <c:forEach items="${homeProducts2}" var="current">
                <div class="col-lg-3 col-md-6">
                  <div class="single-product">
                    <div class="img-container">
                      <img class="img-fluid" src="${current.getImage()}" alt="" />
                    </div>
                    <div class="product-details">
                      <h6>${current.getName()}</h6>
                      <div class="price">
                        <h6>&pound;${current.getPrice()/100}</h6>
                      </div>
                      <div class="prd-bottom">
                        <a href="" class="social-info">
                          <span class="ti-bag"></span>
                          <p class="hover-text">add to Bag</p>
                        </a>
                        <a href="" class="social-info">
                          <span class="lnr lnr-heart"></span>
                          <p class="hover-text">Wishlist</p>
                        </a>
                        <a href="/ecommerce/web/single-product.html?id=${current.getId()}" class="social-info">
                          <span class="lnr lnr-move"></span>
                          <p class="hover-text">view more</p>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </c:if>
          </div>
        </div>
      </div>
    </section>
    <!-- end product Area -->

    <!-- Start exclusive deal Area -->
    <!-- End exclusive deal Area -->

    <!-- Start brand Area -->
    <section class="brand-area section_gap">
      <div class="container">
        <div class="row">
          <a class="col single-img" href="#">
            <img
              class="img-fluid d-block mx-auto"
              src="../assets/img/brand/acer.jpg"
              alt=""
            />
          </a>
          <a class="col single-img" href="#">
            <img
              class="img-fluid d-block mx-auto"
              src="../assets/img/brand/apple.jpg"
              alt=""
            />
          </a>
          <a class="col single-img" href="#">
            <img
              class="img-fluid d-block mx-auto"
              src="../assets/img/brand/asus.jpg"
              alt=""
            />
          </a>
          <a class="col single-img" href="#">
            <img
              class="img-fluid d-block mx-auto"
              src="../assets/img/brand/dell.jpg"
              alt=""
            />
          </a>
          <a class="col single-img" href="#">
            <img
              class="img-fluid d-block mx-auto"
              src="../assets/img/brand/lenovo.jpg"
              alt=""
            />
          </a>
        </div>
      </div>
    </section>
    <!-- End brand Area -->

    <!-- Start related-product Area -->
    <!-- End related-product Area -->

    <!-- start footer Area -->
  <c:import url="footer.jsp" />
    <!-- End footer Area -->

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
    <script src="../assets/js/countdown.js"></script>
    <script src="../assets/js/jquery.magnific-popup.min.js"></script>
    <script src="../assets/js/owl.carousel.min.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="../assets/js/gmaps.min.js"></script>
    <script src="../assets/js/main.js"></script>
  </body>
</html>
