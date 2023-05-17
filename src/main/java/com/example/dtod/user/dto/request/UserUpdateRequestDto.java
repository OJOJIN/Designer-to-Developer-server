package com.example.dtod.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateRequestDto {

    private Long id;

    private String userId;

    private String password;

    private String nickname;

    private String category;
}
