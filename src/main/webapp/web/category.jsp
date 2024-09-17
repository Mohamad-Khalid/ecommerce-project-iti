<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<style>
	.img-container{
		width: 100%;
		aspect-ratio: 1/1;
	}
	@media screen and (min-width: 1200px){
		.img-container{
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
            background-color: #3C5B6F;
            padding: 20px;
            border: 1px solid #153448;
            border-radius: 5px;
            z-index: 1000;
			color: white;
            /* Make sure it's on top */
          }
</style>
<body id="category">

	<!-- Start Header Area -->
	<c:import url="header.jsp" />
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Shop Category</h1>
				</div>
			</div>
		</div>
		<div id="stock-error" class="popup">
               quantity out of stock!
        </div>
	</section>
	<!-- End Banner Area -->
	<div class="container">
		<div class="rowF">
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-filter mt-50">
					<div class="top-filter-head">Product Filters</div>
					<div class="common-filter">
						<div class="head">Categories</div>
						<ul class="main-categories">
							<c:if test="${categoryList != null}">
								<c:forEach items="${categoryList}" var="category">
									<li class="filter-list"><input
											class="pixel-radio" type="radio" id="category-${category.getId()}"
											name="category" value="${category.getId()}">
										<label for="category-${category.getId()}">${category.getName()}</label></li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="head">Brands</div>
						<ul class="main-categories">
							<c:if test="${brandList != null}">
								<c:forEach items="${brandList}" var="brand">
									<li class="filter-list"><input
											class="pixel-radio" type="radio" id="brand-${brand}"
											name="brand" value="${brand}">
										<label for="brand-${brand}">${brand}</label></li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="head">Processors</div>
						<ul class="main-categories">
							<c:if test="${processorList != null}">
								<c:forEach items="${processorList}" var="processor">
									<li class="filter-list"><input
											class="pixel-radio" type="radio" id="processor-${processor}"
											name="processor" value="${processor}">
										<label for="processor-${processor}">${processor}</label></li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="head">Memory</div>
						<ul class="main-categories">
							<c:if test="${memoryList != null}">
								<c:forEach items="${memoryList}" var="memory">
									<li class="filter-list"><input
											class="pixel-radio" type="radio" id="memory-${memory}"
											name="memory" value="${memory}">
										<label for="memory-${memory}">${memory}</label></li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="head">Operating System</div>
						<ul class="main-categories">
							<c:if test="${osList != null}">
								<c:forEach items="${osList}" var="os">
									<li class="filter-list"><input
											class="pixel-radio" type="radio" id="os-${os}"
											name="os" value="${os}">
										<label for="os-${os}">${os}</label></li>
								</c:forEach>
							</c:if>
						</ul>
							<div class="head">Price</div>
							<div class="price-range-area">
								<div id="price-range" data-min-price="${minPrice}" data-max-price="${maxPrice}"></div>
								<div class="value-wrapper d-flex">
									<div class="price">Price:</div>
									<span>&pound;</span>
									<div id="lower-value"></div>
									<div class="to">to</div>
									<span>&pound;</span>
									<div id="upper-value"></div>
								</div>
							</div>
						<button onclick="filter()" class="click-btn btn btn-default" style="width: 100%">Search</button>

					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting mr-auto">
						<select id="selectPageSize" onchange="changeSize()">
							<option value="12">Show 12</option>
							<option value="16">Show 16</option>
							<option value="20">Show 20</option>
						</select>
					</div>
					<div class="pagination" id="pagination">
						<a href="#" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
						<a href="#" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row" id="productBox">
					</div>
				</section>
				<!-- End Best Seller -->
			</div>
		</div>
	</div>

	<!-- Start related-product Area -->
	<!-- End related-product Area -->

	<!-- start footer Area -->
	<c:import url="footer.jsp" />
	<!-- End footer Area -->

	<!-- Modal Quick Product View -->




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
	<script src="../assets/js/product-filter.js">

	</script>
</body>

</html>