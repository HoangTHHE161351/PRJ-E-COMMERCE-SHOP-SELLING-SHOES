/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelAdmin;

/**
 *
 * @author GearVn
 */
public class Collection {
    private int id;
    private String collectionName;
    private String collectionImage;

    public Collection() {
    }

    public Collection(int id, String collectionName, String collectionImage) {
        this.id = id;
        this.collectionName = collectionName;
        this.collectionImage = collectionImage;
    }

    public Collection(String collectionName, String collectionImage) {
        this.collectionName = collectionName;
        this.collectionImage = collectionImage;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionImage() {
        return collectionImage;
    }

    public void setCollectionImage(String collectionImage) {
        this.collectionImage = collectionImage;
    }
    
}
