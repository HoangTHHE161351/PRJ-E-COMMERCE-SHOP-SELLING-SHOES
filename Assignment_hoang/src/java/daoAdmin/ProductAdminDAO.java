/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoAdmin;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class ProductAdminDAO extends DBContext {

    // add new ProductLine
    public void insert(Product c) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductCode]\n"
                + "           ,[ProductName]\n"
                + "           ,[CategoryID]\n"
                + "           ,[Price]\n"
                + "           ,[Description]\n"
                + "           ,[Status]\n"
                + "           ,[Gender]\n"
                + "           ,[CollectionID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Style]\n"
                + "           ,[DetailProduct])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductCode());
            st.setString(2, c.getProductName());
            st.setInt(3, c.getCategory().getId());
            st.setDouble(4, c.getPrice());
            st.setString(5, c.getDescription());
            st.setString(6, c.getStatus());
            st.setInt(7, c.getGender());
            st.setInt(8, c.getCollection().getId());
            st.setInt(9, c.getQuantity());
            st.setString(10, c.getStyle());
            st.setString(11, c.getDetailProduct());
            st.executeUpdate();

            String sql1 = "INSERT INTO [dbo].[ProductImages]\n"
                    + "           ([ProductCode]\n"
                    + "           ,[image1]\n"
                    + "           ,[image2]\n"
                    + "           ,[image3])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, c.getProductCode());
            st1.setString(2, c.getImage().getImage1());
            st1.setString(3, c.getImage().getImage2());
            st1.setString(4, c.getImage().getImage3());
            st1.executeUpdate();

            String sql2 = "INSERT INTO [dbo].[ProductSize]\n"
                    + "           ([ProductCode]\n"
                    + "           ,[size1]\n"
                    + "           ,[size2]\n"
                    + "           ,[size3]\n"
                    + "           ,[size4]\n"
                    + "           ,[size5]\n"
                    + "           ,[size6]\n"
                    + "           ,[size7]\n"
                    + "           ,[size8]\n"
                    + "           ,[size9]\n"
                    + "           ,[size10]\n"
                    + "           ,[size11]\n"
                    + "           ,[size12])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setString(1, c.getProductCode());
            st2.setString(2, c.getSize().getColor1());
            st2.setString(3, c.getSize().getColor2());
            st2.setString(4, c.getSize().getColor3());
            st2.setString(5, c.getSize().getColor4());
            st2.setString(6, c.getSize().getColor5());
            st2.setString(7, c.getSize().getColor6());
            st2.setString(8, c.getSize().getColor7());
            st2.setString(9, c.getSize().getColor8());
            st2.setString(10, c.getSize().getColor9());
            st2.setString(11, c.getSize().getColor10());
            st2.setString(12, c.getSize().getColor11());
            st2.setString(13, c.getSize().getColor12());
            st2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        }

    }
//
//    public ArrayList<Product> select(Product p) {
//        ArrayList<Product> list = new ArrayList<>();
//        String sql = "select * from [Product] where ProductCode = ? and Size = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, p.getProductCode());
//            st.setString(2, p.getSize());
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }
//
    // edit  Product

    public void update(Product c) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [ProductCode] = ?\n"
                + "      ,[ProductName] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Status] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[CollectionID] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[Style] = ?\n"
                + "      ,[DetailProduct] = ?\n"
                + " WHERE productCode = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductCode());
            st.setString(2, c.getProductName());
            st.setInt(3, c.getCategory().getId());
            st.setDouble(4, c.getPrice());
            st.setString(5, c.getDescription());
            st.setString(6, c.getStatus());
            st.setInt(7, c.getGender());
            st.setInt(8, c.getCollection().getId());
            st.setInt(9, c.getQuantity());
            st.setString(10, c.getStyle());
            st.setString(11, c.getDetailProduct());
            st.setString(12, c.getProductCode());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // delete Product
    public void delete(String productCode) {

        try {

            String sql1 = "delete from [ProductImages] where productCode = ?";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setString(1, productCode);
            st1.executeUpdate();

            String sql2 = "delete from [ProductSize] where productCode = ?";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st2.setString(1, productCode);
            st2.executeUpdate();

            String sql = "delete from [Products] where ProductCode = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, productCode);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    public ArrayList<Product> getAll() {
//        ArrayList<Product> list = new ArrayList<>();
//        String sql = "select * from [Product]";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//
//    }
//    public ArrayList<Product> getAllByPage(ArrayList<Product> listAll, int start,int end){
//        ArrayList<Product> list = new ArrayList<>();
//        for(int i=start;i<end;i++){
//            list.add(list.get(i));
//        }
//        return list;
//    }
    public static void main(String[] args) {
        ProductAdminDAO pad = new ProductAdminDAO();

    }
}
