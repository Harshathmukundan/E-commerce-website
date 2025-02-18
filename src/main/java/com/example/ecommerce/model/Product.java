package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")  // Mapping the Product class to 'products' table in the database
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private Long id;

    @Column(name = "name", nullable = false)  // Column mapping
    private String name;

    @Column(name = "brand", nullable = false)  // Column mapping
    private String brand;

    @Column(name = "description", nullable = true)  // Column mapping
    private String description;

    @Column(name = "price", nullable = false)  // Column mapping
    private int price;

    @Column(name = "image_url", nullable = true)  // Column mapping
    private String imageUrl;

    // Default constructor (required by JPA)
    public Product() {}

    // Parametrized constructor (optional, can be used to create Product objects)
    public Product(String name, String brand, String description, int price, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
