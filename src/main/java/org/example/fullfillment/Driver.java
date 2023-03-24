package org.example.fullfillment;

import org.example.fullfillment.exception.EmptyInventoryException;
import org.example.fullfillment.exception.EmptyProductInventory;
import org.example.fullfillment.exception.InvalidQuantityException;
import org.example.fullfillment.exception.ProductNotFoundException;
import org.example.fullfillment.service.FulfillmentService;
import org.example.fullfillment.service.FulfillmentServiceImpl;

public class Driver {
    public static void main(String[] args) {
        FulfillmentService fulfillmentService = new FulfillmentServiceImpl();

        //add products to inventory
        try {
            fulfillmentService.addInventory("1111", 10);
            fulfillmentService.addInventory("2222", 2);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }

        //view the inventory
        try {
            System.out.println(fulfillmentService.viewInventory());
        } catch (EmptyInventoryException e) {
            System.out.println(e.getMessage());
        }

        //remove from inventory
        try {
            fulfillmentService.removeInventory("2222"); //happy path
            fulfillmentService.removeInventory("3333"); //!happy path
        } catch (EmptyProductInventory | EmptyInventoryException | ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}