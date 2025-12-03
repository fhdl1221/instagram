package com.example.instagram.service;

import com.example.instagram.entity.Follow;
import com.example.instagram.entity.User;
import com.example.instagram.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final UserService userService;
    private final FollowRepository followRepository;

    @Override
    @Transactional
    public void toggleFollow(Long followerId, String followingUsername) {
        User follower = userService.findById(followerId);
        User following = userService.findByUsername(followingUsername);

        if(follower.getId().equals(following.getId())) {
            throw new RuntimeException("자기 자신은 팔로우 할 수 없습니다");
        }

        Optional<Follow> existingFollow = followRepository.findByFollowerIdAndFollowingId(follower.getId(), following.getId());

        if (existingFollow.isPresent()) {
            followRepository.delete(existingFollow.get());
        } else {
            Follow follow = Follow.builder()
                    .follower(follower)
                    .following(following)
                    .build();

            followRepository.save(follow);
        }
    }

    @Override
    public boolean isFollowing(Long followerId, Long followingUserId) {
        return followRepository.existsByFollowerIdAndFollowingId(followerId, followingUserId);
    }
}
