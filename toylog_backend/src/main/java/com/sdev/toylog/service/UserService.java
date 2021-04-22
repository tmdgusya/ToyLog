package com.sdev.toylog.service;

import com.sdev.toylog.dto.request.LoginSuccessResponse;
import com.sdev.toylog.dto.request.UserCreateRequest;
import com.sdev.toylog.dto.request.UserLoginRequest;
import com.sdev.toylog.entity.User;
import com.sdev.toylog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private static final ModelMapper modelMapper = new ModelMapper();

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

    public LoginSuccessResponse loginUser(UserLoginRequest userLoginRequest) throws IllegalAccessException {
        //TODO 후에 레디스 도입 필요. 일단 Servlet Session 으로 진행
        String encryptPassword = encryptService.encrypt(userLoginRequest.getPassword());

        //TODO 일단 Custom 예외를 만들지 않았음, 주간 회의 필요
        final User user = userRepository.findByEmail(userLoginRequest.getEmail()).orElseThrow(IllegalArgumentException::new);
        if(!user.isMatchedPassword(encryptPassword)) {
            //TODO 후에 Custom Exception 필요함
            throw new IllegalAccessException("비밀번호가 틀렸습니다.");
        }
        return modelMapper.map(user, LoginSuccessResponse.class);
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
