package com.sd.sdshop.apis.products;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private String productId;
    private String productName;
    private byte[] productImage;
    private int productQuantity;
    private String productDescription;
    private BigDecimal productPrice;
    private BigDecimal actualPrice;
    private int discount;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String productId, String productName, byte[] productImage, int productQuantity, String productDescription, BigDecimal productPrice, BigDecimal actualPrice, int discount) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.actualPrice = actualPrice;
        this.discount = discount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
