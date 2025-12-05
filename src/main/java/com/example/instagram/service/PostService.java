package com.example.instagram.service;

import com.example.instagram.dto.request.PostCreateRequest;
import com.example.instagram.dto.response.PostResponse;
import com.example.instagram.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {
    PostResponse create(PostCreateRequest postCreateRequest, MultipartFile image, Long userId);

    PostResponse getPost(Long postId);

    Post findById(Long postId);

    List<PostResponse> getAllPosts();

    List<PostResponse> getPostsByUsername(String username);

    long countByUserId(Long userId);

    List<PostResponse> getAllPostsWithStates();

    // 피드 조회
    Slice<PostResponse> getFeedPosts(Long userId, Pageable pageable);
    // 전체게시물 조회
    Slice<PostResponse> getAllPostsPaging(Pageable pageable);

    Slice<PostResponse> searchPosts(String keyword, Pageable pageable);
}
