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
public class Color {
   private int id;
   private String colorName;
   private String colorCode;

    public Color() {
    }

    public Color(int id, String colorName, String colorCode) {
        this.id = id;
        this.colorName = colorName;
        this.colorCode = colorCode;
    }

    public Color(String colorName, String colorCode) {
        this.colorName = colorName;
        this.colorCode = colorCode;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
   
}
