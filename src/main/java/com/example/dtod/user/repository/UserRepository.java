package com.example.dtod.user.repository;

import com.example.dtod.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    Boolean existsUserByUserId(String userId);
}
