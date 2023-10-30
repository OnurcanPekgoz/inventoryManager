package com.onurcan.task.Controller;

import com.onurcan.task.Service.InventoryService;
import com.onurcan.task.Service.ProductService;
import com.onurcan.task.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onurcan.task.Entity.User;
import com.onurcan.task.Entity.Product;
import com.onurcan.task.Entity.Inventory;

import java.util.ArrayList;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ArrayList<Inventory> listUserInventory(@RequestParam Long userId) {
        User user = userService.findUserById(userId);
        return inventoryService.listUserInventory(user);
    }

    @PostMapping("/add")
    public void addProductToInventory(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        User user = userService.findUserById(userId);
        Product product = productService.findProductById(productId);
        inventoryService.addProductToInventory(user, product, quantity);
    }

    @DeleteMapping("/remove")
    public void removeProductFromInventory(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userService.findUserById(userId);
        Product product = productService.findProductById(productId);
        inventoryService.removeProductFromInventory(user, product);
    }

    @PutMapping("/update")
    public void updateProductQuantity(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int newQuantity) {
        User user = userService.findUserById(userId);
        Product product = productService.findProductById(productId);
        inventoryService.updateProductQuantity(user, product, newQuantity);
    }

}
