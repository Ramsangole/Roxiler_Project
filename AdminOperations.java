package project.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminOperations {
	 public int getTotalUsers() {
	        String sql = "SELECT COUNT(*) AS totalUsers FROM Users";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("totalUsers");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    public int getTotalStores() {
	        String sql = "SELECT COUNT(*) AS totalStores FROM Stores";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("totalStores");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    public int getTotalSubmittedRatings() {
	        String sql = "SELECT COUNT(*) AS totalRatings FROM Ratings";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("totalRatings");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
}
