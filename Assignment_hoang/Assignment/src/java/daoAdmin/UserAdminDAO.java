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
import model.User;

/**
 *
 * @author GearVn
 */
public class UserAdminDAO extends DBContext{
    public User select(User u){
        
        String sql = "select * from [User] where username = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,u.getUsername());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new User(rs.getString(1), rs.getString(2), rs.getString(7), rs.getString(5), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(8), rs.getString(9));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public void delete(User u) {
        String sql = "delete from [User] where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,u.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void update(User c) {
        String sql = "update [User] set Password = ?,FirstName = ?, LastName =?,[Address] =?, Email =?, Phone = ?, Role = ? where Username = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getPassword());
            st.setString(2, c.getFirstName());
            st.setString(3, c.getLastName());
            st.setString(4, c.getAddress());
            st.setString(5, c.getEmail());
            st.setString(6, c.getPhoneNumber());
            st.setString(7, c.getRole());
            st.setString(8, c.getUsername());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ArrayList<User> getAll(){
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from [User]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(7), rs.getString(5), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(8), rs.getString(9)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
