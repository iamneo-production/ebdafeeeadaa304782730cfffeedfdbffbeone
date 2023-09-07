package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import javax.persistence.*;

@Entity
public class Product {
    @Id
    private int productId;
    private String productName;
    private double price;
    private int quantity;  // Corrected field name to "quantity"

    @ManyToOne
    @JoinColumn(name = "category_id")  // Changed column name to "category_id"
    private Category category;

    // Constructors, getters, and setters...

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

	

	public Product(int productId, String productName, double price, int quantity, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public Product() {
		super();
	}
    
    
}

