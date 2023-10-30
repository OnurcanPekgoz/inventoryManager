package com.onurcan.task.Repository;

import java.util.ArrayList;
import com.onurcan.task.Entity.Inventory;
import com.onurcan.task.Entity.Product;
import com.onurcan.task.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    ArrayList<Inventory> findByUser(User user);
    Inventory findByUserAndProduct(User user, Product product);

}

