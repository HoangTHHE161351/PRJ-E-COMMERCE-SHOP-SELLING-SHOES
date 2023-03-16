/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelAdmin.Order;

/**
 *
 * @author phanh
 */
public class OrderDAO extends DBContext {

    public List<Order> getRecentOrder() {
        try {

            String sql = "SELECT TOP(5) [ID]\n"
                    + "      ,[Username]\n"
                    + "      ,[Total]\n"
                    + "      ,[Status]\n"
                    + "      ,[Address]\n"
                    + "      ,[Phone]\n"
                    + "      ,[FirstName]\n"
                    + "      ,[LastName]\n"
                    + "      ,[OrderDate]\n"
                    + "  FROM [ananas].[dbo].[Orders]\n"
                    + "  ORDER BY [OrderDate] DESC";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            List<Order> list = new ArrayList<>();
            while (rs.next()) {
                Order o = new Order(rs.getInt(1), rs.getString(2), rs.getString(7), rs.getString(8), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(9));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public double getRevenueData() {
        try {

            String sql = "SELECT SUM(TOTAL)\n"
                    + "  FROM [ananas].[dbo].[Orders]\n";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

   

    public HashMap<Integer, Double> getDataForChart(int categoryID) {
        try {
            HashMap<Integer, Double> map = new HashMap<>();
            for (int i = 1; i <= 12; i++) {

                String sql = "SELECT SUM(o.Total)\n"
                        + "                        FROM [ananas].[dbo].[OrderDetails] od inner join [ananas].[dbo].[Products] p\n"
                        + "                                ON od.ProductCode = p.ProductCode inner join [ananas].[dbo].Categories c\n"
                        + "                                on p.CategoryID = c.ID inner join [ananas].[dbo].ProductImages pim\n"
                        + "                                on p.ProductCode = pim.ProductCode inner join [ananas].[dbo].ProductSize ps\n"
                        + "                                on p.ProductCode = ps.ProductCode left join [ananas].[dbo].Collections cl\n"
                        + "                                on p.CollectionID = cl.ID inner join [ananas].[dbo].[Orders] o\n"
                        + "								on od.[ID] = o.ID\n"
                        + "                                where p.[CategoryID] = ? AND MONTH(o.[OrderDate]) IN (?) ";
                
                PreparedStatement st = connection.prepareStatement(sql);
                st.setInt(1, categoryID);
                st.setInt(2, i);
                ResultSet rs = st.executeQuery();
                switch (i) {
                    case 1:
                        map.put(1, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 2:
                        map.put(2, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 3:
                        map.put(3, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 4:
                        map.put(4, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 5:
                        map.put(5, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 6:
                        map.put(6, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 7:
                        map.put(7, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 8:
                        map.put(8, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 9:
                        map.put(9, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 10:
                        map.put(10, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 11:
                        map.put(11, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                    case 12:
                        map.put(12, (rs.next() ? rs.getDouble(1) : 0.0));
                        break;
                }
            }

            return map;
        } catch (SQLException e) {
            System.out.println(e + "Áấ");
        }
        return null;
    }
}
