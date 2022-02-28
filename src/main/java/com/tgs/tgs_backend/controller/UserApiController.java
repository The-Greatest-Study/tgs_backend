package com.tgs.tgs_backend.controller;


import com.tgs.tgs_backend.domain.User;
import com.tgs.tgs_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public User userDetail(@PathVariable String userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("")
    public List<User> userList(@RequestParam(required = false, defaultValue = "") String userId,
                               @RequestParam(required = false, defaultValue = "") String userNm) {
        return userService.findByUserIdOrUserNmContaining(userId, userNm);
    }

    @PostMapping("/create")
    public User userCreate(@RequestBody @Validated User user) {
        return userService.save(user);
    }

    @PostMapping("/{userId}/update")
    public User userUpdate(@PathVariable String userId,
                           @RequestBody @Validated User newUser) {
        return userService.userUpdate(userId, newUser);
    }

    @DeleteMapping("/{userId}/delete")
    public void userDelete(@PathVariable String userId) {
        userService.delete(userId);
    }
}
