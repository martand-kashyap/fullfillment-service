package org.example.fullfillment.service;

import lombok.NonNull;
import org.example.fullfillment.exception.EmptyInventoryException;
import org.example.fullfillment.exception.EmptyProductInventory;
import org.example.fullfillment.exception.InvalidQuantityException;
import org.example.fullfillment.exception.ProductNotFoundException;
import org.example.fullfillment.repository.FulfillmentRepository;
import org.example.fullfillment.repository.InMemoryFulfillmentRepositoryImpl;

public class FulfillmentServiceImpl implements FulfillmentService {
    FulfillmentRepository repository;

    public FulfillmentServiceImpl() {
        repository = new InMemoryFulfillmentRepositoryImpl();
    }

    @Override
    public synchronized String addInventory(@NonNull String productId, @NonNull Integer quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Cannot add value <= 0 for any product");
        }

        repository.incrementInventoryByQuantity(productId, quantity);

        return productId;
    }

    @Override
    public synchronized void removeInventory(@NonNull String productId) throws ProductNotFoundException, EmptyProductInventory, EmptyInventoryException {
        if (repository.getAllProductIds().isEmpty()) {
            throw new EmptyInventoryException("Inventory has no products.");
        }

        if (!repository.inventoryHasProduct(productId)) {
            throw new ProductNotFoundException("The product with Id : " + productId + " does not exist");
        }

        if (repository.getProductInventoryById(productId) == 0) {
            throw new EmptyProductInventory("The product with Id : " + productId + " has been exhausted. We do not know when this will be back");
        }

        repository.decrementById(productId);
    }

    @Override
    public String viewInventory() throws EmptyInventoryException {
        return repository.getCompleteInventory();
    }
}
