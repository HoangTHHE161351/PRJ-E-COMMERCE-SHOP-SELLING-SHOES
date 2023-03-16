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
import modelAdmin.Order;

/**
 *
 * @author GearVn
 */
public class OrderAdminDAO extends DBContext{
     // add new ProductLine
    public void insert(Order c) {
        String sql = "insert into [Order] values (?,?,?,?,?,?,?,getDate())";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setDouble(2, c.getTotal());
            st.setString(3, c.getStatus());
            st.setString(4, c.getAddress());
            st.setString(5, c.getPhoneNumber());
            st.setString(6, c.getFirstName());
            st.setString(7, c.getLastName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  Order
    public void updateStatus(Order m, String status){
        String sql = "update [Order] set [Status] = ? where ID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);            
            st.setString(1,status);
            st.setInt(2, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete Order
    public  void delete (Order m){
        String sql = "delete from [Order] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public ArrayList<Order> getAll(){
        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from [Order]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(7),rs.getString(8) , rs.getDouble(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(9)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
        
    }
    public Order getOrder(int id){
        String sql = "select * from [Order] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Order(rs.getInt(1), rs.getString(2), rs.getString(7),rs.getString(8) , rs.getDouble(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(9));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        OrderAdminDAO dao = new OrderAdminDAO();
        System.out.println(dao.getOrder(10).getTotal());
    }
}
