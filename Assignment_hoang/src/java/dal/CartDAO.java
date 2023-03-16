/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import model.Cart;
import model.Item;
import model.User;

/**
 *
 * @author phanh
 */
public class CartDAO extends DBContext {

    public void checkout(User a, Cart cart) {
        try {

            String sql = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([Username]\n"
                    + "           ,[Total]\n"
                    + "           ,[Status]\n"
                    + "           ,[Address]\n"
                    + "           ,[Phone]\n"
                    + "           ,[FirstName]\n"
                    + "           ,[LastName]\n"
                    + "           ,[OrderDate])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setDouble(2, cart.getTotalMoney());
            st.setString(3, "Chờ Xử Lý");
            st.setString(4, a.getAddress());
            st.setString(5, a.getPhoneNumber());
            st.setString(6, a.getFirstName());
            st.setString(7, a.getLastName());
            st.setDate(8, getCurrentDate());
            st.executeUpdate();

            String sql2 = "SELECT TOP (1) [ID]\n"
                    + "      \n"
                    + "  FROM [ananas].[dbo].[Orders]\n"
                    + "  order by id desc";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            ResultSet rs = st2.executeQuery();

            if (rs.next()) {
                for (Item item : cart.getItems()) {
                    String sql1 = "INSERT INTO [dbo].[OrderDetails]\n"
                            + "           ([ID]"
                            + "           ,[ProductCode]\n"
                            + "           ,[Size]\n"
                            + "           ,[Quantity]"
                            + "           ,[totalMoney])\n"
                            + "     VALUES\n"
                            + "           (?\n"
                            + "           ,?\n"
                            + "           ,?\n"
                            + "           ,?"
                            + "           ,?)";
                    
                    PreparedStatement st1 = connection.prepareStatement(sql1);
                    st1.setInt(1, rs.getInt(1));
                    st1.setString(2, item.getProduct().getProductCode());
                    st1.setString(3, item.getSize());
                    st1.setInt(4, item.getQuantity());
                    st1.setDouble(5, item.getTotalPrice());
                    st1.executeUpdate();
                }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

   

    public static Date getCurrentDate() {
        LocalDate curDate = java.time.LocalDate.now();
        return Date.valueOf(curDate.toString());
    }
}
