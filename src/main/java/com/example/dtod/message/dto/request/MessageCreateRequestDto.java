package com.example.dtod.message.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageCreateRequestDto {

    private String requestUserId;
    private String responseUserId;
}
