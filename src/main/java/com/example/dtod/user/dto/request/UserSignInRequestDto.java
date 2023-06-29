package com.example.dtod.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInRequestDto {

    private String userId;

    private String password;

    private String nickname;

    private String category;
}
