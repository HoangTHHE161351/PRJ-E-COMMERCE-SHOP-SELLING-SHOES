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
import modelAdmin.Category;

/**
 *
 * @author GearVn
 */
public class CategoryAdminDAO extends DBContext {

    //add new category
    public void insert(Category c) {
        String sql = "insert into [Category] values (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // edit  category
    public void update(Category c) {
        String sql = "update [Category] set CategoryName = ? where ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.setInt(2, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // delete category
    public void delete(Category c) {
        String sql = "delete from [Category] where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Category> getAll() {
        ArrayList<Category> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [ananas].[dbo].[Categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category select(int categoryID) {
        String sql = "select * from [Categories] where Id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, categoryID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
