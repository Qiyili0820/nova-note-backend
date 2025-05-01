package com.example.novanote.repository;

import com.example.novanote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 可以額外加自訂查詢方法（例如查帳號）
    User findByUsername(String username);
    User findByEmail(String email);
}
