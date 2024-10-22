package project.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingOperations {
	 public boolean submitRating(int userId, int storeId, int rating) {
	        String checkRatingSQL = "SELECT * FROM Ratings WHERE user_id = ? AND store_id = ?";
	        String insertRatingSQL = "INSERT INTO Ratings (user_id, store_id, rating) VALUES (?, ?, ?)";
	        String updateRatingSQL = "UPDATE Ratings SET rating = ? WHERE user_id = ? AND store_id = ?";
	        
	        try (Connection conn = DBConnection.getConnection()) {
	            // Check if the user has already submitted a rating
	            try (PreparedStatement checkPstmt = conn.prepareStatement(checkRatingSQL)) {
	                checkPstmt.setInt(1, userId);
	                checkPstmt.setInt(2, storeId);
	                ResultSet rs = checkPstmt.executeQuery();
	                
	                if (rs.next()) {
	                    // If a rating exists, update it
	                    try (PreparedStatement updatePstmt = conn.prepareStatement(updateRatingSQL)) {
	                        updatePstmt.setInt(1, rating);
	                        updatePstmt.setInt(2, userId);
	                        updatePstmt.setInt(3, storeId);
	                        updatePstmt.executeUpdate();
	                    }
	                } else {
	                    // If no rating exists, insert a new rating
	                    try (PreparedStatement insertPstmt = conn.prepareStatement(insertRatingSQL)) {
	                        insertPstmt.setInt(1, userId);
	                        insertPstmt.setInt(2, storeId);
	                        insertPstmt.setInt(3, rating);
	                        insertPstmt.executeUpdate();
	                    }
	                }
	            }
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public double calculateStoreRating(int storeId) {
	        String sql = "SELECT AVG(rating) AS avgRating FROM Ratings WHERE store_id = ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, storeId);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return rs.getDouble("avgRating");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }
}
