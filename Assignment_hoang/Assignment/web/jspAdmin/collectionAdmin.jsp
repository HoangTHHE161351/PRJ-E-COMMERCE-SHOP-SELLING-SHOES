<%-- 
    Document   : collectionAdmin
    Created on : Nov 10, 2020, 2:10:13 AM
    Author     : GearVn
--%>

<%@page import="model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Ananas Collection</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/responsive.css">
    </head>
    <body>
        <%
            if (session.getAttribute("account") != null) {
                User admin = (User) session.getAttribute("account");
                if (admin.getUsername().equals("admin") == false) {
        %>
        <div>You must login as admin to access this page</div>
        <%
        } else {
        %>
        <h1 style="text-align: center">Databoard Ananas</h1>
        <div class="container-fluid" style="padding: 10% 10%; padding-bottom: 0%">
            <table class="table">
                <tr>
                    <th><a href="./insert/InsertCollection.jsp"><button class="btn btn-primary">Add Collection</button></a></th>
                    <th><a href="productAdmin"><button class="btn btn-primary">Product</button></a></th>
                    <th><a href="orderAdmin"><button class="btn btn-primary">Order</button></a></th>
                    <th><a href="userAdmin"><button class="btn btn-primary">User</button></a></th>
                    <th><a href="colorAdmin"><button class="btn btn-primary">Color</button></a></th>
                    <th><a href="productLineAdmin"><button class="btn btn-primary">Product Line</button></a></th>
                    <th><a href="categoryAdmin"><button class="btn btn-primary">Category</button></a></th>
                    <th><a href="materialAdmin"><button class="btn btn-primary">Material</button></a></th>
                </tr>
            </table>
        </div>
        <div class="container-fluid" style="padding: 2% 10%;text-align: center;vertical-align: central;text-justify: auto">

            <table border="1" cellspacing="10px" class="table">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Collection Name</th>                        
                        <th>Collection Image</th>                        
                    </tr>
                </thead>
                <c:forEach var="c" items="${collectionAdmin}">
                <tr>
                    <td>${c.getId()}</td>
                    <td>${c.getCollectionName()}</td>
                    <td>${c.getCollectionImage()}</td>
                    
                    
                    <th>
                        <a href="UpdateCollection?Id=${c.getId()}"><input type="submit" class="btn btn-info" value="Update"/></a> 
                        <a href="DeleteColletion?Id=${c.getId()}"><input type="submit" class="btn btn-danger" value="Delete"/></a>
                    </th>
                </tr>
                </c:forEach>
            </table>
        </div>
                <%
                    }
                } else {
                %>
                <p>You must login as admin to access this page</p>
                <%
                    }
                %>
    </body>
</html>
