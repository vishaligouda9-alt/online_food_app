
	package com.foodapp.model;

	/*
	 * Restaurant Model Class
	 * ----------------------
	 * This class represents one record from the restaurant table.
	 * It is used to store restaurant information.
	 */

	public class Restaurant {

	    // Instance variables matching the restaurant table columns

	    private int restaurantId;
	    private String restaurantName;
	    private String cuisineType;
	    private String address;
	    private String phone;
	    private double rating;
	    private String imageUrl;
	    private boolean isActive;

	    // Default Constructor
	    public Restaurant() {

	    }

	    // Parameterized Constructor (without ID)
	    public Restaurant(String restaurantName, String cuisineType,
	                      String address, String phone,
	                      double rating, String imageUrl,
	                      boolean isActive) {

	        this.restaurantName = restaurantName;
	        this.cuisineType = cuisineType;
	        this.address = address;
	        this.phone = phone;
	        this.rating = rating;
	        this.imageUrl = imageUrl;
	        this.isActive = isActive;
	    }

	    // Parameterized Constructor (with ID)

	    public Restaurant(int restaurantId, String restaurantName,
	                      String cuisineType, String address,
	                      String phone, double rating,
	                      String imageUrl, boolean isActive) {

	        this.restaurantId = restaurantId;
	        this.restaurantName = restaurantName;
	        this.cuisineType = cuisineType;
	        this.address = address;
	        this.phone = phone;
	        this.rating = rating;
	        this.imageUrl = imageUrl;
	        this.isActive = isActive;
	    }

	    // Getter Methods

	    public int getRestaurantId() {
	        return restaurantId;
	    }

	    public String getRestaurantName() {
	        return restaurantName;
	    }

	    public String getCuisineType() {
	        return cuisineType;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public double getRating() {
	        return rating;
	    }

	    public String getImageUrl() {
	        return imageUrl;
	    }

	    public boolean isActive() {
	        return isActive;
	    }

	    // Setter Methods

	    public void setRestaurantId(int restaurantId) {
	        this.restaurantId = restaurantId;
	    }

	    public void setRestaurantName(String restaurantName) {
	        this.restaurantName = restaurantName;
	    }

	    public void setCuisineType(String cuisineType) {
	        this.cuisineType = cuisineType;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public void setRating(double rating) {
	        this.rating = rating;
	    }

	    public void setImageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	    }

	    public void setActive(boolean active) {
	        isActive = active;
	    }

	    // toString()

	    @Override
	    public String toString() {
	        return "Restaurant [restaurantId=" + restaurantId
	                + ", restaurantName=" + restaurantName
	                + ", cuisineType=" + cuisineType
	                + ", address=" + address
	                + ", phone=" + phone
	                + ", rating=" + rating
	                + ", imageUrl=" + imageUrl
	                + ", isActive=" + isActive + "]";
	    }

	}


