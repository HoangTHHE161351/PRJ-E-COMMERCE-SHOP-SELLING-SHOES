<%-- 
    Document   : UpdateCollection
    Created on : Nov 10, 2020, 9:24:42 AM
    Author     : GearVn
--%>

<%@page import="daoAdmin.CollectionAdminDAO"%>
<%@page import="modelAdmin.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
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
        <h1 style="text-align: center">Databoard Ananas</h1>
        <div class="container" style="padding: 10% 10%;text-align: center;vertical-align: central;text-justify: auto">
            <%
                if (session.getAttribute("collection") != null) {
                    Collection c1 = (Collection) session.getAttribute("collection");
                    CollectionAdminDAO dao = new CollectionAdminDAO();
                    Collection c = dao.select(c1).get(0);
            %>
            <form action="./UpdateCollection" method="POST">
                <table class="table container">
                    <tr>
                        <th>ID</th>
                        <td><input type="text" name="id" readonly="true" value="<%= c.getId()%>"></td>
                    </tr>
                    <tr>
                        <th>Collection Name</th>
                        <td><input type="text" name="collectionName" value="<%= c.getCollectionName()%>"></td>
                    </tr>
                    <tr>
                        <th>Collection Image</th>
                        <td><input type="text" name="collectionImage" value="<%= c.getCollectionImage()%>"></td>
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
