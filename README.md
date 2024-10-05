# Electro - A Simple E-Commerce Web Application for Laptops

## Project Overview
**Web Site:** [Electro E-Commerce](http://ec2-13-60-44-7.eu-north-1.compute.amazonaws.com:8080/ecommerce/)<br>
**Electro** is a web-based e-commerce application specifically designed for selling laptops. This project was built to evaluate and apply various web development technologies, including:

- **Client-Side Technologies**: HTML5, CSS3, JavaScript
- **Backend Technologies**: Servlets & JSP
- **Asynchronous Development**: AJAX
- **Object-Relational Mapping (ORM)**: JPA & Hibernate
- **Database**: MySQL

The project supports both administrator and user functionalities, providing a complete e-commerce solution.

---
[![Watch the Demo](https://github.com/mohab-wahdan/Electro-store-Java-ITI/blob/dev/Demo%20img.JPG)](https://youtu.be/MZokETOjzBo)
---
## Table of Contents

- [Main Features](#main-features)
  - [General Features](#general-features)
  - [Administrator Functions](#administrator-functions)
  - [User Functions](#user-functions)
- [Technologies Used](#technologies-used)
  - [Frontend](#frontend)
  - [Backend](#backend)
  - [Database](#database)
  - [Asynchronous Development](#asynchronous-development)
- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Steps](#steps)
- [Usage](#usage)
  - [Admin Panel](#admin-panel)
  - [User Panel](#user-panel)
- [Asynchronous Features](#asynchronous-features)
- [Bonus Features](#bonus-features)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Main Features

### General Features
- **Home Page**: A welcoming home page accessible to all users.
- **User Privileges**: Different pages and functionalities are available based on user roles (Admin/User).

### Administrator Functions
- **Manage Products**: View, add, edit, and remove laptop products, managing All Products Details.
- **Review Customer Profiles**: View and review all registered customer profiles.
- **Review Customer Orders**: View and review all customer Orders.
- **All Admin Pages contain Pagination for Easier browsing**

### User Functions
- **User Registration**: Sign up with profile data including name, birthday, password, job, email, credit limit, address, and interests.
- **User Login**: Sign in using email and password.
- **Edit Profile**: Update profile information at any time.
- **Browse Products**: View all available laptops.
- **Filtering Products**: Filtering all products based on their specs.
- **Shopping Cart**: Add or remove laptops from the shopping cart, update quantities, and virtually purchase items within the credit limit.
- **Purchase(Payment Gateway)**: Upon purchase, the user is redirected to a paymob payment gateway to enter his credit card credintials, upon success the order status changes to be paid.

---

## Technologies Used


### Backend
- **Java Servlets & JSP**: Core server-side logic.
- **JPA/Hibernate**: Object-Relational Mapping and connection pooling for database operations.

### Database
- **MySQL**: Stores user, product, and transaction details.

### Asynchronous Development
- **AJAX & JavaScript**: Implemented asynchronous features for enhanced user interactions.

### Frontend
- **HTML5**: Structuring the web pages.
- **CSS3**: Styling the application with a responsive, mobile-first approach.
- **JavaScript & JQuery**: Client-side validation and dynamic UI updates.

---

## Installation

### Prerequisites
- **Java JDK**: Version 8 or higher
- **Apache Tomcat**: (or any servlet container)
- **MySQL**: Database server
- **Maven**: For managing dependencies

### Steps

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/Ecommerce-ITI.git
    cd Ecommerce-ITI

    ```

2. **Configure the MySQL Database**
    - Create a new database in MySQL.
    - Update the database connection settings in `persistence.xml` or `hibernate.cfg.xml` with your database credentials.

3. **Build the Project Using Maven**
    ```bash
    mvn clean install
    ```

4. **Deploy the Project on Apache Tomcat**
    - Copy the generated `.war` file from the `target` directory to the `webapps` folder of your Tomcat installation.

5. **Access the Application**
    - Navigate to `http://localhost:8080/ecommerce` in your web browser.

---

## Usage

### Admin Panel
- **Login**: Admin logs in using predefined credentials (configured in the database).
- **Manage Products**: Admin can add, edit, or delete laptops and view customer profiles.

### User Panel
- **Sign Up & Profile Management**: New users sign up with personal information and set a credit limit.
- **View Products**: Browse available laptops and add them to the shopping cart.
- **Shopping Cart**: Manage cart items, adjust quantities, and proceed to checkout.

---

## Asynchronous Features

1. **Username Availability Check**
    - While registering, users can check if their desired username (email) is available without page refresh.

2. **Shopping Cart Updates**
    - Users can add, remove, or update product quantities in their cart asynchronously, ensuring a smooth user experience without reloading the page.

---


## Future Enhancements

- **User Reviews & Ratings**
    - Allow users to leave reviews and ratings for products.

- **Product Recommendations**
    - Implement a recommendation engine based on user interests and browsing history.

- **Email Notifications**
    - Send order confirmations and updates to users via email.

---

## Contributers

* Sayed Hassan
* Fatma Amro
* Mohab Wahdan
* Mohamed Khalid

---


## Contact

For any inquiries or support, please reach out to 
* [sayedhassan800@gmail.com](mailto:sayedhassan800@gmail.com)
* [fatmaamro34@gmail.com](mailto:fatmaamro34@gmail.com)
* [mohabmostafa78@gmail.com](mailto:mohabmostafa78@gmail.com)
* [mohamad.khalid2021@gmail.com](mailto:mohamad.khalid2021@gmail.com)
