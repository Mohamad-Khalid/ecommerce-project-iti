<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
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
      /* Profile Page Styling */
      .profile-container {
        padding: 50px 0;
        background-color: #f7f7f7;
      }
      .profile-header {
        text-align: center;
        padding: 20px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }
      .profile-picture {
        width: 150px;
        height: 150px;
        border-radius: 50%;
        margin-bottom: 20px;
      }
      .profile-name {
        font-size: 24px;
        font-weight: bold;
      }
      .edit-profile-btn,.edit-password-btn {
        width: 170px;
        margin-top: 20px;
        padding: 10px 20px;
        border: none;
        background-color: #3C5B6F;
        color: white;
        border-radius: 5px;
        cursor: pointer;
      }
      .profile-form input,.cancel-btn  {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border-radius: 5px;
        border: 1px solid #ddd;
      }
      .profile-form label {
        font-weight: bold;
      }
      .save-btn {
        padding: 10px 20px;
        background-color: #067e46;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      .cancel-btn {
        padding: 10px 20px;
        background-color: #f44336;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
      .profile-details {
        margin-top: 10px;
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
        <div
          class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end"
        >
          <div class="col-first">
            <h1>Shop Category page</h1>
            <nav class="d-flex align-items-center">
              <a href="index.html"
                >Home<span class="lnr lnr-arrow-right"></span
              ></a>
              <a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
              <a href="category.jsp">Fashon Category</a>
            </nav>
          </div>
        </div>
      </div>
    </section>

    <!-- Profile Page Content -->
    <section class="profile-container">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 col-md-8">
            <div class="profile-header">
              <h2 class="profile-name" id="profile-name"></h2>
              <button class="edit-profile-btn" onclick="toggleEditForm()">Edit Profile</button>
              <button class="edit-password-btn" onclick="togglePasswordForm()">Change Password</button>

            </div>

            <!-- Profile Form (User Information) -->
            <form class="profile-form mt-4" id="profileForm" style="display: none" action="/ecommerce/web/profile" method="post">
              <label for="firstName">First Name</label>
              <input type="text" id="firstName" name="firstName" required/>

              <label for="lastName">Last Name</label>
              <input type="text" id="lastName" name="lastName" required/>

              <label for="email">Email</label>
              <input type="email" id="email" name="email" onblur="checkValidEmail()" required />
              <div id="emailError" class="text-danger"></div>

              <label for="address">Address</label>
              <input type="text" id="address" name="address" required />

              <label for="phone">Phone</label>
              <input type="tel" id="phone" pattern="[0-9]{11}" name="phone" required />

              <label for="date">Date Of Birth</label>
              <input type="date" id="date" name="date" max="2013-01-01" min="1900-01-01" required />

              <label for="job">Job</label>
              <input type="text" id="job" name="job" />

              <label for="interests">Interests</label>
              <input type="text" id="interests" name="interests" />

              <input type="submit" class="save-btn" value="Save Changes" />
              <button type="button" class="cancel-btn" onclick="toggleEditForm()">Cancel</button>
            </form>

            <!-- Password Form -->
            <form class="profile-form mt-4" id="passwordForm" style="display: none" action="/ecommerce/web/update-password" method="post">
              <label for="password">New Password</label>
              <input
                      type="password"
                      id="password"
                      placeholder="Enter new password"
                      pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,30}"
                      name="password"
                      required
              />
              <label for="confirmPassword">Confirm Password</label>
              <input
                      type="password"
                      id="confirmPassword"
                      placeholder="Enter password confirmation"
                      required
              />
              <div id="confirmPasswordError" class="text-danger"></div>

              <input type="submit" class="save-btn" value="Change Password" />
              <button type="button" class="cancel-btn" onclick="toggleEditForm()">Cancel</button>
            </form>

            <!-- Profile Details (Visible before editing) -->
            <div id="profileDetails" class="profile-details">
              <h4>About</h4>
              <p><strong id="customer-firstname">First Name:</strong> <span id="customer-firstname-value"></span></p>
              <p><strong id="customer-lastname">Last Name:</strong> <span id="customer-lastname-value"></span></p>
              <p><strong id="customer-email">Email:</strong> <span id="customer-email-value"></span></p>
              <p><strong id="customer-address">Address:</strong> <span id="customer-address-value"></span></p>
              <p><strong id="customer-phone">Phone:</strong> <span id="customer-phone-value"></span></p>
              <p><strong id="customer-date">Date Of Birth:</strong> <span id="customer-date-value"></span></p>
              <p><strong id="customer-job">Job:</strong> <span id="customer-job-value"></span></p>
              <p><strong id="customer-interests">Interests:</strong> <span id="customer-interests-value"></span></p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- start footer Area -->
    <c:import url="footer.jsp" />

    <script>
      function toggleEditForm() {
        const form = document.getElementById("profileForm");
        const details = document.getElementById("profileDetails");
        form.style.display = form.style.display === "none" ? "block" : "none";
        details.style.display =
          details.style.display === "none" ? "block" : "none";
      }
    </script>
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
    <script src="../assets/js/jquery.magnific-popup.min.js"></script>
    <script src="../assets/js/owl.carousel.min.js"></script>
    <!--gmaps Js-->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
    <script src="../assets/js/gmaps.min.js"></script>
    <script src="../assets/js/main.js"></script>
    <script>
      $(document).ready(function(){
        $.getJSON("profile", populate);

        function populate(data, status, xhr) {
          if (status == "success") {
            // Populate customer information
            $('#profile-name').text(data.firstName + " " + data.lastName);

            $('#customer-firstname-value').text(data.firstName);
            $('#firstName').val(data.firstName);

            $('#customer-lastname-value').text(data.lastName);
            $('#lastName').val(data.lastName);

            $('#customer-email-value').text(data.email);
            $('#email').val(data.email);

            $('#customer-address-value').text(data.address);
            $('#address').val(data.address);

            $('#customer-phone-value').text(data.phone);
            $('#phone').val(data.phone);

            $('#customer-date-value').text(data.dateOfBirth);
            let date = new Date(data.dateOfBirth);
            date.setMinutes(date.getMinutes() - date.getTimezoneOffset());
            let formattedDate = date.toISOString().split('T')[0]; // Get the YYYY-MM-DD format
            $('#date').val(formattedDate);

            $('#customer-job-value').text(data.job);
            $('#job').val(data.job);

            $('#customer-interests-value').text(data.interests);
            $('#interests').val(data.interests);
          }
        }

      })

    </script>

    <script>
      var mailIsAvailable = true
      function checkValidEmail() {
        const xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
          if (this.readyState == 4 && this.status == 200) {
            var responseText = this.responseText;
            if(responseText == "true"){
              mailIsAvailable = true;
              document.getElementById("emailError").innerText = "";
            }
            else {
              mailIsAvailable = false;
              document.getElementById("emailError").innerText = "This email is not available";

            }
          }
        };
        xhttp.open(
                "GET",
                "check-email?email=" + document.getElementById("email").value,
                true
        );
        xhttp.send();
      }

      $(document).ready(function () {
        // Check for password match on input
        $('#confirmPassword, #password').on('input', function () {
          checkPasswords();
        });

        // Prevent form submission if passwords don't match
        $('#profileForm').on('submit', function (e) {
          if (!mailIsAvailable) {
            e.preventDefault();  // Prevent form submission
            alert('This email is not available.');
          }
        });

        $('#passwordForm').on('submit', function (e) {
          if (!checkPasswords()) {
            e.preventDefault();  // Prevent form submission
            alert('Passwords do not match. Please correct it before submitting.');
          }
        });
        // Function to check if passwords match
        function checkPasswords() {
          var password = $('#password').val();
          var confirmPassword = $('#confirmPassword').val();

          if (password !== confirmPassword) {
            $('#confirmPasswordError').text('Passwords do not match');
            $('#confirmPassword').addClass('is-invalid');
            return false;
          } else {
            $('#confirmPasswordError').text('');
            $('#confirmPassword').removeClass('is-invalid');
            return true;
          }
        }
      });
      function toggleEditForm() {
        const profileForm = document.getElementById("profileForm");
        const passwordForm = document.getElementById("passwordForm");
        const details = document.getElementById("profileDetails");

        profileForm.style.display = profileForm.style.display === "none" ? "block" : "none";
        passwordForm.style.display = "none"; // Hide password form when editing profile
        details.style.display = details.style.display === "none" ? "block" : "none";
      }

      function togglePasswordForm() {
        const profileForm = document.getElementById("profileForm");
        const passwordForm = document.getElementById("passwordForm");
        const details = document.getElementById("profileDetails");

        passwordForm.style.display = passwordForm.style.display === "none" ? "block" : "none";
        profileForm.style.display = "none"; // Hide profile form when editing password
        details.style.display = "none"; // Hide details when editing password
      }
    </script>
  </body>
</html>
