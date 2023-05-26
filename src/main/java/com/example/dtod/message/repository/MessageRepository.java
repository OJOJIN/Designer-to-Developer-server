package com.example.dtod.message.repository;

import com.example.dtod.message.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findAllByRequestUserIdOrResponseUserId(Long rsId, Long rpId);
}
