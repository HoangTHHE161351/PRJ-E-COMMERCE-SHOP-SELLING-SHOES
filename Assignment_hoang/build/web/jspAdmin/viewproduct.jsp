<%-- 
    Document   : viewproduct
    Created on : Oct 28, 2022, 10:54:25 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">


    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
        <link href="assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/libs/css/style.css">
        <link rel="stylesheet" href="assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="icon" type="image/x-icon" href="images/logo.png">
        <title>View Product</title>
        <style>
            h4,* {
                font-family: initial;
            }


        </style>
    </head>

    <body>
       <!-- ============================================================== -->
        <!-- main wrapper -->
        <!-- ============================================================== -->
        <div class="dashboard-main-wrapper">
             <!-- ============================================================== -->
            <!-- navbar -->
            <!-- ============================================================== -->
            <div class="dashboard-header">
                <nav class="navbar navbar-expand-lg bg-white fixed-top">
                    <a class="card-header text-center"><a href="adminHome"><img class="logo-img" src="images/logo.admin.png" alt="logo"></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse " id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto navbar-right-top">
                                <li class="nav-item">
                                    <div id="custom-search" class="top-search-bar">
                                        <input class="form-control" type="text" placeholder="Search..">
                                    </div>
                                </li>
                                <li class="nav-item dropdown notification">
                                    <a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-bell"></i> <span class="indicator"></span></a>
                                    <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                                        <li>
                                            <div class="notification-title"> Notification</div>
                                            <div class="notification-list">
                                                <div class="list-group">
                                                    <a href="#" class="list-group-item list-group-item-action active">
                                                        <div class="notification-info">
                                                            <div class="notification-list-user-img"><img src="assets/images/avatar-2.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                            <div class="notification-list-user-block"><span class="notification-list-user-name">Jeremy Rakestraw</span>accepted your invitation to join the team.
                                                                <div class="notification-date">2 min ago</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a href="#" class="list-group-item list-group-item-action">
                                                        <div class="notification-info">
                                                            <div class="notification-list-user-img"><img src="assets/images/avatar-3.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                            <div class="notification-list-user-block"><span class="notification-list-user-name">John Abraham </span>is now following you
                                                                <div class="notification-date">2 days ago</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a href="#" class="list-group-item list-group-item-action">
                                                        <div class="notification-info">
                                                            <div class="notification-list-user-img"><img src="assets/images/avatar-4.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                            <div class="notification-list-user-block"><span class="notification-list-user-name">Monaan Pechi</span> is watching your main repository
                                                                <div class="notification-date">2 min ago</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                    <a href="#" class="list-group-item list-group-item-action">
                                                        <div class="notification-info">
                                                            <div class="notification-list-user-img"><img src="assets/images/avatar-5.jpg" alt="" class="user-avatar-md rounded-circle"></div>
                                                            <div class="notification-list-user-block"><span class="notification-list-user-name">Jessica Caruso</span>accepted your invitation to join the team.
                                                                <div class="notification-date">2 min ago</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="list-footer"> <a href="#">View all notifications</a></div>
                                        </li>
                                    </ul>
                                </li>
                                
                                <li class="nav-item dropdown nav-user">
                                    <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="images/logo.png" alt="" class="user-avatar-md rounded-circle"></a>
                                    <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                                        <div class="nav-user-info">
                                            <h6 class="mb-0 text-white nav-user-name">Admin </h6>
<!--                                            <span class="status"></span><span class="ml-2">Admin</span>-->
                                        </div>
                                        <a class="dropdown-item" href="adminProfile"><i class="fas fa-user mr-2"></i>Account</a>
                                        <a class="dropdown-item" href="changepass"><i class="fas fa-address-card"></i>     Change password</a>
                                        <a class="dropdown-item" href="add profile.html"><i class="fas fa-cog mr-2"></i>Setting</a>
                                        <a class="dropdown-item" href="home"><i class="fas fa-power-off mr-2"></i>Logout</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                </nav>
            </div>
            <!-- ============================================================== -->
            <!-- end navbar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- left sidebar -->
            <!-- ============================================================== -->
            <div class="nav-left-sidebar sidebar-dark">
                <div class="menu-list">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav flex-column">
                                <li class="nav-divider">
                                    Menu
                                </li>
                                <li class="nav-item ">
                                    <a class="nav-link active" href="adminProfile" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fa fa-fw fa-user-circle"></i>Dashboard <span class=""></span></a>
                                </li>


                                <li class="nav-item ">
                                    <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-4" aria-controls="submenu-4"><i class="fab fa-fw fa-wpforms"></i>Managerment</a>
                                    <div id="submenu-4" class="collapse submenu" style="">
                                        <ul class="nav flex-column">
                                            <li class="nav-item">
                                                <a class="nav-link" href="adminAddProduct">Add Product</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="adminProfile">Profile</a>
                                            </li>
                                            
                                        </ul>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-5" aria-controls="submenu-5"><i class="fas fa-shopping-cart"></i>Products</a>
                                    <div id="submenu-5" class="collapse submenu" style="">
                                        <ul class="nav flex-column">

                                            <li class="nav-item">
                                                <a class="nav-link" href="adminProduct">Data Products</a>
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end left sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- wrapper  -->
            <!-- ============================================================== -->
            <div class="dashboard-wrapper">
                <div class="dashboard-ecommerce">
                    <div class="container-fluid dashboard-content ">
                        <!-- ============================================================== -->
                        <!-- pageheader  -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="page-header">
                                    <h2 class="pageheader-title">E-commerce Product Single </h2>
                                    <p class="pageheader-text">Nulla euismod urna eros, sit amet scelerisque torton lectus vel mauris facilisis faucibus at enim quis massa lobortis rutrum.</p>
                                    <div class="page-breadcrumb">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Product Tables</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">View Product</li>
                                            </ol>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ============================================================== -->
                        <!-- end pageheader  -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <div class=" col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="row">
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 pr-xl-0 pr-lg-0 pr-md-0  m-b-30">
                                        <div class="product-slider">
                                            <div id="productslider-1" class="product-carousel carousel slide" data-ride="carousel">
                                                <ol class="carousel-indicators">
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                                </ol>
                                                <div class="carousel-inner">
                                                    <div class="carousel-item active">
                                                        <img width="100%" class="d-block" src="${product.image.image1}" alt="First slide">
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img width="100%" class="d-block" src="${product.image.image2}" alt="Second slide">
                                                    </div>
                                                    <div class="carousel-item">
                                                        <img width="100%" class="d-block" src="${product.image.image3}" alt="Third slide">
                                                    </div>
                                                </div>
                                                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                                    <span class="sr-only">Previous</span>
                                                </a>
                                                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                                    <span class="sr-only">Next</span>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 pl-xl-0 pl-lg-0 pl-md-0 border-left m-b-30">
                                        <div class="product-details">
                                            <div class="border-bottom pb-3 mb-3">
                                                <h2 class="mb-3">${product.productName}</h2>
                                                <!--                                            <div class="product-rating d-inline-block float-right">
                                                                                                <i class="fa fa-fw fa-star"></i>
                                                                                                <i class="fa fa-fw fa-star"></i>
                                                                                                <i class="fa fa-fw fa-star"></i>
                                                                                                <i class="fa fa-fw fa-star"></i>
                                                                                                <i class="fa fa-fw fa-star"></i>
                                                                                            </div>-->
                                                <h3 class="mb-0 text-success">${product.priceFormat} VND</h3>
                                            </div>
                                            <div class="product-colors border-bottom">
                                                <h4>Mã Sản Phẩm: ${product.productCode}</h4>
                                            </div>
                                            <div class="product-size border-bottom">
                                                <h4>Size</h4>
                                                <div class="btn-group" role="group" aria-label="First group">
                                                    <c:if test="${product.category.id == 1}">
                                                        <button type="button" class="btn btn-outline-light">35</button>
                                                        <button type="button" class="btn btn-outline-light">36</button>
                                                        <button type="button" class="btn btn-outline-light">37</button>
                                                        <button type="button" class="btn btn-outline-light">38</button>
                                                    </c:if> 

                                                    <c:if test="${product.category.id == 2}">
                                                        <button type="button" class="btn btn-outline-light">S</button>
                                                        <button type="button" class="btn btn-outline-light">M</button>
                                                        <button type="button" class="btn btn-outline-light">L</button>
                                                    </c:if> 

                                                    <c:if test="${product.category.id != 2 && product.category.id != 1}">
                                                        <button type="button" class="btn btn-outline-light">Free Style</button>

                                                    </c:if> 

                                                </div>
                                                <div class="product-qty">
                                                    <h4>Quantity: ${product.quantity}</h4>
                                                    <h4>Status: ${product.status}</h4>
                                                </div>
                                            </div>
                                            <div class="product-description">
                                                <h4 class="mb-1">Descriptions</h4>
                                                <p>${product.description}</p>
                                                <a href="adminEditProduct?code=${product.productCode}" class="btn btn-primary btn-block btn-lg">Chỉnh Sửa</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 m-b-60">
                                        <div class="simple-card">
                                            <ul class="nav nav-tabs" id="myTab5" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link active border-left-0" id="product-tab-1" data-toggle="tab" href="#tab-1" role="tab" aria-controls="product-tab-1" aria-selected="true">Descriptions</a>
                                                </li>

                                            </ul>
                                            <div class="tab-content" id="myTabContent5">
                                                <div class="tab-pane fade show active" id="tab-1" role="tabpanel" aria-labelledby="product-tab-1">
                                                    <p>${product.detailProduct}</p>

                                                    <ul class="list-unstyled arrow">
                                                        <li>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</li>
                                                        <li>Donec ut elit sodales, dignissim elit et, sollicitudin nulla.</li>
                                                        <li>Donec at leo sed nisl vestibulum fermentum.
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <jsp:useBean id="cd" class="dal.ProductDAO"/>                    
                                <div class="row">
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 m-b-10">
                                        <h3> Related Products</h3>
                                    </div>
                                    <c:set var="listByCate" value="${cd.getProductByCategoryID(product.category.id)}"/>
                                    <c:forEach begin="0" end="2" var="i">
                                        <div class="col-xl-4 col-lg-6 col-md-12 col-sm-12 col-12">
                                            <div class="product-thumbnail">
                                                <div class="product-img-head">
                                                    <div class="product-img">
                                                        <img src="${listByCate.get(i).image.image1}" alt="" class="img-fluid"></div>
                                                    <div class="ribbons">New</div>
                                                    
                                                </div>
                                                <div class="product-content">
                                                    <div class="product-content-head">
                                                        <h3 class="product-title">${listByCate.get(i).productName}</h3>
                                                        
                                                        
                                                    </div>
                                                        <div class="">${listByCate.get(i).priceFormat} đ</div>
                                                    <div class="product-btn mt-1">
                                                        <a href="adminViewProduct?code=${listByCate.get(i).productCode}" class="btn btn-primary">View</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <!-- ============================================================== -->
                <!-- end wrapper  -->
                <!-- ============================================================== -->
            </div>

        </div>
        <!-- ============================================================== -->
        <!-- end main wrapper  -->
        <!-- ============================================================== -->
        <!-- Optional JavaScript -->
        <!-- jquery 3.3.1 -->
        <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <!-- bootstap bundle js -->
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
        <!-- slimscroll js -->
        <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
        <!-- main js -->
        <script src="assets/libs/js/main-js.js"></script>

    </body>


</html>
