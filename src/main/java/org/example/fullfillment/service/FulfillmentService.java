package org.example.fullfillment.service;

import org.example.fullfillment.exception.EmptyInventoryException;
import org.example.fullfillment.exception.EmptyProductInventory;
import org.example.fullfillment.exception.InvalidQuantityException;
import org.example.fullfillment.exception.ProductNotFoundException;

public interface FulfillmentService {
    String addInventory(String productId, Integer quantity) throws InvalidQuantityException;

    void removeInventory(String productId) throws ProductNotFoundException, EmptyProductInventory, EmptyInventoryException;

    String viewInventory() throws EmptyInventoryException;
}
