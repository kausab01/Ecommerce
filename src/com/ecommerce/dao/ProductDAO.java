package com.ecommerce.dao;

import java.sql.*;
import java.util.*;
import com.ecommerce.model.Product;
import com.ecommerce.util.DBConnection;

public class ProductDAO {

    public static List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getconnection();

            String query = "SELECT * FROM product";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getString("image")
                );
                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}