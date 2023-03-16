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
public class Product {
    private String productCode;
    private String productName;
    private int categoryID;
    private double price;
    private String description;
    private String status;
    private String size;
    private String images;
    private String gender;
    private int collectionID;
    private int materialID;
    private int quantity;
    private String style;
    private int colorID;
    private String detailProduct;
    private int productLineID;

    public Product() {
    }

    public Product(String productCode, String productName, int categoryID, double price, String status, String images, String gender, int collectionID, int materialID, int colorID, int productLineID) {
        this.productCode = productCode;
        this.productName = productName;
        this.categoryID = categoryID;
        this.price = price;
        this.status = status;
        this.images = images;
        this.gender = gender;
        this.collectionID = collectionID;
        this.materialID = materialID;
        this.colorID = colorID;
        this.productLineID = productLineID;
    }

    public Product(String productCode, String size) {
        this.productCode = productCode;
        this.size = size;
    }
    
    public Product(String productCode, String productName, int categoryID, double price, String description, String status, String size, String images, String gender, int collectionID, int materialID, int quantity, String style, int colorID, String detailProduct, int productLineID) {
        this.productCode = productCode;
        this.productName = productName;
        this.categoryID = categoryID;
        this.price = price;
        this.description = description;
        this.status = status;
        this.size = size;
        this.images = images;
        this.gender = gender;
        this.collectionID = collectionID;
        this.materialID = materialID;
        this.quantity = quantity;
        this.style = style;
        this.colorID = colorID;
        this.detailProduct = detailProduct;
        this.productLineID = productLineID;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCollectionID() {
        return collectionID;
    }

    public void setCollectionID(int collectionID) {
        this.collectionID = collectionID;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
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

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }

    public String getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
    }

    public int getProductLineID() {
        return productLineID;
    }

    public void setProductLineID(int productLineID) {
        this.productLineID = productLineID;
    }
    
}
