package com.sd.sdshop.apis.Entitys;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.SecureRandom;

@Entity
public class Products {

    private static final SecureRandom PRODUCT_ID_RANDOM = new SecureRandom();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, nullable = false)
    private String productId;
    private String productName;
    @Lob
    private byte[] productImage;
    private int productQuantity;
    private String productDescription;
    private BigDecimal productPrice;
    private BigDecimal actualPrice;
    private int discount;

    @PrePersist
    private void ensureProductId() {
        if (this.productId == null || this.productId.isBlank()) {
            int n = PRODUCT_ID_RANDOM.nextInt(100_000_000); // 0..99,999,999
            this.productId = "SD-" + String.format("%08d", n);
        }
    }

    public Products() {
    }

    public Products(String productName, byte[] productImage, int productQuantity, String productDescription, BigDecimal productPrice, BigDecimal actualPrice, int discount) {
        this.productName = productName;
        this.productImage = productImage;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.actualPrice = actualPrice;
        this.discount = discount;
    }

    public Products(String productName, int productQuantity, String productDescription, BigDecimal productPrice, BigDecimal actualPrice, int discount) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.actualPrice = actualPrice;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
}
