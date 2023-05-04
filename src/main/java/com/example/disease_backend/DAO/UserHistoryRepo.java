package com.example.disease_backend.DAO;

import com.example.disease_backend.models.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepo extends JpaRepository<UserHistory,Long> {

}
