/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ProductReview;
import model.User;
import modelAdmin.Category;
import modelAdmin.Collection;
import modelAdmin.Product;
import modelAdmin.ProductImage;
import modelAdmin.ProductSize;

/**
 *
 * @author DELL
 */
public class ProductReviewDAO extends DBContext {

    public void insert(ProductReview pr) {
        try {

            String sql = "INSERT INTO [dbo].[Review]\n"
                    + "           ([ProductCode]\n"
                    + "           ,[Username]\n"
                    + "           ,[name]\n"
                    + "           ,[email]\n"
                    + "           ,[rating]\n"
                    + "           ,[content])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pr.getProductCode());
            st.setString(2, pr.getUserName());
            st.setString(3, pr.getName());
            st.setString(4, pr.getEmail());
            st.setInt(5, pr.getRating());
            st.setString(6, pr.getContent());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<ProductReview> getReviewListByProductCode(String code) {
        List<ProductReview> list = new ArrayList<>();
        try {

            String sql = "SELECT TOP (1000) [ProductCode]\n"
                    + "      ,[Username]\n"
                    + "      ,[name]\n"
                    + "      ,[email]\n"
                    + "      ,[rating]\n"
                    + "      ,[content]\n"
                    + "  FROM [ananas].[dbo].[Review]"
                    + "  where ProductCode = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                ProductReview pr = new ProductReview(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                list.add(pr);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
