<%-- 
    Document   : register
    Created on : Nov 3, 2020, 2:45:26 AM
    Author     : GearVn
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register Ananas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="styles/util.css">
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
        <link rel="icon" type="image/x-icon" href="images/logo.png">
        <!--===============================================================================================-->
    </head>
    <body>
        <header class="header trans_300">
                <!-- Top Navigation -->
                <c:set var="account" value="${sessionScope.account}"/>
                <div class="top_nav">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6 ">
                                <div class="top_nav_left">Free shipping với đơn hàng trên 800k</div>
                            </div>
                            <div class="col-md-6 text-right">
                                <div class="top_nav_right">
                                    <ul class="top_nav_menu">
                                        <c:if test="${account == null}">
                                            <li class="language"><a href="login"><i class="fa fa-sign-in" aria-hidden="true"></i>  Đăng Nhập</a></li>
                                            <li class="account"><a href="register"><i class="fa fa-user-plus" aria-hidden="true"></i>  Đăng Ký</a></li>
                                            </c:if>

                                        <c:if test="${account != null}">    <!-- nếu khác null thì tức là đã đăng nhập tài khoản rồi -> hiển thị như này -->
                                            <li class="language"><a href="changeInfo"><i class="fa fa-user" aria-hidden="true"></i>  Xin chào, ${account.fullName}</a></li>
                                            <li class="account"><a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>  Log out</a></li>
                                            </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Navigation -->

                <div class="main_nav_container">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12 text-right">
                                <div class="logo_container ml-5">
                                    <a href="home">ana<span>nas</span></a>
                                </div>
                                <nav class="navbar">
                                    <ul class="navbar_menu">
                                        <li><a href="home">home</a></li>
                                        <li><a href="shop">shop</a></li>
                                        <li><a href="contact">contact</a></li>
                                    </ul>
                                    <ul class="navbar_user">
                                        <li class="mr-3">
                                            <form class="form-inline" action="shop">
                                                <input class="form-control mr-sm-2" name="search" type="text" placeholder="Tìm Kiếm Sản Phẩm">
                                                <button class="btn btn-danger" type="submit">Search</button>
                                            </form></li>
                                        <!--<li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>-->


                                        <li class="checkout">
                                            <a href="cart">
                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                <span id="checkout_items" class="checkout_items">${cartSize}</span>
                                            </a>

                                        </li>
                                    </ul>
                                    <div class="hamburger_container">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>

            </header>
        <div class="limiter">
            <div class="container-login100" style="min-height: 100vh">
                <div class="wrap-login100" style="padding: 105px 130px 23px 95px ">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img style="padding-top: 45px" src="images/img-01.png" alt="IMG">
                    </div>

                    <form class="login100-form validate-form" action="register" method="post">
                        <span class="login100-form-title">
                            Register Form
                        </span>
                        <c:if test="${requestScope.errorRegister != null}">
                            <div class="text-center txt2">${requestScope.errorRegister}</div>
                        </c:if>
                        
                        <div class="wrap-input100 validate-input" data-validate = "Name is required" style="display: flex;">
                            <input class="input100" type="text" name="firstName" placeholder="First name">
                            <div class="breadcrumb" style="background-color: #ffffff"></div>
                            <input class="input100" type="text" name="lastName" placeholder="Last name">
                        </div>
                            
                        <div class="wrap-input100 validate-input" data-validate = "Username is required">
                            <input class="input100" type="text" name="userName" placeholder="Username">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Password is required">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Password is required">
                            <input class="input100" type="password" name="repassword" placeholder="Re-Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">
                                Register
                            </button>
                        </div>
                        <div class="text-center p-t-136">
                            <a class="txt2" href="login">
                                Already have Account?
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>




        <!--===============================================================================================-->	
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script >
            $('.js-tilt').tilt({
                scale: 1.1
            })
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
    </body>
</html>
