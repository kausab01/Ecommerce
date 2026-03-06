package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.model.Cart;
import com.ecommerce.util.DBConnection;

public class CartDAO {
	public static List<Cart> getCartByUser(String email){

	    List<Cart> list = new ArrayList<>();

	    try{

	        Connection con = DBConnection.getconnection();

	        String query = "SELECT c.*, p.name, p.price FROM cart c JOIN product p ON c.product_id = p.id WHERE c.user_email=?";

	        PreparedStatement ps = con.prepareStatement(query);
	        ps.setString(1, email);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()){

	            Cart cart = new Cart(
	                    rs.getInt("id"),
	                    rs.getString("user_email"),
	                    rs.getInt("product_id"),
	                    rs.getInt("quantity"),
	                    rs.getString("name"),
	                    rs.getDouble("price")
	            );

	            list.add(cart);
	        }

	    }catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}

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
