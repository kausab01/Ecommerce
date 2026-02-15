package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public static boolean registeruser(User user) throws SQLException{
		try{
		Connection con=DBConnection.getconnection();
		String query="INSERT INTO user(name,email,password ) values(?,?,?)";
		 
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		
		int rows=ps.executeUpdate();
		 
		return rows>0;
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
    public static User loginUser(String email, String password) {

        try {
            Connection con = DBConnection.getconnection();

            String query = "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
