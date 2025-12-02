package com.example.instagram.service;

import com.example.instagram.dto.request.SignUpRequest;
import com.example.instagram.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

public interface UserService {
    User register(@Valid SignUpRequest signUpRequest);

    boolean existsByUsername(String username);

    User findById(Long userId);
}
