package com.ecommerce.model;

public class Cart {

    private int id;
    private String userEmail;
    private int productId;
    private int quantity;

    private String productName;
    private double price;

    // constructor for add to cart
    public Cart(String userEmail, int productId, int quantity){
        this.userEmail = userEmail;
        this.productId = productId;
        this.quantity = quantity;
    }

    // constructor for cart display
    public Cart(int id, String userEmail, int productId, int quantity, String productName, double price){
        this.id = id;
        this.userEmail = userEmail;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public int getId() { return id; }
    public String getUserEmail() { return userEmail; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    public String getProductName() { return productName; }
    public double getPrice() { return price; }
}