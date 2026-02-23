package com.ecommerce.model;

public class Cart {

	private int id;
	private String userEmail;
	private int productId;
	private int quantity;
	
	public Cart(String userEmail, int productId, int quantity){
	
		    this.userEmail = userEmail;
	        this.productId = productId;
	        this.quantity = quantity;
	}
    public String getUserEmail() { return userEmail; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
