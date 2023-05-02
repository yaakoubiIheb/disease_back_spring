package com.example.disease_backend.Repos;

import java.util.List;


import com.example.disease_backend.models.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {

    List<UserHistory> findByUser_IdOrderByCreatedDateDesc(Long userId);

    void deleteByUser_Id(Long userId);

}
