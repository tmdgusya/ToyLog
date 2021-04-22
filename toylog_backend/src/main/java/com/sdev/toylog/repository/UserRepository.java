package com.sdev.toylog.repository;

import com.sdev.toylog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    List<User> findAll();

    boolean existsByUserId(String userId);

    boolean existsByEmail(String email);

}
