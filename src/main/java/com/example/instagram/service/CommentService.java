package com.example.instagram.service;

import com.example.instagram.dto.request.CommentCreateRequest;
import com.example.instagram.dto.response.CommentResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface CommentService {
    CommentResponse create(Long postId, CommentCreateRequest commentCreateRequest, Long userId);
}
