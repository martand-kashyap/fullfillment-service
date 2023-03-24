package org.example.fullfillment.repository;

import org.example.fullfillment.exception.EmptyInventoryException;

import java.util.Set;

public interface FulfillmentRepository {
    boolean inventoryHasProduct(String productId);

    void decrementById(String productId);

    Integer incrementInventoryByQuantity(String productId, Integer quantity);

    String getCompleteInventory() throws EmptyInventoryException;

    Set<String> getAllProductIds();

    Integer getProductInventoryById(String productId);
}
