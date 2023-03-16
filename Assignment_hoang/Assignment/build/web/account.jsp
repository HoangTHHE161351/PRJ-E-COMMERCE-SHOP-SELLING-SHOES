<%-- 
    Document   : account
    Created on : Nov 16, 2020, 10:27:58 PM
    Author     : GearVn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("utf-8");
    request.setCharacterEncoding("utf-8");
%>
<html>
    <head>
        <title>Account Ananas</title>
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
        <!--===============================================================================================-->
    </head>
    <body>
        <header class="header trans_300" style="position: relative;">

            <!-- Main Navigation -->

            <div class="main_nav_container">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-right">
                            <div class="logo_container">
                                <a href="index">ana<span>nas</span></a>
                            </div>
                            <nav class="navbar">
                                <ul class="navbar_menu">
                                    <li><a href="index">home</a></li>
                                    <li><a href="product">shop</a></li>
                                    <li><a href="contact.jsp">contact</a></li>
                                </ul>
                                <ul class="navbar_user">
                                    <li><form action="search">
                                            <div class="search-form" style="">
                                                <input type="text" placeholder="Search" name="search" class="search-form__input" style=""/>
                                                <button type="submit" style="border: none" ><i class="fa fa-search" aria-hidden="true"></i></button>
                                            </div>
                                        </form></li>
                                    <!--                                    <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                                                                        <li class="checkout">
                                                                            <a href="#">
                                                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                                <span id="checkout_items" class="checkout_items">2</span>
                                                                            </a>
                                                                        </li>-->
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

                    <form class="login100-form validate-form" action="./changeInfo" method="post">
                        <span class="login100-form-title">
                            Change information
                        </span>
                        <%
                            if (request.getAttribute("error") != null) {
                        %>
                        <div class="text-center txt2"><%=(String) request.getAttribute("error")%></div>
                        <%
                            }
                        %>
                        <div class="wrap-input100 validate-input" data-validate = "Username is required">
                            <input class="input100" type="text" name="username" placeholder="Username" readonly value="${user.getUsername()}">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-user" aria-hidden="true"></i>
                            </span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate = "Password is required">
                            <input class="input100" type="password" name="oldPassword" placeholder="Old Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100" data-validate = "Password is required">
                            <input class="input100" type="password" name="newPassword" placeholder="New Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100" data-validate = "Password is required">
                            <input class="input100" type="password" name="reNewPassword" placeholder="Re new Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-lock" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="email" placeholder="Email" value="${user.getEmail()}">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class="fa fa-envelope" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Name is required" style="display: flex;">
                            <input class="input100" type="text" name="firstName" placeholder="First name" value="${user.getFirstName()}">
                            <div class="breadcrumb" style="background-color: #ffffff"></div>
                            <input class="input100" type="text" name="lastName" placeholder="Last name" value="${user.getLastName()}">
                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Phone number is required" style="">
                            <input class="input100" type="text" name="phone" placeholder="Phone number" value="${user.getPhoneNumber()}">

                        </div>
                        <div class="wrap-input100 validate-input" data-validate = "Address is required" style="">
                            <input class="input100" type="text" name="address" placeholder="Address" value="${user.getAddress()}">

                        </div>

                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">
                                Change
                            </button>
                        </div>



<!--                        <div class="text-center p-t-136">
                            <a class="txt2" href="login.jsp">
                                Already have Account?
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                        </div>-->
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
