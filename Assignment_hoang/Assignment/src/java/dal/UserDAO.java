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
import model.User;

/**
 *
 * @author GearVn
 */
public class UserDAO extends DBContext{
    public ArrayList<User> getAll(){
        ArrayList<User> list = new ArrayList<>();
        String sql = "select username, [password] from [User]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new User(rs.getString(1), rs.getString(2)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public void insert(User u){
        String sql = "insert into [User] values(?,?,?,?,?,?,?,?,getdate())";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());
            st.setString(3, u.getFirstName());
            st.setString(4, u.getLastName());
            st.setString(5, u.getAddress());
            st.setString(6, u.getEmail());
            st.setString(7, u.getPhoneNumber());
            st.setString(8, u.getRole());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void update(User c) {
        String sql = "update [User] set Password = ?,FirstName = ?, LastName =?,[Address] =?, Email =?, Phone = ? where Username = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getPassword());
            st.setString(2, c.getFirstName());
            st.setString(3, c.getLastName());
            st.setString(4, c.getAddress());
            st.setString(5, c.getEmail());
            st.setString(6, c.getPhoneNumber());
            st.setString(7, c.getUsername());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        System.out.println(u.getAll().get(0).getUsername());
        
    }
}
