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
public class ProductLine {
    private int id;
    private String productLineName;

    public ProductLine() {
    }

    public ProductLine(String productLineName) {
        this.productLineName = productLineName;
    }
    
    public ProductLine(int id, String productLineName) {
        this.id = id;
        this.productLineName = productLineName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }
    
}
