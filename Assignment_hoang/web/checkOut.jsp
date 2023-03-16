<%-- 
    Document   : checkOut
    Created on : Nov 11, 2020, 10:58:00 PM
    Author     : GearVn
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Check out</title>
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
        <link rel="stylesheet" type="text/css" href="styles/responsive.css">

        <link rel="stylesheet" type="text/css" href="styles/util.css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="icon" type="image/x-icon" href="images/logo.png">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="super_container">

            <!-- Header -->

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
            <div class="fs_menu_overlay"></div>
            <div class="hamburger_menu">
                <div class="hamburger_close"><i class="fa fa-times" aria-hidden="true"></i></div>
                <div class="hamburger_menu_content text-right">
                    <ul class="menu_top_nav">
                        <li class="menu_item has-children">
                            <a href="#">
                                My Account
                                <i class="fa fa-angle-down"></i>
                            </a>
                            <ul class="menu_selection">
                                <li><a href="login"><i class="fa fa-sign-in" aria-hidden="true"></i>  Sign In</a></li>
                                <li><a href="register"><i class="fa fa-user-plus" aria-hidden="true"></i>  Register</a></li>
                            </ul>
                        </li>
                        <li class="menu_item"><a href="index">home</a></li>
                        <li class="menu_item"><a href="product">shop</a></li>
                        <li class="menu_item"><a href="contact">contact</a></li>
                    </ul>
                </div>
            </div>
            <c:if test="${cartSize < 1}">
                <p>Không có sản phẩm nào được chọn</p>                   
            </c:if>
            <c:if test="${cartSize > 0}">    
                <form action="process" method="post" name="formCheckout">
                    <div class="container-login100">
                        <div class="wrap-login100" style="width: 85%">
                            <div class="login100-pic js-tilt" data-tilt style="width: 60%">

                                <c:forEach var="item" items="${cart.items}">

                                    <div class="row" style="display: flex; width: 100%">
                                        <div class="product_image" style="width: 100px">
                                            <img src="${item.product.image.image1}" style="width: 100px; height: 100px;margin-right: 10px; ">
                                        </div >
                                        <h5 class="product_name" style="font-size: 13px;width: 30%;padding-left: 20px;margin-top: 0;">${item.product.productName}</h5>
                                        <div style="width: 10%; margin-left: 1rem; margin-right: 1rem">
                                            <h6>Price</h6>
                                            <div class="product_price">${item.product.priceFormat}</div>
                                        </div>
                                        <div style="width: 10%; margin-left: 1rem; margin-right: 1rem">
                                            <h6> Size </h6>   
                                            <input type="text" name="code" id="productCode" value="${item.product.productCode}" hidden>
                                            <c:choose>
                                                <c:when test = "${item.product.category.id == 1}">
                                                    <select name="size" id="size" onchange="submitSize()">
                                                        <c:forEach begin="35" end="46" var="i">
                                                            <option value="${i}" ${item.sizeFormat == i ? 'selected' : ''}>${i}</option>
                                                        </c:forEach> 
                                                    </select>
                                                </c:when>

                                                <c:when test = "${item.product.category.id == 2}">
                                                    <select name="size" id="size" onchange="submitSize()">
                                                        <option value="S" ${item.size == 'S' ? 'selected' : ''}>S</option>
                                                        <option value="L" ${item.size == 'L' ? 'selected' : ''}>L</option>
                                                        <option value="M" ${item.size == 'M' ? 'selected' : ''}>M</option>
                                                    </select>
                                                </c:when>
                                                <c:otherwise>
                                                    <select name="size" id="size" onchange="submitSize()">
                                                        <option value="free" ${item.size == 'Free Size' ? 'selected' : ''}>Free Size</option>
                                                    </select>
                                                </c:otherwise>
                                            </c:choose>
                                            <script type="text/javascript">
                                                function  submitSize() {
                                                    var code = document.formCheckout.code.value;
                                                    var size = document.formCheckout.size.value;

                                                    document.formCheckout.action = "changeSize?code=" + code + "&size=" + size;
                                                    document.formCheckout.submit();
                                                }
                                            </script>

                                        </div>
                                        <div style="width: 10%; margin-left: 1rem; margin-right: 1rem" >
                                            <h6>Quantity</h6>
                                            <button style="margin-right: 0.3rem">
                                                <a style="font-size: 1.5rem" href="process?quantity=-1&productCode=${item.product.productCode}&size=${item.size}">-</a>
                                            </button>
                                            <b class="text-center" style="font-size: 1.5rem">${item.quantity}</b>
                                            <button style=" margin-left: 0.3rem">
                                                <a style="font-size: 1.5rem" href="process?quantity=1&productCode=${item.product.productCode}&size=${item.size}">+</a>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="breadcrumb"></div>


                                </c:forEach>
                                <h3> Total : <div>${requestScope.cart.totalMoney} VNĐ</div></h3>
                            </div>

                            <div class="login100-form validate-form" style="width: 35%">

                                <span class="login100-form-title">
                                    Check out
                                </span>
                                <% if (session.getAttribute("account") == null) {
                                %>
                                <h6 class="text-center">Đăng Nhập Để Check Out. <small><a href="login">Đăng Nhập ?</a></small></h6>
                                <%
                                } else {
                                    User user = (User) session.getAttribute("account");
                                %>
                                <div class="wrap-input100 validate-input" data-validate = "Name is required" style="display: flex;">
                                    <input class="input100" type="text" name="firstName" placeholder="First name" value="<%=user.getFirstName()%>">
                                    <div class="breadcrumb" style="background-color: #ffffff"></div>
                                    <input class="input100" type="text" name="lastName" placeholder="Last name" value="<%=user.getLastName()%>">
                                </div>
                                <div class="wrap-input100 validate-input" data-validate = "Phone number is required" style="display: flex;">
                                    <input class="input100" type="text" name="phoneNumber" placeholder="Phone number" value="<%=user.getPhoneNumber()%>">

                                </div>
                                <div class="wrap-input100 validate-input" data-validate = "Address is required" style="display: flex;">
                                    <input class="input100" type="text" name="address" placeholder="Address"value="<%=user.getAddress()%>">

                                </div>

                                <div class="container-login100-form-btn">
                                    <button type="submit" class="login100-form-btn">
                                        Check out
                                    </button>
                                </div>
                                <%
                                    }
                                %>
                                <div class="text-center p-t-136">
                                    <a class="txt2" href="shop">
                                        Continue shopping
                                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                                    </a>
                                </div> 
                            </div>
                        </div>
                    </div>
                </form>
            </c:if>
        </div>

    </div>                                            
</body>
</html>
