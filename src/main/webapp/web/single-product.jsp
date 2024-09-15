<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="../assets/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Karma Shop</title>
	<!--
			CSS
			============================================= -->
	<link rel="stylesheet" href="../assets/css/linearicons.css">
	<link rel="stylesheet" href="../assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="../assets/css/themify-icons.css">
	<link rel="stylesheet" href="../assets/css/bootstrap.css">
	<link rel="stylesheet" href="../assets/css/owl.carousel.css">
	<link rel="stylesheet" href="../assets/css/nice-select.css">
	<link rel="stylesheet" href="../assets/css/nouislider.min.css">
	<link rel="stylesheet" href="../assets/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="../assets/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="../assets/css/main.css">
	<link rel="stylesheet" href="../assets/css/style.css" />
	<style>
		.popup {
                    display: none; /* Hidden by default */
                    position: fixed;
                    left: 50%;
                    top: 50%;
                    transform: translate(-50%, -50%);
                    background-color: #f1c40f;
                    padding: 20px;
                    border: 1px solid #e67e22;
                    border-radius: 5px;
                    z-index: 1000; /* Make sure it's on top */
                }
	</style>
</head>

<body>

<!-- Start Header Area -->
<c:import url="header.jsp" />
<!-- End Header Area -->

<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
			<div class="col-first">
				<h1>Product Details Page</h1>
				<nav class="d-flex align-items-center">
					<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
					<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
					<a href="single-product.html">product-details</a>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
						<div class="single-prd-item">
							<img class="img-fluid product-image1" src="../assets/img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid product-image2" src="../assets/img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid product-image3" src="../assets/img/category/s-p1.jpg" alt="">
						</div>

					</div>
				</div>
				<div id="stock-error" class="popup">
					quantity out of stock!
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3 id="product-name">Faded SkyBlu Denim Jeans</h3>
						<h2 id="product-price">$149.99</h2>
						<ul class="list">
							<li><a class="active" href="#"><span>Category</span> : <span id="product-category"></span></a></li>
							<li><a href="#"><span>Availibility</span> : <span id="product-stock"></span></a></li>
						</ul>
						<p id="product-description"></p>
						<div class="product_count">
							<label for="qty">Quantity:</label>
							<input type="text" name="qty" id="sst" maxlength="12" value="1" title="Quantity:" class="input-text qty">
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
									class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 1 ) result.value--;return false;"
									class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
						</div>
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn" href="#" onclick="event.preventDefault(); handleAddItem();">Add to Cart</a>
							<a class="icon_btn" href="#"><i class="lnr lnr lnr-heart"></i></a>
						</div>
					</div>
				</div>
			</div>
			<script>
				function handleAddItem(){
				var qty = document.getElementById("sst").value;
				const url = new URL(window.location.href);
				const params = new URLSearchParams(url.search);
				const id = params.get('id');
				addToCart(id,qty);
				}
			</script>

		</div>
	</div>
</div>
<!--================End Single Product Area =================-->

<!--================Product Description Area =================-->
<section class="product_description_area">
	<div class="container">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item">
				<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
				   aria-selected="false">Specification</a>
			</li>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
				<div class="table-responsive">
					<table class="table">
						<tbody>
						<tr>
							<td><h5>Brand</h5></td>
							<td><h5 id="brand-name"></h5></td>
						</tr>
						<tr>
							<td><h5>Model</h5></td>
							<td><h5 id="model-name"></h5></td>
						</tr>
						<tr>
							<td><h5>Processor</h5></td>
							<td><h5 id="processor"></h5></td>
						</tr>
						<tr>
							<td><h5>Memory</h5></td>
							<td><h5 id="memory"></h5></td>
						</tr>
						<tr>
							<td><h5>Storage</h5></td>
							<td><h5 id="storage"></h5></td>
						</tr>
						<tr>
							<td><h5>Graphics Card</h5></td>
							<td><h5 id="graphics-card"></h5></td>
						</tr>
						<tr>
							<td><h5>Display Size</h5></td>
							<td><h5 id="display-size"></h5></td>
						</tr>
						<tr>
							<td><h5>Battery Life</h5></td>
							<td><h5 id="battery-life"></h5></td>
						</tr>
						<tr>
							<td><h5>Operating System</h5></td>
							<td><h5 id="os"></h5></td>
						</tr>
						<tr>
							<td><h5>Weight</h5></td>
							<td><h5 id="weight"></h5></td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Product Description Area =================-->

<!-- Start related-product Area -->
<!-- End related-product Area -->

<!-- start footer Area -->
<c:import url="footer.jsp" />
<!-- End footer Area -->

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
<script src="../assets/js/cartHandlingFunctions.js"></script>
<script>
	$(document).ready(function(){
		const url = new URL(window.location.href);
		const params = new URLSearchParams(url.search);
		const id = params.get('id');
		$.getJSON("product"+"?id="+id, populate);

		function populate(data, status, xhr){
			if(status == "success"){

					$('#product-name').text(data.name);
					$('#product-price').text("£" + (parseFloat(data.price)).toFixed(2));
					$('#product-description').text(data.description);
					if(data.images.length>0){
						$('.product-image1').attr('src', data.images[0]);
						if(data.images.length>1){
							$('.product-image2').attr('src', data.images[1]);
						}else {
							$('.product-image2').attr('src', data.images[0]);
						}
						if(data.images.length>2){
							$('.product-image3').attr('src', data.images[2]);
						}else {
							$('.product-image3').attr('src', data.images[0]);
						}
					}


				// Populate specs
				$('#brand-name').text(data.brandName);
				$('#model-name').text(data.name);
				$('#processor').text(data.specs.processor);
				$('#memory').text(data.specs.memory + ' GB');
				$('#storage').text(data.specs.storage);
				$('#graphics-card').text(data.specs.graphicsCard);
				$('#display-size').text(data.specs.displaySize);
				$('#battery-life').text(data.specs.batteryLife + ' hours');
				$('#os').text(data.specs.os);
				$('#weight').text(data.specs.weight + ' kg');

				// Populate category and stock
				$('#product-category').text(data.category.categoryName);
				var num = data.stock;
				if(data.stock>0){
					$('product-stock').text("In Stock");
				}
				else{
					$('product-stock').text("Out Of Stock");
				}
			}
		}

	})

</script>

</body>

</html>