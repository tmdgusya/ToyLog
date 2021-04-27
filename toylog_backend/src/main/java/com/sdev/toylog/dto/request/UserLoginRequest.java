package com.sdev.toylog.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserLoginRequest {

    @Pattern(regexp = "^[0-9a-z]{8,}", message = "영소문자와 숫자의 조합으로 8자리 이상이어야 합니다")
    @NotBlank(message = "올바른 패스워드가 아닙니다")
    private String password;

    @Email(message = "올바른 이메일 형식이 아닙니다")
    @NotBlank(message = "올바른 이메일 형식이 아닙니다")
    private String email;


}
