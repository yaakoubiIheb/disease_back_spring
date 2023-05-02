package com.example.disease_backend.models;

import jakarta.persistence.*;

import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "user_history")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String result;
    private Date createdDate;

}
