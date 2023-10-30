package com.onurcan.task.Controller;

import com.onurcan.task.Entity.User;
import com.onurcan.task.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestParam String username,@RequestParam String password) {
        User user= new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.registerUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
