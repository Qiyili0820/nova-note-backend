package com.example.novanote.controller;

import com.example.novanote.model.User;
import com.example.novanote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 註冊新使用者
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email 已經被使用！";
        }
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "帳號已存在！";
        }
        userRepository.save(user);
        return "註冊成功！";
    }

    // 查詢全部使用者
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

