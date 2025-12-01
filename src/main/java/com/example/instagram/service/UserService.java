package com.example.instagram.service;

import com.example.instagram.dto.request.SignUpRequest;
import com.example.instagram.entity.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

public interface UserService {
    User register(@Valid SignUpRequest signUpRequest);
}
