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

    public String userUpdate(String userId, User newUser) {
        Optional<User> oldUser = findByUserId(userId);

        if (oldUser.isPresent()) {
            User user = oldUser.get();
            user.setUserNm(newUser.getUserNm());
            user.setUserBday(newUser.getUserBday());
            user.setUseYn(newUser.getUseYn());
            user.setActiveYn(newUser.getActiveYn());
            user.setAdminYn(newUser.getAdminYn());
            user.setGender(newUser.getGender());
            user.setPw(newUser.getPw());
            userRepository.save(user);
            return user.getUserId();
        }
        return null;
    }

    public void delete(String userId) {
        Optional<User> user = findByUserId(userId);

        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
    }

}
