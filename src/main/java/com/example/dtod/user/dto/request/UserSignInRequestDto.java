package com.example.dtod.user.dto.request;


import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class UserSignInRequestDto {

    private String userId;

    private String password;

    private String nickname;

    private String category;
}
