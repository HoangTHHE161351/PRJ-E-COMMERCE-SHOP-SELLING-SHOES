/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import modelAdmin.Product;


/**
 *
 * @author GearVn
 */
public final class Cart {
    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public Item getItemByCode(String code){
        for (Item item : items) {
            if(item.getProduct().getProductCode().equals(code)){
                return item;
            }
        }
        return null;
    }
    
    public int getQuantityByCode(String code){
        return getItemByCode(code).getQuantity();
    }
    
    public double getTotalMoney(){
        double total = 0;
        for (Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
    
    public void addItem(Item item){
        if(getItemByCode(item.getProduct().getProductCode()) != null){
            Item oldItem = getItemByCode(item.getProduct().getProductCode());
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        }else {
            items.add(item);
        }
    }
    
    public void removeItem(String code){
        if(getItemByCode(code) != null){
            items.remove(getItemByCode(code));
        }
    }
    
    private Product getProductByCode(List<Product> list, String code){
        for (Product item : list) {
            if(item.getProductCode().equals(code)){
                return item;
            }
            
        }
        return null;
    }
    
    public Cart(String cookie, List<Product> list){
        items = new ArrayList<>();
        try {
            if(cookie != null && cookie.length() != 0){
                String [] itemLines = cookie.split("-");
                
                for (String itemLine : itemLines) {
                    String [] itemDetails = itemLine.split("_");
                    
                    String code = itemDetails[0];
                    
                    String [] itemDetail = itemDetails[1].split("/");
                    int quantity = Integer.parseInt(itemDetail[0]);
                    String size = itemDetail[1];
                    
                    Product p = getProductByCode(list, code);
                    
                    Item newItem = new Item(p, p.getPrice(), quantity, size);
                    
                    if (getItemByCode(newItem.getProduct().getProductCode()) != null) {
                        Item oldItem = getItemByCode(newItem.getProduct().getProductCode());
                        oldItem.setQuantity(oldItem.getQuantity() + newItem.getQuantity());
                    } else {
                        items.add(newItem);
                    }
                }
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
}
