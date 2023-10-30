package com.onurcan.task.Service;

import com.onurcan.task.Entity.Inventory;
import com.onurcan.task.Entity.Product;
import com.onurcan.task.Entity.User;
import com.onurcan.task.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    public ArrayList<Inventory> listUserInventory(User user) {

        return inventoryRepository.findByUser(user);
    }

    public void addProductToInventory(User user, Product product, int quantity) {
        Inventory existingInventoryItem = inventoryRepository.findByUserAndProduct(user, product);

        if (existingInventoryItem != null) {
            existingInventoryItem.setQuantity(existingInventoryItem.getQuantity() + quantity);
        } else {
            Inventory inventoryItem = new Inventory();
            inventoryItem.setUser(user);
            inventoryItem.setProduct(product);
            inventoryItem.setQuantity(quantity);
            inventoryRepository.save(inventoryItem);
        }
    }

    public void removeProductFromInventory(User user, Product product) {
        Inventory existingInventoryItem = inventoryRepository.findByUserAndProduct(user, product);

        if (existingInventoryItem != null) {
            inventoryRepository.delete(existingInventoryItem);
        }
    }

    public void updateProductQuantity(User user, Product product, int newQuantity) {
        Inventory existingInventoryItem = inventoryRepository.findByUserAndProduct(user, product);

        if (existingInventoryItem != null) {
            existingInventoryItem.setQuantity(newQuantity);
            inventoryRepository.save(existingInventoryItem);
        }
    }
}

