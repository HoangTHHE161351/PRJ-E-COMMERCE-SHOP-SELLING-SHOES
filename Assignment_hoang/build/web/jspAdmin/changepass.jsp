<%-- 
    Document   : changepass
    Created on : Oct 28, 2022, 10:45:19 AM
    Author     : DELL
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <link rel="stylesheet" href="assets/vendor/charts/chartist-bundle/chartist.css">
        <link rel="stylesheet" href="assets/vendor/charts/morris-bundle/morris.css">
        <link rel="stylesheet" href="assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendor/charts/c3charts/c3.css">
        <link rel="stylesheet" href="assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
        <link rel="icon" type="image/x-icon" href="images/logo.png">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
    <style>
    html,
    body {
        height: 100%;
    }

    body {
        display: -ms-flexbox;
        display: flex;
        -ms-flex-align: center;
        align-items: center;
        padding-top: 40px;
        padding-bottom: 40px;
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
    <!-- forgot password  -->
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
                                <h2 class="pageheader-title">E-commerce Dashboard Template </h2>
                                <p class="pageheader-text">Nulla euismod urna eros, sit amet scelerisque torton lectus vel mauris facilisis faucibus at enim quis massa lobortis rutrum.</p>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="#" class="breadcrumb-link">Dashboard</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">E-Commerce Dashboard Template</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ============================================================== -->
                    <!-- end pageheader  -->
    <div class="splash-container">
        <div class="card">
            <div class="card-header text-center"><img class="logo-img" src="images/logo.admin.png" alt="logo"><span class="splash-description">Please enter new password.</span></div>
            <div class="card-body">
                <form>
                    <p>Old Password</p>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="email" name="Old Password" required="" placeholder="Old Password" autocomplete="off">
                    </div>
                    <p>New Password</p>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="email" name="New Password" required="" placeholder="New Password" autocomplete="off">
                    </div>
                    <p>Re-New Password</p>
                    <div class="form-group">
                        <input class="form-control form-control-lg" type="Re-New Password" name="Re-New Password" required="" placeholder="Re-New Password" autocomplete="off">
                    </div>
                    <div class="form-group pt-1"><a class="btn btn-block btn-primary btn-xl" href="../index.html">Change Password</a></div>
                </form>
            </div>
            
        </div>
    </div>

    <!-- ============================================================== -->
    <!-- end forgot password  -->
    <!-- ============================================================== -->
    <!-- Optional JavaScript -->
    <script src="../assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <script src="../assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
</body>

 
</html>
