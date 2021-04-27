package com.sdev.toylog.controller;

import com.sdev.toylog.dto.request.*;
import com.sdev.toylog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/ids")
    public void checkUserId(@Valid @RequestBody IdCheckRequest idCheckRequest) {
        userService.checkDuplicatedUserId(idCheckRequest.getUserId());
    }

    @PostMapping("/email")
    public void checkEmail(@Valid @RequestBody EmailCheckRequest emailCheckRequest) {
        userService.checkDuplicatedEmail(emailCheckRequest.getEmail());
    }

    @PostMapping
    public void registerUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        userService.join(userCreateRequest);
    }

    @PostMapping("/login")
    public LoginSuccessResponse loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) throws IllegalAccessException {
        return userService.loginUser(userLoginRequest);
    }

}
