/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelAdmin;

import java.sql.Date;

/**
 *
 * @author GearVn
 */
public class OrderDetail {
    private int id;
    private String productCode;
    private int quantity;
    private String size;
    
    public OrderDetail() {
    }

    public OrderDetail(int id, String productCode, int quantity, String size) {
        this.id = id;
        this.productCode = productCode;
        this.quantity = quantity;
        this.size = size;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    
}
