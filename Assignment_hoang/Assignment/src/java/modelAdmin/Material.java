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
public class Material {
    private int Id;
    private String MaterialName;
    private String Description;

    public Material() {
    }

    public Material(String MaterialName, String Description) {
        this.MaterialName = MaterialName;
        this.Description = Description;
    }
    
    
    public Material(int Id, String MaterialName, String Description) {
        this.Id = Id;
        this.MaterialName = MaterialName;
        this.Description = Description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMaterialName() {
        return MaterialName;
    }

    public void setMaterialName(String MaterialName) {
        this.MaterialName = MaterialName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
