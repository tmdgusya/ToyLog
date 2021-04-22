package com.sdev.toylog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Getter
@Entity
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

}
