package com.tgs.tgs_backend.service;

import com.tgs.tgs_backend.domain.User;
import com.tgs.tgs_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    public List<User> findByUserIdOrUserNmContaining(String userId, String userNm) {
        return userRepository.findByUserIdOrUserNmContaining(userId, userNm);
    }

    public String save(User user) {
        user.setActiveYn("Y");
        user.setAdminYn("N");
        user.setUseYn("Y");

        userRepository.save(user);
        return user.getUserId();
    }

}
