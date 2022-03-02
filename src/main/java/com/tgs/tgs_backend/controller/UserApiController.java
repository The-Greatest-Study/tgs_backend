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

    // 유저 1명 조회
    @GetMapping("/{userId}")
    public User userDetail(@PathVariable String userId) {
        return userService.userDetail(userId);
    }

    // 유저 검색 조회
    // 공란으로 검색을 했을때 - request parameter를 어떻게 넘겨줄 것인지
    // 1. 프론트딴에서 userNm = ""
    // 2. 백엔드에서 default userNm = ""
    @GetMapping("")
    public List<User> userList(@RequestParam(required = false, defaultValue = "") String userId,
                               @RequestParam(required = false, defaultValue = "") String userNm) {
        return userService.userList(userId, userNm);
    }

    // 유저 생성
    @PostMapping("/create")
    public User userCreate(@RequestBody @Validated User user) {
        return userService.save(user);
    }

    // 유저 수정
    @PostMapping("/{userId}/update")
    public User userUpdate(@PathVariable String userId,
                           @RequestBody @Validated User newUser) {
        return userService.userUpdate(userId, newUser);
    }

    // 유저 삭제
    @DeleteMapping("/{userId}/delete")
    public void userDelete(@PathVariable String userId) {
        userService.userDelete(userId);
    }
}
