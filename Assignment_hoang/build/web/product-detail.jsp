<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ananas Product Detail</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
        <link rel="stylesheet" type="text/css" href="plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="styles/single_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/single_responsive.css">
        <link rel="icon" type="image/x-icon" href="images/logo.png">
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
                                        <li><a href="contact.jsp">contact</a></li>
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

            <!-- Hamburger Menu -->

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
                                <li><a href="#"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                <li><a href="#"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                            </ul>
                        </li>
                        <li class="menu_item"><a href="index.jsp">home</a></li>
                        <li class="menu_item"><a href="product.jsp">shop</a></li>
                        <li class="menu_item"><a href="contact.jsp">contact</a></li>
                    </ul>
                </div>
            </div>

            <div class="container single_product_container">
                <div class="row">
                    <div class="col">

                        <!-- Breadcrumbs -->

                        <div class="breadcrumbs d-flex flex-row align-items-center">
                            <ul>
                                <li><a href="index">Home</a></li>
                                <li><a href="product"><i class="fa fa-angle-right" aria-hidden="true"></i>Product</a></li>
                                <li class="active"><a href="product-detail?code=${product.productCode}"><i class="fa fa-angle-right" aria-hidden="true"></i>${product.productName}</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-7">
                        <div class="single_product_pics">
                            <div class="row">
                                <div class="col-lg-3 thumbnails_col order-lg-1 order-2">
                                    <div class="single_product_thumbnails">
                                        <ul>
                                            <li><img src="${product.image.image1}" alt="" data-image="${product.image.image1}"></li>
                                            <li class="active"><img src="${product.image.image2}" alt="" data-image="${product.image.image2}"></li>
                                            <li><img src="${product.image.image3}" alt="" data-image="${product.image.image3}"></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-9 image_col order-lg-2 order-1" >
                                    <div class="single_product_image">
                                        <div class="single_product_image_background" style="background-image:url(${product.image.image1})"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <div class="product_details">
                            <form action="" name="producerView" method="post">
                                <div class="product_details_title">
                                    <h2>${product.productName}</h2>
                                    <p>Mã Sản Phẩm: ${product.productCode}</p>
                                    <img src="images/test.png" width="100%" alt="alt"/>

                                </div>
                                <div class="free_delivery d-flex flex-row align-items-center justify-content-center">
                                    <span class="ti-truck"></span><span>free delivery</span>
                                </div>
                                <!--<div class="original_price">$629.99 thiếu giảm giá => nên bỏ chô này</div>-->
                                <div class="product_price">${product.price} VND</div>
                                <ul class="star_rating">
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                </ul>
                                <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                                    <span>Size: </span>


                                    <select name="size" class="form-control ml-3" style="margin-right: 50%" >
                                        <c:if test="${product.category.id == 1}">
                                            <c:forEach begin="35" end="46" var="i">
                                                <option value="${i}">${i}</option>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${product.category.id == 2}">
                                            <option  value="S">S</option>
                                            <option  value="M">M</option>
                                            <option  value="L">L</option>
                                        </c:if>

                                        <c:if test="${product.category.id != 2 && product.category.id != 1}">
                                            <option  value="Free" checked>Free Size</option>
                                        </c:if>

                                    </select>
                                </div>
                                <input type="text" name="quantity" id="quantity_submit" value="" hidden>
                                <input type="text" name="productCode" value="${product.productCode}" hidden>

                                <div class="quantity d-flex flex-column flex-sm-row align-items-sm-center">
                                    <span>Quantity:</span>
                                    <div class="quantity_selector">
                                        <span class="minus"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                        <span id="quantity_value">1</span>
                                        <!--<input type="type" name="name">-->
                                        <span class="plus"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                    </div>
                                    <div class="">
                                        <input class="red_button add_to_cart_button" style="border: none" type="submit" onclick="return add()" value="Add To Cart"> 

                                    </div>
                                    <div class="product_favorite d-flex flex-column align-items-center justify-content-center"></div>
                                    <script type="text/javascript">
                                        function add() {
                                            var quantity = document.getElementById('quantity_value').textContent;

                                            document.getElementById('quantity_submit').value = quantity;
                                            return true;

                                        }
                                    </script>
                                </div>
                        </div>
                        </form>
                    </div>
                </div>

            </div>

            <!-- Tabs -->

            <div class="tabs_section_container">

                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="tabs_container">
                                <ul class="tabs d-flex flex-sm-row flex-column align-items-left align-items-md-center justify-content-center">
                                    <li class="tab active" data-active-tab="tab_1"><span>Description</span></li>
                                    <li class="tab" data-active-tab="tab_2"><span>Additional Information</span></li>
                                    <li class="tab" data-active-tab="tab_3"><span>Reviews (2)</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">

                            <!-- Tab Description -->

                            <div id="tab_1" class="tab_container active">
                                <div class="row">
                                    <div class="col-lg-7 desc_col">
                                        <div class="tab_text_block">
                                            <h2>${product.productName}</h2>
                                            <p>${product.description}</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-5  desc_col">
                                        <div class="tab_image">
                                            <img class="rounded" src="${product.image.image1}" alt="">    <!-- thiếu ánh -->
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- Tab Additional Info -->
                            <div id="tab_2" class="tab_container">
                                <div class="row">
                                    <div class="col additional_info_col">
                                        <p>${product.detailProduct}</p>
                                    </div>
                                </div>
                            </div>
                            <!-- Tab Reviews -->

                            <div id="tab_3" class="tab_container">
                                <div class="row">
                                    <div class="col-lg-6 reviews_col">
                                        User Review 
                                        <c:forEach items="${listReview}" var="c">
                                        <div class="user_review_container d-flex flex-column flex-sm-row">
                                            <div class="user">
                                                <div class="user_pic">
                                                    <img src="" alt="alt"/>
                                                </div>
                                                <div class="user_rating">
                                                    <ul class="star_rating">
                                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                        <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="review">
                                                <div class="review_date"></div>
                                                <div class="user_name">${c.name}</div>
                                                <p>${c.content}.</p>
                                            </div>
                                        </div>
                                        </c:forEach>
                                         

                                        
                                    </div>

                                    <div class="col-lg-6 add_review_col">

                                        <div class="add_review" style="margin-top: 0">
                                            <form id="review_form" action="review" method="get">
                                                <div>
                                                    <h1>Add Review</h1>
                                                    <input type="text" name="productCode" value="${product.productCode}"  hidden>
                                                    <input id="review_name" class="form_input input_name" type="text" name="name" value="${account.fullName}" placeholder="Name*" required="required" data-error="Name is required.">
                                                    <input id="review_email" class="form_input input_email" type="email" value="${account.email}" name="email" placeholder="Email*" required="required" data-error="Valid email is required.">
                                                </div>
                                                <div>
                                                    <h1>Your Rating:</h1>
                                                    <ul class="user_star_rating">
                                                        <li><i class="fa fa-star-o" aria-hidden="true" onclick="getRate(1)"></i></li>
                                                        <li><i class="fa fa-star-o" aria-hidden="true" onclick="getRate(2)"></i></li>
                                                        <li><i class="fa fa-star-o" aria-hidden="true" onclick="getRate(3)"></i></li>
                                                        <li><i class="fa fa-star-o" aria-hidden="true" onclick="getRate(4)"></i></li>
                                                        <li><i class="fa fa-star-o" aria-hidden="true" onclick="getRate(5)"></i></li>
                                                    </ul>
                                                    <input type="text" name="rate" id="rate" value="5" hidden >
                                                    <textarea id="review_message" class="input_review" name="review"  placeholder="Your Review" rows="4" required data-error="Please, leave us a review."></textarea>
                                                </div>
                                                <div class="text-left text-sm-right">
                                                    <button id="review_submit" type="submit" class="red_button review_submit_btn trans_300" value="Submit">submit</button>
                                                </div>
                                            </form>
                                        </div>
                                        <script>
                                            function getRate(number) {
                                                document.getElementById('rate').value = number;

                                            }
                                        </script>

                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>

            <!-- Benefit -->

            <div class="benefit">
                <div class="container">
                    <div class="row benefit_row">
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-truck" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>free shipping</h6>
                                    <p>Suffered Alteration in Some Form</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-money" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>cach on delivery</h6>
                                    <p>The Internet Tend To Repeat</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-undo" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>45 days return</h6>
                                    <p>Making it Look Like Readable</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 benefit_col">
                            <div class="benefit_item d-flex flex-row align-items-center">
                                <div class="benefit_icon"><i class="fa fa-clock-o" aria-hidden="true"></i></div>
                                <div class="benefit_content">
                                    <h6>opening all week</h6>
                                    <p>8AM - 09PM</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Newsletter -->

            <div class="newsletter">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="newsletter_text d-flex flex-column justify-content-center align-items-lg-start align-items-md-center text-center">
                                <h4>Newsletter</h4>
                                <p>Subscribe to our newsletter and get 20% off your first purchase</p>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="post">
                                <div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
                                    <input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
                                    <button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Footer -->

            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="footer_nav_container d-flex flex-sm-row flex-column align-items-center justify-content-lg-start justify-content-center text-center">
                                <ul class="footer_nav">
                                    <li><a href="#">Blog</a></li>
                                    <li><a href="#">FAQs</a></li>
                                    <li><a href="contact.html">Contact us</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="footer_social d-flex flex-row align-items-center justify-content-lg-end justify-content-center">
                                <ul>
                                    <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-skype" aria-hidden="true"></i></a></li>
                                    <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer_nav_container">
                                <!--<div class="cr">Â©2018 All Rights Reserverd. This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="#">Colorlib</a></div>-->
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

        </div>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="styles/bootstrap4/popper.js"></script>
        <script src="styles/bootstrap4/bootstrap.min.js"></script>
        <script src="plugins/Isotope/isotope.pkgd.min.js"></script>
        <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
        <script src="plugins/easing/easing.js"></script>
        <script src="plugins/jquery-ui-1.12.1.custom/jquery-ui.js"></script>
        <script src="js/single_custom.js"></script>
        <script src="js/mycode.js"></script>
    </body>

</html>
