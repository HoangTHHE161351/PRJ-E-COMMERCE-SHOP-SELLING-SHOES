/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class ProductDAO extends DBContext{
    public ArrayList<Product> getAll() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from [Product] where ([Size] = '36' or Size = 'S' or Size = 'free') ";
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
    public ArrayList<Product> getNewArrival() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select ProductCode,ProductName,CategoryID,Price,[Status],Images,Gender,CollectionID,MaterialID,ColorID,ProductLineID,Size from [Product] where ([Status] = 'New Arrival' and ([Size] = '36' or Size = 'S' or Size = 'free') )";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<Product> getBestSeller() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select ProductCode,ProductName,CategoryID,Price,[Status],Images,Gender,CollectionID,MaterialID,ColorID,ProductLineID,Size from [Product] where ([Status] = 'Best Seller' and ([Size] = '36' or Size = 'S' or Size = 'free') )";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<Product> getListByPage(ArrayList<Product> list,int start,int end){
        ArrayList<Product> arr=new ArrayList<>();
        for(int i=start;i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }
    public Product select(Product p) {
        String sql = "select * from [Product] where ProductCode = ? and ([Size] = '36' or Size = 'S' or Size = 'free')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getProductCode());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getString(15), rs.getInt(16));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> list = dao.getNewArrival();
        for (Product list1 : list) {
            System.out.println(list1.getProductCode());
        }
    }
}
