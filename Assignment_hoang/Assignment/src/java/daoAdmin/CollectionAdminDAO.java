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
import modelAdmin.Collection;
import modelAdmin.Color;

/**
 *
 * @author GearVn
 */
public class CollectionAdminDAO extends DBContext{
    // add new collection
    public void insert(Collection c) {
        String sql = "insert into [Collection] values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCollectionName());
            st.setString(2, c.getCollectionImage());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    // edit  collection
    public void update(Collection m){
        String sql = "update [Collection] set [CollectionName] = ?, [CollectionImage] = ? where ID = ?;";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, m.getCollectionName());
            st.setString(2, m.getCollectionImage());
            st.setInt(3, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    // delete Collection
    public  void delete (Collection m){
        String sql = "delete from [Collection] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, m.getId());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Collection> getAll(){
        ArrayList<Collection> list = new ArrayList<>();
        String sql = "select * from [Collection]";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Collection(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<Collection> select(Collection c){
        ArrayList<Collection> list = new ArrayList<>();
        String sql = "select * from [Collection] where id = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                list.add(new Collection(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
