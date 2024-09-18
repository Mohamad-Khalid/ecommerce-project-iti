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

<section class="container section_gap">
    <br>
    <br>
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
                <a class="page-link" href="?page=${page - 1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${totalPages}" var="i">
                <li class="page-item ${page == i ? 'active' : ''}">
                    <a class="page-link" href="?page=${i}">${i}</a>
                </li>
            </c:forEach>
            <li class="page-item ${page == totalPages ? 'disabled' : ''}">
                <a class="page-link" href="?page=${page + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
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
</script>

<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../assets/js/vendor/bootstrap.min.js"></script>
<script src="../assets/js/main.js"></script>

</body>

</html>
