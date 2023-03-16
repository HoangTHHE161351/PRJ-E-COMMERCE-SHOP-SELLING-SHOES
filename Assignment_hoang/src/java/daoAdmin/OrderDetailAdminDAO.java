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
import modelAdmin.OrderDetail;

/**
 *
 * @author GearVn
 */
public class OrderDetailAdminDAO extends DBContext{
     // add new ProductLine
    public void insert(OrderDetail c) {
        String sql = "insert into [OrderDetail] values (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getProductCode());
            st.setString(3, c.getSize());
            st.setInt(4, c.getQuantity());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  Order
    public void update(OrderDetail m){
        String sql = "update [OrderDetail] set [ProductName] = ?,[Size] = ?, [Quantity] = ? where ID = ?;";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getProductCode());
            st.setString(2, m.getSize());
            st.setInt(3, m.getQuantity());
            st.setInt(4, m.getId());
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete Order
    public  void delete (OrderDetail m){
        String sql = "delete from [OrderDetail] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public ArrayList<OrderDetail> getOrder(int id){
        ArrayList<OrderDetail> list = new ArrayList<>();
        String sql = "select * from [OrderDetail] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new OrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
        
    }
}
