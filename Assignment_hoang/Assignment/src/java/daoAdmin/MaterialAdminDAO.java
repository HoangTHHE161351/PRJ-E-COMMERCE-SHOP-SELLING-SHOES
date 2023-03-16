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
import modelAdmin.Material;

/**
 *
 * @author GearVn
 */
public class MaterialAdminDAO extends DBContext{
    
    // insert new material

    public void insert(Material m) {
        String sql = "insert into [Material] values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getMaterialName());
            st.setString(2, m.getDescription());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  material
    public void update(Material m){
        String sql = "update [Material] set MaterialName = ?, [Description] = ? where ID = ?;";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getMaterialName());
            st.setString(2, m.getDescription());
            st.setInt(3, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete material
    public  void delete (Material m){
        String sql = "delete from [Material] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public ArrayList<Material> getAll(){
        ArrayList<Material> list = new ArrayList<>();
        String sql = "select * from [Material]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Material(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public Material select(Material m){
        String sql = "select * from [Material] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new Material(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        MaterialAdminDAO mad = new MaterialAdminDAO();
        
    }
}
