<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Product</title>
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
                        <li class="nav-item active"><a class="nav-link" href="#">Add Product</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<section class="container section_gap">
    <div class="row">
        <div class="col-lg-6">
            <h3>Add New Product</h3>
            <form class="row login_form" action="/ecommerce/products/add" method="post" id="addProductForm" enctype="multipart/form-data">
                <!-- Product Basic Info Fields -->
                <div class="col-md-12 form-group">
                    <label for="name">Product Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Product Name" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="price">Price</label>
                    <input type="number" class="form-control" id="price" name="price" placeholder="Price" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="description">Description</label>
                    <textarea class="form-control" id="description" name="description" placeholder="Description" required></textarea>
                </div>
                <div class="col-md-12 form-group">
                    <label for="stock">Stock</label>
                    <input type="number" class="form-control" id="stock" name="stock" placeholder="Stock" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="brandName">Brand Name</label>
                    <input type="text" class="form-control" id="brandName" name="brandName" placeholder="Brand Name" required>
                </div>

                <!-- Main Image File Upload -->
                <div class="col-md-12 form-group">
                    <label for="mainImage">Upload images</label>
                    <input type="file" class="form-control" id="mainImage" name="mainImage" accept="image/*" required multiple>
                </div>

                <!-- Product Specs Fields -->
                <div class="col-md-12 form-group">
                    <label for="processor">Processor</label>
                    <input type="text" class="form-control" id="processor" name="processor" placeholder="Processor" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="memory">Memory (GB)</label>
                    <input type="number" class="form-control" id="memory" name="memory" placeholder="Memory (GB)" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="storage">Storage</label>
                    <input type="text" class="form-control" id="storage" name="storage" placeholder="Storage" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="graphicsCard">Graphics Card</label>
                    <input type="text" class="form-control" id="graphicsCard" name="graphicsCard" placeholder="Graphics Card" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="displaySize">Display Size</label>
                    <input type="text" class="form-control" id="displaySize" name="displaySize" placeholder="Display Size" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="batteryLife">Battery Life (Hours)</label>
                    <input type="number" class="form-control" id="batteryLife" name="batteryLife" placeholder="Battery Life (Hours)" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="os">Operating System</label>
                    <input type="text" class="form-control" id="os" name="os" placeholder="Operating System" required>
                </div>
                <div class="col-md-12 form-group">
                    <label for="weight">Weight (kg)</label>
                    <input type="number" class="form-control" id="weight" name="weight" placeholder="Weight (kg)" step="0.01" required>
                </div>

                <!-- Category Selection -->
                <div class="col-md-12 form-group">
                    <label for="category">Select Category</label>
                    <select class="form-control" id="category" name="category" required>
                        <option value="" disabled selected>Select Category</option>
                        <c:if test="${categoryList != null}">
                            <c:forEach items="${categoryList}" var="category">
                                <option value="${category.getId()}">${category.getName()}</option>
                            </c:forEach>
                        </c:if>
                        <!-- Add more categories dynamically if needed -->
                    </select>
                </div>
                <div class="col-md-12 form-group">
                    <button type="button" class="primary-btn" id="uploadImagesBtn">Add Product</button>
                </div>
            </form>
        </div>
    </div>
</section>

<script type="module">
    import {firebaseConfig} from "./firebase.js";
    import { initializeApp } from "https://www.gstatic.com/firebasejs/10.13.1/firebase-app.js";
    import { getStorage, ref, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/10.13.1/firebase-storage.js";

    // TODO: Add SDKs for Firebase products that you want to use

    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    // Initialize Firebase

    const app = initializeApp(firebaseConfig);

    const storage = getStorage(app);

    // Select form elements
    const imageFiles = document.getElementById('mainImage');
    const addProductForm = document.getElementById('addProductForm');

    let imageUrls = [];

    document.getElementById('uploadImagesBtn').addEventListener('click', async function () {
        const additionalImageFiles = imageFiles.files;
        let uploadPromises = [];
        for (let i = 0; i < Math.min(additionalImageFiles.length,3); i++) {
            var file = additionalImageFiles[i];
            var storageRef = ref(storage,file.name);
            const uploadPromise = uploadBytes(storageRef, file).then((snapshot) => {
                console.log('Uploaded a blob or file!');
                return getDownloadURL(snapshot.ref);
            }).then((downloadURL)=>{
                imageUrls.push(downloadURL);
            }).then(()=>{
            })
            uploadPromises.push(uploadPromise);
        }
        await Promise.all(uploadPromises);

        // After all images are uploaded, submit the form
        sendForm();
    });


    // Upload additional images


    // Handle form submission
    function sendForm() {

    if (imageUrls.length) {
    // Form data to be sent to backend
        const formData = {
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
            images: imageUrls
        };

        // Send form data to your backend
        fetch('/ecommerce/products', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
        })
        .then(response => {
            if(response.status === 201){
                console.log("success")
            }
        });
        } else {
        uploadStatus.innerHTML = '<p>Please upload all images before submitting the form.</p>';
        }
    }

</script>
<script src="../assets/js/vendor/jquery-2.2.4.min.js"></script>
<script src="../assets/js/vendor/bootstrap.min.js"></script>
<script src="../assets/js/main.js"></script>

</body>

</html>
