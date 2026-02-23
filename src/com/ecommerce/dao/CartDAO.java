package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ecommerce.model.Cart;
import com.ecommerce.util.DBConnection;

public class CartDAO {

	public static boolean addToCart(Cart cart) {

	    try {
	        Connection con = DBConnection.getconnection();

	        String query = "INSERT INTO cart(user_email, product_id, quantity) VALUES(?,?,?)";

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, cart.getUserEmail());
	        ps.setInt(2, cart.getProductId());
	        ps.setInt(3, cart.getQuantity());

	        int rows = ps.executeUpdate();

	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
}
