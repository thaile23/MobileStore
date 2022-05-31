package com.example.mobilestore.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long productID;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer unitInStock;

    private String description;

    private String manufacturer;

    private String category;

    private Integer condition_id;

    private String image;


    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(Integer condition_id) {
        this.condition_id = condition_id;
    }

    public String getImage() {
        return "/image/"+ image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitInStock=" + unitInStock +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", category='" + category + '\'' +
                ", condition_id=" + condition_id +
                ", image='" + image + '\'' +
                '}';
    }
}
