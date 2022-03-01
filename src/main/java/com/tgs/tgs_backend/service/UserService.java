package com.tgs.tgs_backend.service;

import com.tgs.tgs_backend.domain.User;
import com.tgs.tgs_backend.exception.UserNotFoundException;
import com.tgs.tgs_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<User> findByUserIdOrUserNmContaining(String userId, String userNm) {
        return userRepository.findByUserIdOrUserNmContaining(userId, userNm);
    }

    public User save(User user) {
        user.setActiveYn("Y");
        user.setAdminYn("N");
        user.setUseYn("Y");

        return userRepository.save(user);
    }

    public User userUpdate(String userId, User newUser) {
        return userRepository.findByUserId(userId)
                .map(user -> {
                    user.setUserNm(newUser.getUserNm());
                    user.setUserBday(newUser.getUserBday());
                    user.setUseYn(newUser.getUseYn());
                    user.setActiveYn(newUser.getActiveYn());
                    user.setAdminYn(newUser.getAdminYn());
                    user.setGender(newUser.getGender());
                    user.setPw(newUser.getPw());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setUserId(userId);
                    return userRepository.save(newUser);
                });
    }

    public void delete(String userId) {
        userRepository.findByUserId(userId);
        userRepository.deleteByUserId(userId);
    }

}
