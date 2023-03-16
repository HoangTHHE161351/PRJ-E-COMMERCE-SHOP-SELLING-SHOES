/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoAdmin;

import com.sun.xml.ws.transport.tcp.io.OutputWriter;
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

    public String insert(Product c) {
        String sql = "insert into [Product] values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductCode());
            st.setString(2, c.getProductName());
            st.setInt(3, c.getCategoryID());
            st.setDouble(4, c.getPrice());
            st.setString(5, c.getDescription());
            st.setString(6, c.getStatus());
            st.setString(7, c.getSize());
            st.setString(8, c.getImages());
            st.setString(9, c.getGender());
            st.setInt(10, c.getCollectionID());
            st.setInt(11, c.getMaterialID());
            st.setInt(12, c.getQuantity());
            st.setString(13, c.getStyle());
            st.setInt(14, c.getColorID());
            st.setString(15, c.getDetailProduct());
            st.setInt(16, c.getProductLineID());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return e + "";
        }
        return "ok";
    }

    public ArrayList<Product> select(Product p) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from [Product] where ProductCode = ? and Size = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getProductCode());
            st.setString(2, p.getSize());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    // edit  Product

    public void update(Product c) {
        String sql = "update [Product] set ProductName = ?,CategoryID = ?, Price =?,[Description] =?, Status =?, Images = ?, Gender = ?, CollectionID = ?, MaterialID = ?, Quantity = ?, Style =?, ColorID = ?, DetailProduct =?, ProductLineID = ? where ProductCode = ? and Size = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductName());
            st.setInt(2, c.getCategoryID());
            st.setDouble(3, c.getPrice());
            st.setString(4, c.getDescription());
            st.setString(5, c.getStatus());
            st.setString(6, c.getImages());
            st.setString(7, c.getGender());
            st.setInt(8, c.getCollectionID());
            st.setInt(9, c.getMaterialID());
            st.setInt(10, c.getQuantity());
            st.setString(11, c.getStyle());
            st.setInt(12, c.getColorID());
            st.setString(13, c.getDetailProduct());
            st.setInt(14, c.getProductLineID());
            st.setString(15, c.getProductCode());
            st.setString(16, c.getSize());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // delete Product

    public void delete(Product m) {
        String sql = "delete from [Product] where ProductCode = ? and Size = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getProductCode());
            st.setString(2, m.getSize());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from [Product]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getInt(16)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }
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
