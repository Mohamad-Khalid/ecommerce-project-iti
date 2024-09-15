<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Orders List</title>
  <link rel="stylesheet" href="../assets/css/bootstrap.css">
  <link rel="stylesheet" href="../assets/css/main.css">
</head>

<body>

<header class="header_area sticky-header">
  <div class="main_menu">
    <nav class="navbar navbar-expand-lg navbar-light main_box">
      <div class="container">
        <a class="navbar-brand logo_h" href="../index.jsp"><img src="../assets/img/logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
          <ul class="nav navbar-nav menu_nav ml-auto">
            <li class="nav-item"><a class="nav-link" href="../index.jsp">Home</a></li>
            <li class="nav-item active"><a class="nav-link" href="#">View Orders</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</header>

<section class="container section_gap">
  <h3>Orders List</h3>

  <!-- Product Table -->
  <table class="table table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Customer ID</th>
      <th>Total Price</th>
      <th>Date</th>
      <th>Status</th>
    </tr>
    </thead>
    <tbody id="productTableBody">
    <c:forEach items="${orders}" var="orders">
<%--      dy httshal ???--%>
      <tr onclick="window.location.href='/ecommerce/dashboard/update-product?id=${orders.id}'" style="cursor:pointer;">
        <td>${orders.id}</td>
        <td>${orders.customer.id}</td>
        <td>${orders.totalPrice}</td>
        <td>${orders.date}</td>
        <td>${orders.state}</td>
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

