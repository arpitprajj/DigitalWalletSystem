package com.wallet.user_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
}
