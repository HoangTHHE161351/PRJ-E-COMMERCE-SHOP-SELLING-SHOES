
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ananas</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/responsive.css">
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
                                        <c:if test="${account.role == 'admin'}">
                                            
                                            <li class="account"><a href="adminHome"><i class="fa fa-user-plus" aria-hidden="true"></i>  Admin</a></li>
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
                        <li class="menu_item"><a href="home">Home</a></li>
                        <li class="menu_item"><a href="shop">Shop</a></li>
                        <li class="menu_item"><a href="contact">contact</a></li>
                    </ul>
                </div>
            </div>

            <!-- Slider -->

            <div class="main_slider" style="background-image:url(images/slider_1.jpg)"> <!-- slider ở đầu trang -> thay url nếu muốn thay ảnh -->
                <div class="container fill_height">
                    <div class="row align-items-center fill_height">
                        <div class="col">
                            <div class="main_slider_content">
                                <h6>Spring / Summer Collection 2022</h6>
                                <h1>Get up to 30% Off New Arrivals</h1>
                                <div class="red_button shop_now_button"><a href="shop">shop now</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Banner -->

            <div class="banner">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(images/banner_1.jpg)">
                                <div class="banner_category">
                                    <a href="shop">Cho Nữ</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(images/banner_3.jpg)">
                                <div class="banner_category">
                                    <a href="shop">Cho Nam</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="banner_item align-items-center" style="background-image:url(images/banner_2.jpg)">
                                <div class="banner_category">
                                    <a href="shop">Phụ kiện</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <!-- New Arrivals -->

            <div class="new_arrivals">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>New Arrivals</h2>
                            </div>
                        </div>
                    </div>
<!--                    <div class="row align-items-center">
                        <div class="col text-center">
                            <div class="new_arrivals_sorting">-->
                                <!--                                <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">
                                                                    <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked" data-filter="*">all</li>
                                                                    <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".women">women's</li>
                                                                    <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".men">men's</li>
                                                                    <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".accessories">accessories</li>
                                                                </ul>-->
<!--                                <ul class="nav nav-pills nav-justified">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#homeShow">All</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#womenShow">Women's</a>
                                    </li>
                                                                        <li class="nav-item">
                                                                            <a class="nav-link" data-toggle="tab" href="#manShow">Man</a>
                                                                        </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#accessories">Accessories</a>
                                    </li>
                                </ul>-->
<!--                            </div>
                        </div>
                    </div>-->

                    <div class="row">
                        <div class="col">

                            <div class="tab-content">

                                <div id="homeShow" class="container tab-pane active"><br>
                                    <form action="" method="post" name="newArrival">
                                        <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
                                            <c:forEach var="p" items="${newArrival}">
                                                <div class="product-item">
                                                    <div class="product product_filter">
                                                        <div class="product_image">
                                                            <a href="product-details?code=${p.productCode}"><img src="${p.image.image1}" alt="ảnh Product"></a> 

                                                        </div>
                                                        <div class="favorite"></div>
                                                        <div class="product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center"><span>new</span></div>
                                                        <div class="product_info">
                                                            <h6 class="product_name"><a href="product-details?code=${p.productCode}">${p.productName}</a></h6>
                                                            <div class="product_price">${p.price}</div>
                                                        </div>
                                                    </div>
                                                    <div class="red_button add_to_cart_button">
                                                        <input class="red_button add_to_cart_button" style="border:none" type="submit" onclick="addToCartNewArrival('${p.productCode}')" value="Add To Cart"> 

                                                    </div>

                                                </div>  
                                            </c:forEach>
                                        </div>
                                    </form>
                                </div>

                                <div id="womenShow" class="container tab-pane fade"><br/>
                                    <form action="" name="womenForm" method="post">
                                        <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
                                            <c:forEach var="p" items="${women}">
                                                <div class="product-item">
                                                    <div class="product product_filter">
                                                        <div class="product_image">
                                                            <a href="product-details?code=${p.productCode}"><img src="${p.image.image1}" alt="ảnh Product"></a> 
                                                        </div>
                                                        <div class="favorite"></div>
                                                        <div class="product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center"><span>new</span></div>
                                                        <div class="product_info">
                                                            <h6 class="product_name"><a href="product-details?code=${p.productCode}">${p.productName}</a></h6>
                                                            <div class="product_price">${p.price}</div>
                                                        </div>
                                                    </div>
                                                    <div class="red_button add_to_cart_button">
                                                        <input class="red_button add_to_cart_button" type="submit" onclick="addToCartWomen('${p.productCode}')" value="Add To Cart"> 


                                                    </div>
                                                </div>  
                                            </c:forEach>
                                        </div>
                                    </form>
                                </div>

                                <!--                                <div id="manShow" class="container tab-pane fade">
                                                                    <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
                                <c:forEach var="p" items="${man}">
                                    <div class="product-item">
                                        <div class="product product_filter">
                                            <div class="product_image">
                                                <img src="${p.images}" alt="ảnh Product">
                                            </div>
                                            <div class="favorite"></div>
                                            <div class="product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center"><span>new</span></div>
                                            <div class="product_info">
                                                <h6 class="product_name"><a href="product-detail?productCode=${p.productCode}">${p.productName}</a></h6>
                                                <div class="product_price">${p.price}</div>
                                            </div>
                                        </div>
                                        <div class="red_button add_to_cart_button"><a href="cart?productCode=${p.productCode}">add to cart</a></div>
                                    </div>  
                                </c:forEach>
                            </div>
                        </div>-->

                                <div id="accessories" class="container tab-pane fade"><br>
                                    <form action="" method="post" name="accessories">
                                        <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
                                            <c:forEach var="p" items="${accessories}">
                                                <div class="product-item">
                                                    <div class="product product_filter">
                                                        <div class="product_image">
                                                            <a href="product-details?code=${p.productCode}"><img src="" alt="ảnh Product"></a> 
                                                        </div>
                                                        <div class="favorite"></div>
                                                        <div class="product_bubble product_bubble_left product_bubble_green d-flex flex-column align-items-center"><span>new</span></div>
                                                        <div class="product_info">
                                                            <h6 class="product_name"><a href="product-details?code=${p.productCode}">${p.productName}</a></h6>
                                                            <div class="product_price">${p.price}</div>
                                                        </div>
                                                    </div>
                                                    <div class="red_button add_to_cart_button">
                                                        <input class="red_button add_to_cart_button" type="submit" onclick="addToCartAccessories('${p.productCode}')" value="Add To Cart"> 
                                                    </div>
                                                </div>  
                                            </c:forEach>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <!-- Deal of the week -->

            <div class="deal_ofthe_week">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6">
                            <div class="deal_ofthe_week_img">
                                <img src="images/deal_ofthe_week.png" alt="">
                            </div>
                        </div>
                        <div class="col-lg-6 text-right deal_ofthe_week_col">
                            <div class="deal_ofthe_week_content d-flex flex-column align-items-center float-right">
                                <div class="section_title">
                                    <h2>Deal Of The Week</h2>
                                </div>
                                <ul class="timer">
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="day" class="timer_num">03</div>
                                        <div class="timer_unit">Day</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="hour" class="timer_num">15</div>
                                        <div class="timer_unit">Hours</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="minute" class="timer_num">45</div>
                                        <div class="timer_unit">Mins</div>
                                    </li>
                                    <li class="d-inline-flex flex-column justify-content-center align-items-center">
                                        <div id="second" class="timer_num">23</div>
                                        <div class="timer_unit">Sec</div>
                                    </li>
                                </ul>
                                <div class="red_button deal_ofthe_week_button"><a href="shop">shop now</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Best Sellers -->

            <div class="best_sellers">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title new_arrivals_title">
                                <h2>Best Sellers</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="product_slider_container">
                                <form action="" method="post" name="sellers">
                                    <div class="owl-carousel owl-theme product_slider">

                                        <!-- Slide 1 -->
                                        <c:forEach var="i" items="${bestSeller}">
                                            <div class="owl-item product_slider_item">
                                                <div class="product-item">
                                                    <div class="product discount">
                                                        <div class="product_image">
                                                            <a href="product-details?code=${i.productCode}"><img src="${i.image.image1}" alt=""></a>
                                                        </div>
                                                        <div class="favorite favorite_left"></div>
<!--                                                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>-->
                                                        <div class="product_info">
                                                            <h6 class="product_name"><a href="product-details?code=${i.productCode}">${i.productName}</a></h6>
                                                            <div class="product_price">${i.getPrice()}</span></div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="red_button add_to_cart_button">
                                                    <input class="red_button add_to_cart_button" type="submit" onclick="addToCartSellers('${p.productCode}')" value="Add To Cart"> 

                                                </div>
                                            </div>
                                        </c:forEach>


                                    </div>
                                </form>
                                <!-- Slider Navigation -->

                                <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                                </div>
                                <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                                    <i class="fa fa-chevron-right" aria-hidden="true"></i>
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

            <!-- Blogs -->

            <div class="blogs">
                <div class="container">
                    <div class="row">
                        <div class="col text-center">
                            <div class="section_title">
                                <h2>Latest Blogs</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row blogs_container">
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(images/blog_1.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(images/blog_2.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 blog_item_col">
                            <div class="blog_item">
                                <div class="blog_background" style="background-image:url(images/blog_3.jpg)"></div>
                                <div class="blog_content d-flex flex-column align-items-center justify-content-center text-center">
                                    <h4 class="blog_title">Here are the trends I see coming this fall</h4>
                                    <span class="blog_meta">by admin | dec 01, 2017</span>
                                    <a class="blog_more" href="#">Read more</a>
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
        <script src="js/custom.js"></script>
        <script src="js/mycode.js"></script>
    </body>

</html>
