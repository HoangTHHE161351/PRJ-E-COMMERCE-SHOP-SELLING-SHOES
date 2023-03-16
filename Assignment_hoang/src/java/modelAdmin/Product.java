/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelAdmin;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author GearVn
 */
public class Product {
    private String productCode;
    private String productName;
    private double price;
    private String description;
    private String status;
    private int gender;
    private int quantity;
    private String style;
    private String detailProduct;
    private ProductImage image;
    private ProductSize size;
    private Collection collection;
    private Category category;

    public Product() {
    }

    public Product(String productCode, String productName, double price, String description, String status, int gender, int quantity, String style, String detailProduct, ProductImage image, ProductSize size, Collection collection, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.status = status;
        this.gender = gender;
        this.quantity = quantity;
        this.style = style;
        this.detailProduct = detailProduct;
        this.image = image;
        this.size = size;
        this.collection = collection;
        this.category = category;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    public String getPriceFormat(){
        Locale  vn = new Locale("vi", "VN");
        NumberFormat f = NumberFormat.getInstance(vn);
        return f.format(price);
    }
    
}
