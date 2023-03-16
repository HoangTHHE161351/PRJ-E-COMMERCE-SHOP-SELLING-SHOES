<%-- 
    Document   : profile
    Created on : Oct 28, 2022, 10:46:51 AM
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
        <script src="assets/ckeditor/ckeditor.js"></script>
        <title>Add Product</title>
        <link rel="icon" type="image/x-icon" href="images/logo.png">
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
                <div class="influence-profile">
                    <div class="container-fluid dashboard-content ">
                        <!-- ============================================================== -->
                        <!-- pageheader -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="page-header">
                                    <h3 class="mb-2">Add Product </h3>
                                    <p class="pageheader-text">Proin placerat ante duiullam scelerisque a velit ac porta, fusce sit amet vestibulum mi. Morbi lobortis pulvinar quam.</p>
                                    <div class="page-breadcrumb">
                                        <nav aria-label="breadcrumb">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Managernent</a></li>
                                                <li class="breadcrumb-item active" aria-current="page">Add Product</li>
                                            </ol>
                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ============================================================== -->
                        <!-- end pageheader -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- content -->
                        <!-- ============================================================== -->
                        <div class="row">
                            <!-- ============================================================== -->
                            <!-- profile -->
                            <!-- ============================================================== -->
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                <!-- ============================================================== -->
                                <!-- card profile -->
                                <!-- ============================================================== -->
                                <div class="card">
                                    <form action="" method="post">
                                        <div class="card-body ">
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">ProductID</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <input type="text" required="" name="productCode" placeholder="ProductID" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Productname</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <input type="text" required="" name="productName"  placeholder="Productname" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <jsp:useBean id="cd" class="daoAdmin.CategoryAdminDAO"/>
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Category</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <select name="categoryID" class="form-control">
                                                        <c:forEach items="${cd.all}" var="c">
                                                            <option value="${c.id}" ${c.id == product.category.id ? 'selected' : ''}>${c.categoryName}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Price</label>
                                                <div class="col-sm-4 col-lg-3 mb-3 mb-sm-0">
                                                    <input id="Price" type="Price" name="price" required=""  placeholder="Price" class="form-control">
                                                </div>

                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Description</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <textarea required="" id="editor1" name="description" class="form-control">${product.description}</textarea>
                                                    <script>
                                                        // Replace the <textarea id="editor1"> with a CKEditor 4
                                                        // instance, using default configuration.
                                                        CKEDITOR.replace('editor1');
                                                    </script>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Status</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <input name="status" required="" placeholder="Phone" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-12 col-sm-3 col-form-label text-sm-right">Quantity</label>
                                                <div class="col-12 col-sm-8 col-lg-6">
                                                    <input  name="quantity" required="" placeholder="Phone" class="form-control">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label text-sm-right">Gender</label>
                                            <div class="col-sm-6">
                                                <div class="custom-controls-stacked">
                                                    <label class="custom-control custom-radio">
                                                        <input type="radio" name="gender" value="1"   class="custom-control-input"><span class="custom-control-label">Male</span>
                                                    </label>
                                                    <label class="custom-control custom-radio">
                                                        <input type="radio" name="gender" value="0"  class="custom-control-input"><span class="custom-control-label">Female</span>
                                                    </label>
                                                    <label class="custom-control custom-radio">
                                                        <input type="radio" name="gender" value="2"  class="custom-control-input"><span class="custom-control-label">UniSex</span>
                                                    </label>
                                                    <!--<div id="error-container2"></div>-->
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">Collection</label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <jsp:useBean id="cld" class="daoAdmin.CollectionAdminDAO"/>
                                                <select name="collectionID" class="form-control">
                                                    <c:forEach items="${cld.all}" var="cl">
                                                        <option value="${cl.id}" ${cl.id == product.collection.id ? 'selected' : ''}>${cl.collectionName}</option>
                                                    </c:forEach>
                                                        <option value="null">Null</option>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-12 col-sm-3 col-form-label text-sm-right">DetailProduct </label>
                                            <div class="col-12 col-sm-8 col-lg-6">
                                                <textarea required="" id="editor2" name="detail" class="form-control">${product.detailProduct}</textarea>
                                                <script>
                                                    // Replace the <textarea id="editor1"> with a CKEditor 4
                                                    // instance, using default configuration.
                                                    CKEDITOR.replace('editor2');
                                                </script>
                                            </div>
                                        </div>

                                        <div class="form-group row text-right">
                                            <div class="col col-sm-10 col-lg-9 offset-sm-1 offset-lg-0">
                                                <button type="submit" class="btn btn-space btn-primary">Finish</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- ============================================================== -->
                            <!-- end card profile -->
                            <!-- ============================================================== -->
                        </div>
                        <!-- ============================================================== -->
                        <!-- end profile -->
                        <!-- ============================================================== -->
                        <!-- ============================================================== -->
                        <!-- campaign data -->
                        <!-- ============================================================== -->

                        <!-- ============================================================== -->
                        <!-- end campaign data -->
                        <!-- ============================================================== -->
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end content -->
            <!-- ============================================================== -->
            <div class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                            Copyright © 2018 Concept. All rights reserved. Dashboard by <a href="https://colorlib.com/wp/">Colorlib</a>.
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                            <div class="text-md-right footer-links d-none d-sm-block">
                                <a href="javascript: void(0);">About</a>
                                <a href="javascript: void(0);">Support</a>
                                <a href="javascript: void(0);">Contact Us</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end footer -->
            <!-- ============================================================== -->
        </div>
        <!-- ============================================================== -->
        <!-- end wrapper -->
        <!-- ============================================================== -->
    </div>
    <!-- ============================================================== -->
    <!-- end main wrapper -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <!-- jquery 3.3.1  -->
    <script src="assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <!-- bootstap bundle js -->
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <!-- slimscroll js -->
    <script src="assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <!-- main js -->
    <script src="assets/libs/js/main-js.js"></script>

</body>

</html>
