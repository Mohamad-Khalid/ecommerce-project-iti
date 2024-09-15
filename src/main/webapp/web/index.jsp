<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!DOCTYPE html>
  <html lang="zxx" class="no-js">

  <head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
    <!-- Start Header Area -->
    <header class="header_area sticky-header">
      <div class="main_menu">
        <nav class="navbar navbar-expand-lg navbar-light main_box">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->

            <div class="logo-container">
              <a class="navbar-brand logo_h" href="index.jsp"><img src="../assets/img/electro-logo.png" alt=""
                  class="logo-image" /></a>
            </div>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
              <ul class="nav navbar-nav menu_nav ml-auto">
                <li class="nav-item active">
                  <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item submenu dropdown">
                  <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                    aria-expanded="false">Shop</a>
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="category.jsp">Shop Category</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="single-product.html">Product Details</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="checkout.jsp">Product Checkout</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="cart">Shopping Cart</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="confirmation.html">Confirmation</a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item submenu dropdown">
                  <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                    aria-expanded="false">Pages</a>
                  <ul class="dropdown-menu">
                    <li class="nav-item">
                      <a class="nav-link" href="login.html">Login</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="tracking.html">Tracking</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="elements.html">Elements</a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="contact.html">Contact</a>
                </li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li class="nav-item">
                  <a href="#" class="cart"><span class="ti-bag"></span></a>
                </li>
                <li class="nav-item">
                  <button class="search">
                    <span class="lnr lnr-magnifier" id="search"></span>
                  </button>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </div>
      <div class="search_input" id="search_input_box">
        <div class="container">
          <form class="d-flex justify-content-between">
            <input type="text" class="form-control" id="search_input" placeholder="Search Here" />
            <button type="submit" class="btn"></button>
            <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
          </form>
        </div>
      </div>
    </header>
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
                  <img class="img-fluid w-100" src="../assets/img/category/game.jpg" alt="" />
                  <a href="../assets/img/category/c1.jpg" class="img-pop-up" target="_blank">
                    <div class="deal-details">
                      <h6 class="deal-title">GAMING</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img class="img-fluid w-100" src="../assets/img/category/work.jpg" alt="" />
                  <a href="../assets/img/category/c2.jpg" class="img-pop-up" target="_blank">
                    <div class="deal-details">
                      <h6 class="deal-title">WORKSTATION</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img class="img-fluid w-100" src="../assets/img/category/buss.jpg" alt="" />
                  <a href="../assets/img/category/c3.jpg" class="img-pop-up" target="_blank">
                    <div class="deal-details">
                      <h6 class="deal-title">BUSINESS</h6>
                    </div>
                  </a>
                </div>
              </div>
              <div class="col-lg-3">
                <div class="single-deal">
                  <div class="overlay"></div>
                  <img class="img-fluid w-100" src="../assets/img/category/smart2.jpg" alt="" />
                  <a href="../assets/img/category/c4.jpg" class="img-pop-up" target="_blank">
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
                  }, error: function(response) {
                    if(response.status == 401){
                      window.location.href = window.location.origin + "/ecommerce/web/auth/login.jsp"
                    }
                    else{
                      alert("Error adding item!");
                    }

                         },
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
            <img class="img-fluid d-block mx-auto" src="../assets/img/brand/acer.jpg" alt="" />
          </a>
          <a class="col single-img" href="#">
            <img class="img-fluid d-block mx-auto" src="../assets/img/brand/apple.jpg" alt="" />
          </a>
          <a class="col single-img" href="#">
            <img class="img-fluid d-block mx-auto" src="../assets/img/brand/asus.jpg" alt="" />
          </a>
          <a class="col single-img" href="#">
            <img class="img-fluid d-block mx-auto" src="../assets/img/brand/dell.jpg" alt="" />
          </a>
          <a class="col single-img" href="#">
            <img class="img-fluid d-block mx-auto" src="../assets/img/brand/lenovo.jpg" alt="" />
          </a>
        </div>
      </div>
    </section>
    <!-- End brand Area -->

    <!-- Start related-product Area -->
    <!-- End related-product Area -->

    <!-- start footer Area -->
    <footer class="footer-area section_gap">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-footer-widget">
              <h6>About Us</h6>
              <p>
                Welcome to Electro Laptops, your number one source for the latest and greatest in laptop technology.
                Founded in 2015, we have dedicated ourselves to providing the best laptops and accessories to tech
                enthusiasts and professionals alike.
              </p>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 col-sm-6">
            <div class="single-footer-widget">
              <h6>Newsletter</h6>
              <p>Stay update with our latest</p>
              <div class="" id="mc_embed_signup">
                <form target="_blank" novalidate="novalidate"
                  action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                  method="get" class="form-inline">
                  <div class="d-flex flex-row">
                    <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''"
                      onblur="this.placeholder = 'Enter Email '" required="" type="email" />

                    <button class="click-btn btn btn-default">
                      <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                    </button>
                    <div style="position: absolute; left: -5000px">
                      <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text" />
                    </div>

                    <!-- <div class="col-lg-4 col-md-4">
												<button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
											</div>  -->
                  </div>
                  <div class="info"></div>
                </form>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 col-sm-6">
            <div class="single-footer-widget mail-chimp">
              <h6 class="mb-20">Instragram Feed</h6>
              <ul class="instafeed d-flex flex-wrap">
                <li><img src="../assets/img/i1.jpg" alt="" /></li>
                <li><img src="../assets/img/i2.jpg" alt="" /></li>
                <li><img src="../assets/img/i3.jpg" alt="" /></li>
                <li><img src="../assets/img/i4.jpg" alt="" /></li>
                <li><img src="../assets/img/i5.jpg" alt="" /></li>
                <li><img src="../assets/img/i6.jpg" alt="" /></li>
                <li><img src="../assets/img/i7.jpg" alt="" /></li>
                <li><img src="../assets/img/i8.jpg" alt="" /></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-2 col-md-6 col-sm-6">
            <div class="single-footer-widget">
              <h6>Follow Us</h6>
              <p>Let us be social</p>
              <div class="footer-social d-flex align-items-center">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
                <a href="#"><i class="fa fa-behance"></i></a>
              </div>
            </div>
          </div>
        </div>
        <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
          <p class="footer-text m-0">
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;
            <script>
              document.write(new Date().getFullYear());
            </script>
            All rights reserved | This template is made with
            <i class="fa fa-heart-o" aria-hidden="true"></i> by
            <a href="https://colorlib.com" target="_blank">Colorlib</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </p>
        </div>
      </div>
    </footer>
    <!-- End footer Area -->

    <script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
      integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
      crossorigin="anonymous"></script>
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