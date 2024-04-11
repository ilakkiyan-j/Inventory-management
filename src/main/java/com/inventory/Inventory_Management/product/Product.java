package com.inventory.Inventory_Management.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;


public class Product {

    @NotNull
    @NotBlank
    @Length(min = 5, max = 20)
    private Integer product_id;
    private String product_name;
    private String product_description;
    private Integer quantity;
    private double price;
    private String category;

    public Product() {
    }

    public Product(int product_id, String product_description, String category, double price, int quantity, String product_name) {
        this.product_id = product_id;
        this.product_description = product_description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.product_name = product_name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", product_description='" + product_description + '\'' +
                '}';
    }
}