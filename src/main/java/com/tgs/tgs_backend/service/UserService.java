package com.tgs.tgs_backend.service;

import com.tgs.tgs_backend.domain.User;
import com.tgs.tgs_backend.exception.DuplicateUserException;
import com.tgs.tgs_backend.exception.UserNotFoundException;
import com.tgs.tgs_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User userDetail(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public List<User> userList(String userId, String userNm) {
        return userRepository.findByUserIdOrUserNmContaining(userId, userNm);
    }

    public User save(User user) {
        if (checkExistingUser(user.getUserId())) {
            throw new DuplicateUserException(user.getUserId());
        }

        user.setActiveYn("Y");
        user.setAdminYn("N");
        user.setUseYn("Y");

        return userRepository.save(user);
    }

    public User userUpdate(String userId, User newUser) {
        return userRepository.findById(userId)
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
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    public void userDelete(String userId) {
        userDetail(userId);
        userRepository.deleteById(userId);
    }

    // 고민중인 아이디어: 만약 존재하는 유저가 있다면, true값만 반환해 주는것이 아닌, user 객체를 반환하면
    // user를 두번 조회하는 일은 없지 않을까..?
    public boolean checkExistingUser(String id) {
        if(userRepository.findById(id).isPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
