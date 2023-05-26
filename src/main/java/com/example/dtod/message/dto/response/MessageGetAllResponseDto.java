package com.example.dtod.message.dto.response;

import com.example.dtod.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MessageGetAllResponseDto {
    private List<Message> messages;
}
