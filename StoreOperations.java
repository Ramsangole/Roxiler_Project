package project.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Store;

public class StoreOperations {
	public List<Store> getAllStores() {
        List<Store> storeList = new ArrayList<>();
        String sql = "SELECT * FROM Stores";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Store store = new Store();
                store.setStoreId(rs.getInt("store_id"));
                store.setStoreName(rs.getString("sotre_name"));
                store.setAddress(rs.getString("adress"));
                store.setRating(rs.getDouble("rating"));
                storeList.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return storeList;
    }

    public List<Store> searchStores(String name, String address) {
        List<Store> storeList = new ArrayList<>();
        String sql = "SELECT * FROM Stores WHERE store_name LIKE ? AND address LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            pstmt.setString(2, "%" + address + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Store store = new Store();
                store.setStoreId(rs.getInt("store_id"));
                store.setStoreName(rs.getString("sotre_name"));
                store.setAddress(rs.getString("adress"));
                store.setRating(rs.getDouble("rating"));
                storeList.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return storeList;
    }}
