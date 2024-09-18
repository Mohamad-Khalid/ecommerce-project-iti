<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/all.css">
    <link rel="stylesheet" href="../assets/css/style.css">
</head>

<body>

<c:import url="admin-header.jsp" />
<br>
<br>
<br>
<br>
<br>
<div class="search_input" id="search_input_box" style="z-index: -1">
    <div class="container">
        <form class="d-flex justify-content-between" action="products" method="get">
            <input
                    type="text"
                    class="form-control"
                    id="search_input"
                    placeholder="Search Here"
                    name="name"
            />
            <button type="submit" class="btn"></button>
            <span
                    class="lnr lnr-cross"
                    id="close_search"
                    title="Close Search"
            ></span>
        </form>
    </div>
</div>

<section class="container section_gap">
    <span><h3 style="display: inline-block">Product List</h3> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn btn-success" onclick="window.location.href='/ecommerce/dashboard/add-product.jsp'">Add Product</button>
    </span>
    <!-- Product Table -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Category</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody id="productTableBody">
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><fmt:formatNumber value="${product.price/100}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                <td>${product.stock}</td>
                <td>${product.brandName}</td>
                <td>
                    <button class="btn btn-danger" onclick="event.stopPropagation(); confirmDelete(${product.id})">Delete</button>
                    <button class="btn btn-primary" onclick="window.location.href='/ecommerce/dashboard/update-product?id=${product.id}'">Update</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Pagination -->
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item ${page == 1 ? 'disabled' : ''}">
                <button class="page-link" onclick="redirect(${page - 1})"  aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </button>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item ${page == i ? 'active' : ''}">
                    <button class="page-link" onclick="redirect(${i})">${i}</button>
                </li>
            </c:forEach>
            <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                <button class="page-link" onclick="redirect(${page + 1})" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </button>
            </li>
        </ul>
    </nav>
</section>

<script>
    // Confirm delete action
    function confirmDelete(productId) {
        const isConfirmed = confirm("Are you sure you want to delete this product?");
        if (isConfirmed) {
            deleteProduct(productId);
        }
    }

    // Function to delete the product
    function deleteProduct(productId) {
        fetch(`/ecommerce/dashboard/delete-product?id=`+productId, {
            method: 'GET',
        }).then(response => {
            if (response.ok) {
                // If delete is successful, reload the page
                alert('Product deleted successfully');
                window.location.reload();
            } else {
                alert('Failed to delete the product');
            }
        });
    }
    function redirect(pageNum){
        const urlParams = new URLSearchParams(window.location.search);
        let name =  urlParams.get("name");
        if(name == null)window.location.href = window.location.origin + window.location.pathname + "?page="+pageNum;
        else window.location.href = window.location.origin + window.location.pathname + "?page="+pageNum+"&name="+name;
    }
</script>

<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../assets/js/vendor/bootstrap.min.js"></script>
<script src="../assets/js/main.js"></script>

</body>

</html>
