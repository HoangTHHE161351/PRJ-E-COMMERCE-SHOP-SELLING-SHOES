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

/**
 *
 * @author GearVn
 */
public class ColorAdminDAO extends DBContext{
    // add new color
    public void insert(Color c) {
        String sql = "insert into [Color] values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getColorName());
            st.setString(2, c.getColorCode());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  color
    public void update(Color m){
        String sql = "update [Color] set ColorName = ?, [ColorCode] = ? where ID = ?;";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getColorName());
            st.setString(2, m.getColorCode());
            st.setInt(3, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete Color
    public  void delete (Color m){
        String sql = "delete from [Color] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public ArrayList<Color> getAll(){
        ArrayList<Color> list = new ArrayList<>();
        String sql = "select * from [Color]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Color(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<Color> select(Color c){
        ArrayList<Color> list = new ArrayList<>();
        String sql = "select * from [Color] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Color(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
