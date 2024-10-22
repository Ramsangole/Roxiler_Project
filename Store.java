package project.com;

public class Store {
	 // Define private fields
    private int storeId;
    private String storeName;
    private String address;
    private double rating;

    // Constructor (optional)
    public Store() {
    }

    // Getter and Setter for storeId
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    // Getter and Setter for storeName
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for rating
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
