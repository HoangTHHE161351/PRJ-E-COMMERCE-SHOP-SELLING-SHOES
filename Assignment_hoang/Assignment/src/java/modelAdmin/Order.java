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
public class Order {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    
    private double total;
    private String status;
    private String address;
    private String phoneNumber;
    private Date orderDate;
    public Order() {
    }

    public Order(int id, String username, String firtName, String lastName, double total, String status, String address, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.firstName = firtName;
        this.lastName = lastName;
        this.total = total;
        this.status = status;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Order(int id, String username, String firstName, String lastName, double total, String status, String address, String phoneNumber, Date orderDate) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.total = total;
        this.status = status;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
    }
    
    

    public Order(String username, String firtName, String lastName, double total, String status, String address, String phoneNumber) {
        this.username = username;
        this.firstName = firtName;
        this.lastName = lastName;
        this.total = total;
        this.status = status;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firtName) {
        this.firstName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    
}
