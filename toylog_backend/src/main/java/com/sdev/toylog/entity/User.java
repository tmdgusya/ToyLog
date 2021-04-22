package com.sdev.toylog.entity;

import com.sdev.toylog.dto.request.UserLoginRequest;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Builder
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String userId;

    @Column(length = 80, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(columnDefinition = "BIT", length = 1, nullable = false)
    @ColumnDefault("false")
    private boolean authentication;

    public boolean isMatchedPassword(String encryptPassword) {
        return password.equals(encryptPassword);
    }

}
