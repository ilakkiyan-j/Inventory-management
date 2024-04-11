package com.inventory.Inventory_Management.product;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer id) {
        super("Order with id  = " + id + " not found.");
    }
}
