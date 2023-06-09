<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ananas Product</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="plugins/jquery-ui-1.12.1.custom/jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="styles/categories_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/categories_responsive.css">
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
                                <li><a href="login"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                <li><a href="register"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a></li>
                            </ul>
                        </li>
                        <li class="menu_item"><a href="home">home</a></li>
                        <li class="menu_item"><a href="product">shop</a></li>
                        <li class="menu_item"><a href="contact">contact</a></li>
                    </ul>
                </div>
            </div>

            <div class="container product_section_container">
                <div class="row">
                    <div class="col product_section clearfix">
                        <div class="sidebar" style="margin-top: 20px">
                            <div class="sidebar_section">
                                <div class="sidebar_title">
                                    <h5>Product Category</h5>
                                </div>
                                <ul class="sidebar_categories">
                                    <c:forEach items="${category}" var="c">
                                        <li><a href="shop?cid=${c.id}">${c.categoryName}</a></li>
                                    </c:forEach>
                                    <li><ul class="sidebar_categories">Collection
                                            <form action="shop" method="get">
                                                
                                                <c:forEach begin="0" end="${collection.size() - 1}" var="i">
                                                    <li>&emsp;
                                                        <input type="checkbox" name="clid" value="${collection.get(i).id}" 
                                                               onclick="this.form.submit()" ${collectionCheck[i] ? 'checked' : ''}>
                                                        ${collection.get(i).getCollectionName()}</li>
                                                    </c:forEach>
                                            </form>

                                        </ul>
                                    </li>
                                </ul>
                            </div> 

                        </div>

                        <!-- Main Content -->

                        <div class="main_content" style="margin-top: 20px">

                            <!-- Products -->

                            <div class="products_iso">
                                <div class="row">
                                    <div class="col">

                                        <!-- Product Sorting -->

                                        <div class="product_sorting_container product_sorting_container_top">
                                            <ul class="product_sorting">
                                                <li>
                                                    <span class="type_sorting_text">Default Sorting</span>
                                                    <i class="fa fa-angle-down"></i>
                                                    <ul class="sorting_type">
                                                        <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'><span>Default Sorting</span></li>
                                                        <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
                                                        <li class="type_sorting_btn" data-isotope-option='{ "sortBy": "name" }'><span>Product Name</span></li>
                                                    </ul>
                                                </li>
                                                <li>
                                                    <span>Show</span>
                                                    <span class="num_sorting_text">${numProduct}</span>
                                                    <i class="fa fa-angle-down"></i>
                                                    <ul class="sorting_num">
                                                        <a href="shop?numPerPage=4${cid != null ? '&cid=' : ''}${cid != null ? cid : ''}"><li class="num_sorting_btn">4</li></a>
                                                        <a href="shop?numPerPage=8${cid != null ? '&cid=' : ''}${cid != null ? cid : ''}"><li class="num_sorting_btn">8</li></a>
                                                        <a href="shop?numPerPage=12${cid != null ? '&cid=' : ''}${cid != null ? cid : ''}"><li class="num_sorting_btn">12</li></a>
                                                    </ul>
                                                </li>
                                            </ul>
                                            <div class="pages d-flex flex-row align-items-center">
                                                <div id="next_page" class="page_next" >
                                                    <c:if test="${page > 1}">
                                                        <a href="shop?numPerPage=${numPerPage}&page=${page - 1}${collectionS != null ? "&clid=" : ""}${collectionS != null ? collectionS : ""}${cid != null ? '&cid=' : ''}${cid != null ? cid : ''}"><i  class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
                                                        </c:if>
                                                </div>

                                                <div class="page_current" style="margin-left: 30px">
                                                    <span>${page}</span>
                                                    <ul class="page_selection">
                              
                                                    </ul>
                                                </div>
                                                <div class="page_total"><span>of</span> ${numberPage}</div>
                                                <div id="next_page" class="page_next">
                                                    <c:if test="${page < numberPage}">
                                                        <a href="shop?numPerPage=${numPerPage}&page=${page + 1}${collectionS != null ? "&clid=" : ""}${collectionS != null ? collectionS : ""}${cid != null ? '&cid=' : ''}${cid != null ? cid : ''}"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>

                                                    </c:if>
                                                </div>
                                            </div>

                                        </div>

                                        <!-- Product Grid -->

                                        <div class="product-grid">

                                            <!-- Product 1 -->
                                            <c:forEach var="p" items="${listByPage}">
                                                <div class="product-item">
                                                    <div class="product discount product_filter">
                                                        <div class="product_image">
                                                            <a href="product-details?code=${p.productCode}"><img src="${p.image.image1}" alt=""></a>
                                                        </div>
                                                        <div class="favorite favorite_right"></div>
<!--                                                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>-->
                                                        <div class="product_info">
                                                            <h6 class="product_name"><a href="product-details?code=${p.getProductCode()}">${p.getProductName()}</a></h6>
                                                            <div class="product_price">${p.getPrice()}</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="red_button add_to_cart_button"><a href="cart?code=${p.getProductCode()}">add to cart</a></div>
                                            </c:forEach>
                                        </div>

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
                            <div class="newsletter_form d-flex flex-md-row flex-column flex-xs-column align-items-center justify-content-lg-end justify-content-center">
                                <input id="newsletter_email" type="email" placeholder="Your email" required="required" data-error="Valid email is required.">
                                <button id="newsletter_submit" type="submit" class="newsletter_submit_btn trans_300" value="Submit">subscribe</button>
                            </div>
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
                                    <li><a href="contact.jsp">Contact us</a></li>
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
                                <!--						<div class="cr">Â©2018 All Rights Reserverd. Template by <a href="#">Colorlib</a></div>-->
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
        <script src="js/categories_custom.js"></script>
    </body>

</html>
