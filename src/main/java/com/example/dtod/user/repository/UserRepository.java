package com.example.dtod.user.repository;

import com.example.dtod.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByUserId(String userId);

    Boolean existsUserById(Long id);
}
