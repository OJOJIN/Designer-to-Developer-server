package com.example.dtod.user.controller;

import com.example.dtod.response.BaseResponseDto;
import com.example.dtod.user.dto.request.UserSignInRequestDto;
import com.example.dtod.user.repository.UserRepository;
import com.example.dtod.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.dtod.response.ErrorMessage.ALREADY_SIGNUPED_EMAIL_USER;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public BaseResponseDto<Long> signIn(@RequestBody UserSignInRequestDto userSignInRequestDto){
        Long userId = userService.signInUser(userSignInRequestDto);
        if(userId == -1) return new BaseResponseDto(ALREADY_SIGNUPED_EMAIL_USER);
        else return new BaseResponseDto(userId);
    }
}
