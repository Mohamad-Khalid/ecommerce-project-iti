<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Product</title>
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/main.css">

    <style>
        /* Loader container styles */
        .loader-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(255, 255, 255, 0.8);
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 1000;
            visibility: hidden; /* Initially hidden */
        }

        /* Loader (spinner) styles */
        .loader {
            border: 16px solid #f3f3f3;
            border-radius: 50%;
            border-top: 16px solid #3498db;
            width: 120px;
            height: 120px;
            animation: spin 2s linear infinite;
        }

        /* Spinner animation */
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>

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
                        <li class="nav-item active"><a class="nav-link" href="#">Update Product</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<section class="container section_gap">
    <div class="row">
        <div class="col-lg-6">/update
            <h3>Update Product</h3>
            <form class="row login_form" action="/ecommerce/products/update-product" method="post" id="updateProductForm" enctype="multipart/form-data">
                <!-- Hidden field to hold product ID -->
                <input type="hidden" name="id" value="${product.id}">

                <!-- Pre-populated Product Basic Info Fields -->
                <div class="col-md-12 form-group">
                    <label for="name">Product Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${product.name}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control" id="price" name="price" value="${product.price}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="description">Description</label>
                    <textarea class="form-control" id="description" name="description" required>${product.description}</textarea>
                </div>
                <div class="col-md-12 form-group">
                    <label for="stock">Stock</label>
                    <input type="number" class="form-control" id="stock" name="stock" value="${product.stock}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="brandName">Brand Name</label>
                    <input type="text" class="form-control" id="brandName" name="brandName" value="${product.brandName}" required>
                </div>

                <!-- Current Images Display and File Upload -->
                <div class="col-md-12 form-group">
                    <label for="mainImage">Main Image</label>
                    <input type="file" class="form-control" id="mainImage" name="mainImage" accept="image/*" multiple>
                    <c:if test="${product.images != null && !product.images.isEmpty()}">
                        <p>Current Images:</p>
                        <c:forEach items="${product.images}" var="image">
                            <img src="${image}" alt="Product Image" width="100">
                        </c:forEach>
                    </c:if>
                </div>

                <!-- Pre-populated Product Specs Fields -->
                <div class="col-md-12 form-group">
                    <label for="processor">Processor</label>
                    <input type="text" class="form-control" id="processor" name="processor" value="${product.specs.processor}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="memory">Memory (GB)</label>
                    <input type="number" class="form-control" id="memory" name="memory" value="${product.specs.memory}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="storage">Storage</label>
                    <input type="text" class="form-control" id="storage" name="storage" value="${product.specs.storage}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="graphicsCard">Graphics Card</label>
                    <input type="text" class="form-control" id="graphicsCard" name="graphicsCard" value="${product.specs.graphicsCard}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="displaySize">Display Size</label>
                    <input type="text" class="form-control" id="displaySize" name="displaySize" value="${product.specs.displaySize}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="batteryLife">Battery Life (Hours)</label>
                    <input type="number" class="form-control" id="batteryLife" name="batteryLife" value="${product.specs.batteryLife}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="os">Operating System</label>
                    <input type="text" class="form-control" id="os" name="os" value="${product.specs.os}" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="weight">Weight (kg)</label>
                    <input type="number" class="form-control" id="weight" name="weight" value="${product.specs.weight}" step="0.01" required>
                </div>

                <!-- Pre-selected Category -->
                <div class="col-md-12 form-group">
                    <label for="category">Select Category</label>
                    <select class="form-control" id="category" name="category" required>
                        <option value="" disabled>Select Category</option>
                        <c:if test="${categoryList != null}">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.getId()}" ${category.getId() == product.category.id ? 'selected' : ''}>${category.getName()}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>

                <!-- Update Button -->
                <div class="col-md-12 form-group">
                    <button type="button" class="primary-btn" id="uploadImagesBtn">Update Product</button>
                </div>
            </form>
            <div id="loader" class="loader-container">
                <div class="loader"></div>
            </div>

        </div>
    </div>
</section>

<script type="module">
    // // Firebase and form submission logic same as in Add Product page
    // const firebaseConfig = {
    //
    //     apiKey: "AIzaSyCRoIpwi89BYLoEMo4QYjckS1LrZ5LnIDk",
    //
    //     authDomain: "ecommerce-a9352.firebaseapp.com",
    //
    //     projectId: "ecommerce-a9352",
    //
    //     storageBucket: "ecommerce-a9352.appspot.com",
    //
    //     messagingSenderId: "503437469026",
    //
    //     appId: "1:503437469026:web:6ea52770eb50b4e8f4383b",
    //
    //     measurementId: "G-0ZQXGSBQ3R"
    //
    // };
    import {firebaseConfig} from "./firebase.js";
    import { initializeApp } from "https://www.gstatic.com/firebasejs/10.13.1/firebase-app.js";
    import { getStorage, ref, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/10.13.1/firebase-storage.js";

    const app = initializeApp(firebaseConfig);
    const storage = getStorage(app);
    const imageFiles = document.getElementById('mainImage');
    const updateProductForm = document.getElementById('updateProductForm');
    let imageUrls = [];

    document.getElementById('uploadImagesBtn').addEventListener('click', async function () {
        showLoader();
        const additionalImageFiles = imageFiles.files;
        let uploadPromises = [];
        for (let i = 0; i < Math.min(additionalImageFiles.length,3); i++) {
            var file = additionalImageFiles[i];
            var storageRef = ref(storage,file.name);
            const uploadPromise = uploadBytes(storageRef, file).then((snapshot) => {
                return getDownloadURL(snapshot.ref);
            }).then((downloadURL)=>{
                imageUrls.push(downloadURL);
            });
            uploadPromises.push(uploadPromise);
        }
        await Promise.all(uploadPromises);
        sendForm();
    });

    function sendForm() {
            const formData = {
                id: document.querySelector('input[name="id"]').value,
                name: document.getElementById('name').value,
                price: document.getElementById('price').value,
                description: document.getElementById('description').value,
                stock: document.getElementById('stock').value,
                brandName: document.getElementById('brandName').value,
                processor: document.getElementById('processor').value,
                memory: document.getElementById('memory').value,
                storage: document.getElementById('storage').value,
                graphicsCard: document.getElementById('graphicsCard').value,
                displaySize: document.getElementById('displaySize').value,
                batteryLife: document.getElementById('batteryLife').value,
                os: document.getElementById('os').value,
                weight: document.getElementById('weight').value,
                category: document.getElementById('category').value,
                images: imageUrls.length ? imageUrls : []
            };

            fetch('/ecommerce/dashboard/update-product', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(formData)
            }).then(response => {
                if (response.status === 201) {
                    hideLoader();
                    console.log("Product updated successfully");
                    location.reload();
                    alert("Product updated successfully")
                }
                else {
                    hideLoader();
                    alert("failed updating the order");
                }
            });

    }

</script>
<script>
    // Show the loader
    function showLoader() {
        document.getElementById('loader').style.visibility = 'visible';
    }

    // Hide the loader
    function hideLoader() {
        document.getElementById('loader').style.visibility = 'hidden';
    }

</script>
<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../assets/js/vendor/bootstrap.min.js"></script>
<script src="../assets/js/main.js"></script>

</body>

</html>
