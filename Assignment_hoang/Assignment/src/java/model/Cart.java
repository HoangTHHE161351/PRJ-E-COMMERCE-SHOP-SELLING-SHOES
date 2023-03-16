/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import modelAdmin.Product;

/**
 *
 * @author GearVn
 */
public class Cart {
    private ArrayList<Item> cart; 

    public Cart() {
        cart = new ArrayList<>();
    }
    private Item getItemById(String productCode, String size){
        for(Item i:cart){
            if(i.getProduct().getProductCode().equals(productCode) && i.getProduct().getSize().equals(size))
                return i;
        }
        return null;
    }
    public void addItem(Item t) {
        //nếu có món này trong giỏ thì cập nhật lại số lượng
        if (getItemById(t.getProduct().getProductCode(),t.getProduct().getSize())!=null) {
            Item m = getItemById(t.getProduct().getProductCode(),t.getProduct().getSize());
            m.setQuantity(m.getQuantity()+ t.getQuantity());
        } else//nếu chưa có món này trong giỏ thì thêm mới
            cart.add(t);
    }   
    public void deleteItem(Item t) {
        if (getItemById(t.getProduct().getProductCode(),t.getProduct().getSize())!=null) {
            cart.remove(getItemById(t.getProduct().getProductCode(),t.getProduct().getSize()));
        }
    }
    public ArrayList<Item> getCart() {
        return cart;
    }    
    public double totalMoney(){
        double tt=0;
        for(Item i:cart){
            tt+=i.getProduct().getPrice()*i.getQuantity();
        }
        return tt;
    
    }
}
