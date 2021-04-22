package com.sdev.toylog.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class EmailCheckRequest {

    @Email(message = "올바른 이메일 형식이 아닙니다")
    @NotBlank(message = "올바른 이메일 형식이 아닙니다")
    private String email;

}
