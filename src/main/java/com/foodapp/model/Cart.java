package com.foodapp.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Cart Class
 * Stores all items selected by the user.
 */
public class Cart {

    // Stores menuId as key and CartItem as value
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    // Add item to cart
    public void addItem(CartItem item) {

        if (items.containsKey(item.getMenuId())) {

            CartItem existingItem = items.get(item.getMenuId());

            existingItem.setQuantity(
                    existingItem.getQuantity() + item.getQuantity());

        } else {

            items.put(item.getMenuId(), item);

        }
    }

    // Update quantity
    public void updateItem(int menuId, int quantity) {

        if (items.containsKey(menuId)) {

            items.get(menuId).setQuantity(quantity);

        }
    }

    // Remove item
    public void removeItem(int menuId) {

        items.remove(menuId);

    }

    // Get all items
    public Collection<CartItem> getItems() {

        return items.values();

    }

    // Calculate total amount
    public double getTotalAmount() {

        double total = 0;

        for (CartItem item : items.values()) {

            total += item.getTotalPrice();

        }

        return total;
    }

    // Clear cart
    public void clearCart() {

        items.clear();

    }
}