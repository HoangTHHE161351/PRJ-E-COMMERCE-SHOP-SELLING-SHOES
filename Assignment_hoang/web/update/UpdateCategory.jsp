<%-- 
    Document   : UpdateCategory
    Created on : Nov 10, 2020, 1:17:30 AM
    Author     : GearVn
--%>

<%@page import="daoAdmin.CategoryAdminDAO"%>
<%@page import="modelAdmin.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
    <head>

        <title>Ananas Category Update</title>
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
        <h1 style="text-align: center">Databoard Ananas</h1>
        <div class="container" style="padding: 10% 10%;text-align: center;vertical-align: central;text-justify: auto">
            <%
                if (session.getAttribute("category") != null) {
                    Category c1 = (Category) session.getAttribute("category");
                    CategoryAdminDAO dao = new CategoryAdminDAO();
                    Category c = dao.select(c1).get(0);
            %>
            <form action="./UpdateCategory" method="post">
                <table class="table container">
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name="id" readonly="true" value="<%= c.getId()%>"></td>
                    </tr>
                    <tr>
                        <th>Category Name</th>
                        <td><input type="text" name="categoryName" value="<%= c.getCategoryName()%>"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input  class="btn btn-primary" type="submit" name="update" value="Update"></input>
                            <!--<button class="btn btn-danger" type="reset" name="reset">Reset</button>-->
                        </td>
                    </tr>
                    
                </table>    
            </form>
            <%
                }
            %>

        </div>
    </body>
</html>
