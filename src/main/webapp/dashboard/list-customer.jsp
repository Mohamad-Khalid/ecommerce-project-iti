<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
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
                        <li class="nav-item active"><a class="nav-link" href="#">View Customers</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<section class="container section_gap">
    <h3>Customer List</h3>

    <!-- Customer Table -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number</th>
        </tr>
        </thead>
        <tbody id="customerTableBody">
        <c:forEach items="${customers}" var="customer">
            <tr onclick="window.location.href='/ecommerce/dashboard/customer?id=${customer.id}'" style="cursor:pointer;">
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.phone}</td>
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

<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../assets/js/vendor/bootstrap.min.js"></script>
<script src="../assets/js/main.js"></script>

</body>

</html>
