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
import modelAdmin.Color;
import modelAdmin.ProductLine;

/**
 *
 * @author GearVn
 */
public class ProductLineAdminDAO extends DBContext{
    // add new ProductLine
    public void insert(ProductLine c) {
        String sql = "insert into [ProductLine] values (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getProductLineName());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  ProductLine
    public void update(ProductLine m){
        String sql = "update [ProductLine] set ProductLineName = ?, where ID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getProductLineName());
            st.setInt(2, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete ProductLine
    public  void delete (ProductLine m){
        String sql = "delete from [ProductLine] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public ArrayList<ProductLine> getAll(){
        ArrayList<ProductLine> list = new ArrayList<>();
        String sql = "select * from [ProductLine]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new ProductLine(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
        
    }
    public ArrayList<ProductLine> select(ProductLine p){
        ArrayList<ProductLine> list = new ArrayList<>();
        String sql = "select * from [ProductLine]where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new ProductLine(rs.getInt(1), rs.getString(2)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
        
    }
}
