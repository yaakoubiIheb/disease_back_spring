package com.example.disease_backend.DAO;

import com.example.disease_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
