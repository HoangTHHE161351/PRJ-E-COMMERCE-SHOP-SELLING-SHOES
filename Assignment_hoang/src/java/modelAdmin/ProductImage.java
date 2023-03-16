/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelAdmin;

/**
 *
 * @author phanh
 */
public class ProductImage {

    private String productCode;
    private String image1;
    private String image2;
    private String image3;

    public ProductImage() {
    }

    public ProductImage(String productCode, String image1, String image2, String image3) {
        this.productCode = productCode;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;

    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

   
    
}
