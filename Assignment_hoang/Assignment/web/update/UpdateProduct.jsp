<%-- 
    Document   : UpdateProduct
    Created on : Nov 9, 2020, 11:00:19 AM
    Author     : GearVn
--%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<%@page import="daoAdmin.ProductAdminDAO"%>
<%@page import="modelAdmin.ProductLine"%>
<%@page import="daoAdmin.ProductLineAdminDAO"%>
<%@page import="modelAdmin.Color"%>
<%@page import="daoAdmin.ColorAdminDAO"%>
<%@page import="modelAdmin.Material"%>
<%@page import="daoAdmin.MaterialAdminDAO"%>
<%@page import="modelAdmin.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoAdmin.CollectionAdminDAO"%>
<%@page import="modelAdmin.Product"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
    <head>

        <title>Ananas Product</title>
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
                if (session.getAttribute("product") != null) {
                    Product p1 = (Product) session.getAttribute("product");
                    ProductAdminDAO dap = new ProductAdminDAO();
                    Product p = dap.select(p1).get(0);
            %>
            <form action="./UpdateProduct" method="POST">
                <table class="table container">
                    <tr>
                        <th>Product Code</th>
                        <td><input type="text" name="productCode" value="<%=p.getProductCode()%>" readonly="true"></td>
                    </tr>
                    <tr>
                        <th>Product Name</th>
                        <td><input type="text" name="productName" value="<%= p.getProductName()%>"></td>
                    </tr>
                    <tr>
                        <th>Category ID</th>
                        <td><select name="categoryID">
                                <option value="1" <%=(p.getCategoryID()==1)?"selected":""%>>Giày</option>
                                <option value="2" <%=(p.getCategoryID()==2)?"selected":""%>>Nửa trên</option>
                                <option value="3" <%=(p.getCategoryID()==3)?"selected":""%>>Phụ kiện</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><input type="text" name="price" value="<%= p.getPrice()%>"></td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td><input type="text" name="description" value="<%= p.getDescription()%>" style="width: 400px;height: 200px"></td>
                    </tr>
                    <tr>
                        <th>Status</th>

                        <td><input type="text" name="status" value="<%= p.getStatus()%>"></td>
                    </tr>
                    <tr>
                        <th>Size</th>
                        <td><input type="text" name="size" value="<%= p.getSize()%>" readonly="true"></td>
                    </tr>
                    <tr>
                        <th>Images</th>
                        <td><input type="text" name="images" value="<%= p.getImages()%>"></td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td><select name="gender">
                                <option value="Nam" <%=(p.getGender().equals("Nam"))?"selected":""%>>Nam</option>
                                <option value="Nữ" <%=(p.getGender().equals("Nữ"))?"selected":""%>>Nữ</option>
                                <option value="Unisex" <%=(p.getGender().equals("Unisex"))?"selected":""%>>Unisex</option>
                            </select></td>
                    </tr>
                    <tr>
                        <th>Collection ID</th>
                        <td>
                            <select name="collectionID">
                                <%
                                    CollectionAdminDAO clad = new CollectionAdminDAO();
                                    ArrayList<Collection> listCL = clad.getAll();
                                    for (Collection c : listCL) {
                                %>
                                <option value="<%=c.getId()%>" <%= (p.getCollectionID() == c.getId())?"selected":""%>><%=c.getCollectionName()%></option>        
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Material ID</th>
                        <td>
                            <select name="materialID">
                                <%
                                    MaterialAdminDAO mad = new MaterialAdminDAO();
                                    ArrayList<Material> listM = mad.getAll();
                                    for (Material m : listM) {
                                %>
                                <option value="<%=m.getId()%>" <%= (p.getMaterialID() == m.getId())?"selected":""%>><%=m.getMaterialName()%></option>        
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Quantity</th>
                        <td><input type="text" name="quantity" value="<%= p.getQuantity()%>"></td>
                    </tr>
                    <tr>
                        <th>Style</th>
                        <td><input type="text" name="style" value="<%= p.getStyle()%>"></td>
                    </tr>
                    <tr>
                        <th>Color ID</th>
                        <td><select name="colorID">
                                <%
                                    ColorAdminDAO cad = new ColorAdminDAO();
                                    ArrayList<Color> listC = cad.getAll();
                                    for (Color c : listC) {
                                %>
                                <option value="<%=c.getId()%>" <%= (p.getColorID()== c.getId())?"selected":""%>><%=c.getColorName()%></option>        
                                <%
                                    }
                                %>
                            </select></td>
                    </tr>
                    <tr>
                        <th>Detail Product</th>
                        <td><input type="text" name="detailProduct" value="<%= p.getDetailProduct()%>"></td>
                    </tr>
                    <tr>
                        <th>Product Line ID</th>
                        <td><select name="productLineID">
                                <%
                                    ProductLineAdminDAO plad = new ProductLineAdminDAO();
                                    ArrayList<ProductLine> listPL = plad.getAll();
                                    for (ProductLine pl : listPL) {
                                %>
                                <option value="<%=pl.getId()%>" <%= (p.getProductLineID()== pl.getId())?"selected":""%>><%=pl.getProductLineName()%></option>        
                                <%
                                    }
                                %>
                            </select></td>
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
</body>
</html>
