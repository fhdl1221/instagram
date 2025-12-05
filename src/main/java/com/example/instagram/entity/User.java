package com.example.instagram.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(length = 20)
    private String name;

    @Column(nullable = false)
    private Role role;

    @Column(length = 200)
    private String bio;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Builder
    public User(String username, String password, String email, String name, Role role, String bio) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role != null ? role : Role.USER;
        this.bio = bio;
    }

    public void updateProfile(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public void updateProfileImage(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

}
