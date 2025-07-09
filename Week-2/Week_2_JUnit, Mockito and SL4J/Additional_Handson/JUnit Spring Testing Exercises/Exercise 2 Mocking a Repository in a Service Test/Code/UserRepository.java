package com.example.SpringTestDemo.repository;

import com.example.SpringTestDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
