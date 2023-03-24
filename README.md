# A simple fulfillment service

## Summary :

You have to design and implement a Fulfillment Service that allows us to keep track of inventory.

## Description :

The fulfillment service will receive requests to add or remove inventory.
There can be any number of different product ids.
The remove inventory function will just remove one item of the specified product id.
If the removal of inventory is not possible because there are no products available, the appropriate error should be
shown to the user.

## Requirements :

The following functionalities have to be implemented:<br/>

Note: The given parameters are the mandatory parameters, you are free to add more parameters as part of your apis if you
feel the need to do so. The return type of each api is up to you but make sure it provides the relevant information
needed.

1. `addInventory(productId, amount)` : This will add the specified amount of inventory for the productId in the system.
2. `removeInventory(productId)` : This will remove one item from the inventory for the specified productId.
3. `viewInventory()` : This will give a view of the whole inventory system. It will print all the products available
   and their count. It can be printed in any format as long as it is readable.

## Guidelines :

- You should store the data in-memory using a language-specific data-structure.
- You can print the output in console.
- Implement clear separation between your data layers and service layers.

## Expectations :

- Your code should cover all the mandatory functionalities explained above.
- Your code should be executable and clean.
- Your code should be properly refactored, and exceptions should be gracefully handled.
