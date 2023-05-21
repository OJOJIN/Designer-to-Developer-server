package com.example.dtod.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginInRequestDto {

    private String userId;

    private String password;

}
