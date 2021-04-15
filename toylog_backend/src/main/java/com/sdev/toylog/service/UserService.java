package com.sdev.toylog.service;

import com.sdev.toylog.dto.request.UserCreateRequest;
import com.sdev.toylog.entity.User;
import com.sdev.toylog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EncryptService encryptService;

    public void join(UserCreateRequest userCreateRequest) {
        String encryptPassword = encryptService.encrypt(userCreateRequest.getPassword());

        User user = User.builder().userId(userCreateRequest.getUserId())
                .email(userCreateRequest.getEmail())
                .password(encryptPassword)
                .authentication(false)
                .build();

        userRepository.save(user);
    }

    public void checkDuplicatedUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw new IllegalStateException("이미 존재하는 아이디 입니다");
        }
    }

    public void checkDuplicatedEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 존재하는 이메일 입니다");
        }
    }
}
