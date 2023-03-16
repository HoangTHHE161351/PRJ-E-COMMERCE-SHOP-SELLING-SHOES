/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.NumberFormat;
import java.util.Locale;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class Item {
    private Product product;
    private double price;
    private int quantity;
    private String size;

    public Item() {
    }

    public Item(Product product, double price, int quantity, String size) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getPriceFormat(){
        Locale  vn = new Locale("vi", "VN");
        NumberFormat f = NumberFormat.getInstance(vn);
        return f.format(price);
    }

    public double getTotalPrice(){
        return price * quantity;
    }
    
    public int getSizeFormat(){
        return Integer.parseInt(size);
    }
    
    
}
