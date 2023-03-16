/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

/**
 *
 * @author GearVn
 */
public class UserDAO extends DBContext {

//    public ArrayList<User> getAll(){
//        ArrayList<User> list = new ArrayList<>();
//        String sql = "select username, [password] from [User]";
//        try{
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while(rs.next()){
//                list.add(new User(rs.getString(1), rs.getString(2)));
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//        return list;
//    }
    public User checkLogin(String userName, String password) {
        try {
            String sql = "SELECT [Username]\n"
                    + "      ,[Password]\n"
                    + "      ,[FirstName]\n"
                    + "      ,[LastName]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Role]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[gender]\n"
                    + "  FROM [ananas].[dbo].[Users]\n"
                    + "  WHERE Username= ? AND Password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString("Username"), rs.getString("Password"), rs.getString("Phone")
                        , rs.getString("Address"), rs.getString("Email"),  rs.getString("FirstName"), rs.getString("LastName")
                        , rs.getString("Role"), rs.getInt("gender"), rs.getDate("CreateDate"));
                
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public User checkRegister(String userName) {
        try {
            String sql = "SELECT [Username]\n"
                    + "      ,[Password]\n"
                    + "      ,[FirstName]\n"
                    + "      ,[LastName]\n"
                    + "      ,[Address]\n"
                    + "      ,[Email]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Role]\n"
                    + "      ,[CreateDate]\n"
                    + "      ,[gender]\n"
                    + "  FROM [ananas].[dbo].[User]\n"
                    + "  WHERE Username = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString("Username"), rs.getString("Password"), rs.getString("Phone")
                        , rs.getString("Address"), rs.getString("Email"),  rs.getString("FirstName"), rs.getString("LastName")
                        , rs.getString("Role"), rs.getInt("gender"), rs.getDate("CreateDate"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void register(User u) {
        try {
            String sql = "INSERT INTO [dbo].[User]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[FirstName]\n"
                    + "           ,[LastName]\n"
                    + "           ,[Role])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());
            st.setString(3, u.getFirstName());
            st.setString(4, u.getLastName());
            st.setString(5, "Customer");
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(User u) {
        String sql = "insert into [Users] values(?,?,?,?,?,?,?,?,getdate())";
        try {
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
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(User c) {
        String sql = "update [Users] set Password = ?,FirstName = ?, LastName =?,[Address] =?, Email =?, Phone = ? where Username = ?;";
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

}
