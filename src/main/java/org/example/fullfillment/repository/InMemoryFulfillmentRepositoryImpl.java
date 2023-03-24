package org.example.fullfillment.repository;

import org.example.fullfillment.exception.EmptyInventoryException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InMemoryFulfillmentRepositoryImpl implements FulfillmentRepository {
    private final Map<String, Integer> inMemoryInventory;

    public InMemoryFulfillmentRepositoryImpl() {
        inMemoryInventory = new HashMap<>();
    }

    @Override
    public boolean inventoryHasProduct(String productId) {
        return inMemoryInventory.containsKey(productId);
    }

    @Override
    public void decrementById(String productId) {
        inMemoryInventory.put(productId, inMemoryInventory.get(productId) - 1);
        if (inMemoryInventory.get(productId) == 0) {
            inMemoryInventory.remove(productId);
        }
    }

    @Override
    public Integer incrementInventoryByQuantity(String productId, Integer quantity) {
        return inMemoryInventory.put(productId, inMemoryInventory.getOrDefault(productId, 0) + quantity);
    }

    @Override
    public String getCompleteInventory() throws EmptyInventoryException {
        if (inMemoryInventory.isEmpty()) {
            throw new EmptyInventoryException("Cannot view an empty inventory");
        }
        return inMemoryInventory.toString();
    }

    @Override
    public Set<String> getAllProductIds() {
        return inMemoryInventory.keySet();
    }

    @Override
    public Integer getProductInventoryById(String productId) {
        return inMemoryInventory.get(productId);
    }
}
