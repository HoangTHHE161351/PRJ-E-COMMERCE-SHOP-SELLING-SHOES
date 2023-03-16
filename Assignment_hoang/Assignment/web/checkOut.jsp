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

        <!--===============================================================================================-->
    </head>
    <body>

        <div class="super_container">

            <!-- Header -->

            <header class="header trans_300">
                <!-- Top Navigation -->

                <div class="top_nav">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6 ">
                                <div class="top_nav_left">Free shipping với đơn hàng trên 800k</div>
                            </div>
                            <div class="col-md-6 text-right">
                                <div class="top_nav_right">
                                    <ul class="top_nav_menu">
                                        <% if (session.getAttribute("account") == null) {
                                        %>
                                        <li class="language"><a href="login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>  Sign In</a></li>
                                        <li class="account"><a href="register.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>  Register</a></li>
                                            <%
                                            } else {
                                                User u = (User) session.getAttribute("account");
                                            %>
                                        <li class="language"><a href="changeInfo"><i class="fa fa-user" aria-hidden="true"></i>  Xin chào, <%=u.getFirstName()%></a></li>
                                        <li class="account"><a href="Logout"><i class="fa fa-sign-out" aria-hidden="true"></i>  Log out</a></li>
                                            <%
                                                }
                                            %>



                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

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
                                        <li><a href="contact">contact</a></li>
                                    </ul>
                                    <ul class="navbar_user">
                                        <li><form action="search">
                                                <div class="search-form" style="">
                                                    <input type="text" placeholder="Search" name="search" class="search-form__input" style=""/>
                                                    <button type="submit" style="border: none" ><i class="fa fa-search" aria-hidden="true"></i></button>
                                                </div>
                                            </form></li>
                                        <!--<li><a href="#"><i class="fa fa-user" aria-hidden="true"></i></a></li>-->
                                        <li class="checkout">
                                            <a href="checkOut">
                                                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                <span id="checkout_items" class="checkout_items">${sessionScope.cart.getCart().size()}</span>
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
                                <li><a href="login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>  Sign In</a></li>
                                <li><a href="register.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>  Register</a></li>
                            </ul>
                        </li>
                        <li class="menu_item"><a href="index">home</a></li>
                        <li class="menu_item"><a href="product">shop</a></li>
                        <li class="menu_item"><a href="contact">contact</a></li>
                    </ul>
                </div>
            </div>
            <c:if test="${sessionScope.cart.getCart().size() == 0}">
                <p>Không có sản phẩm nào được chọn</p>                   
            </c:if>
            <c:if test="${sessionScope.cart.getCart().size() > 0}">    
                <form action="./order">
                    <div class="container-login100">
                        <div class="wrap-login100" style="width: 85%">
                            <div class="login100-pic js-tilt" data-tilt style="width: 60%">
                                <c:set var="total" value="${0}"/>

                                <c:forEach var="p" items="${sessionScope.cart.getCart()}">

                                    <div class="row" style="display: flex; width: 100%">
                                        <div class="product_image" style="width: 100px">
                                            <img src="${p.getProduct().getImages()}" style="width: 100px; height: 100px;margin-right: 10px; ">
                                        </div >
                                        <h5 class="product_name" style="width: 30%;padding-left: 20px; ">${p.getProduct().getProductName()}</h5>
                                        <div style="width: 10%">
                                            <h6>Price</h6>
                                            <div class="product_price">${p.getProduct().getPrice()}</div>
                                        </div>
                                        <div style="width: 10%">
                                            <h6> Size </h6>   
                                            <c:choose>

                                                <c:when test = "${p.getProduct().getCategoryID()==1}">
                                                    <select name="size">
                                                        <option value="36">36</option>
                                                        <option value="37">37</option>
                                                        <option value="38">38</option>
                                                        <option value="39">39</option>
                                                        <option value="40">40</option>
                                                        <option value="41">41</option>
                                                        <option value="42">42</option>

                                                    </select>
                                                </c:when>

                                                <c:when test = "${p.getProduct().getCategoryID()==2}">
                                                    <select name="size">
                                                        <option value="S">S</option>
                                                        <option value="L">L</option>
                                                        <option value="M">M</option>
                                                        

                                                    </select>
                                                </c:when>
                                                <c:otherwise>
                                                    <select name="size">
                                                        <option value="free">free</option>
                                                    </select>
                                                    
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div style="width: 10%">
                                            <h6>Quantity</h6>
                                            <button><a href="checkOut?quantity=tru&productCode=${p.getProduct().getProductCode()}">-</a></button>
                                            <b class="">${p.getQuantity()}</b>
                                            <button><a href="checkOut?quantity=cong&productCode=${p.getProduct().getProductCode()}">+</a></button>

                                        </div>
                                        <c:set var="total" value="${total + p.getQuantity()*p.getProduct().getPrice()}" />

                                    </div>
                                    <div class="breadcrumb"></div>

                                </c:forEach>
                                <h3> Total : <div>${total}</div> VNĐ</h3>
                            </div>

                            <div class="login100-form validate-form" style="width: 35%">

                                <span class="login100-form-title">
                                    Check out
                                </span>
                                <% if (session.getAttribute("account") == null) {
                                %>
                                <div class="wrap-input100 validate-input" data-validate = "Name is required" style="display: flex;">
                                    <input class="input100" type="text" name="firstName" placeholder="First name">
                                    <div class="breadcrumb" style="background-color: #ffffff"></div>
                                    <input class="input100" type="text" name="lastName" placeholder="Last name">
                                </div>
                                <div class="wrap-input100 validate-input" data-validate = "Phone number is required" style="display: flex;">
                                    <input class="input100" type="text" name="phoneNumber" placeholder="Phone number">

                                </div>
                                <div class="wrap-input100 validate-input" data-validate = "Address is required" style="display: flex;">
                                    <input class="input100" type="text" name="address" placeholder="Address">

                                </div>

                                <div class="container-login100-form-btn">
                                    <button type="submit" class="login100-form-btn">
                                        Check out
                                    </button>
                                </div>

                                <div class="text-center p-t-136">
                                    <a class="txt2" href="login.jsp">
                                        Login to check out
                                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                                    </a>
                                </div>
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
                                    <a class="txt2" href="index">
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
