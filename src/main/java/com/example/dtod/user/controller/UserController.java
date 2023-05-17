package com.example.dtod.user.controller;

import com.example.dtod.post.dto.request.PostUpdateRequestDto;
import com.example.dtod.response.BaseResponseDto;
import com.example.dtod.user.dto.request.UserSignInRequestDto;
import com.example.dtod.user.dto.request.UserUpdateRequestDto;
import com.example.dtod.user.dto.response.UserSignInResponseDto;
import com.example.dtod.user.dto.response.UserUpdateResponseDto;
import com.example.dtod.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.example.dtod.response.ErrorMessage.ALREADY_SIGNUPED_EMAIL_USER;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원가입
    @PostMapping("")
    public BaseResponseDto<UserSignInResponseDto> create(@RequestBody UserSignInRequestDto userSignInRequestDto){
        Long userId = userService.signInUser(userSignInRequestDto);
        if(userId == -1) return new BaseResponseDto(ALREADY_SIGNUPED_EMAIL_USER);
        else return new BaseResponseDto(new UserSignInResponseDto(userId));
    }

    // 유저삭제
    @DeleteMapping("")
    public BaseResponseDto<Boolean> delete(@RequestParam Long id){
        Boolean success = userService.delete(id);

        return new BaseResponseDto(success);
    }

    // 유저 수정
    @PatchMapping("")
    public BaseResponseDto<UserUpdateResponseDto> update(@RequestPart UserUpdateRequestDto userUpdateRequestDto,
                                                         @RequestPart MultipartFile file) throws IOException {
        return new BaseResponseDto<>(userService.update(userUpdateRequestDto, file));
    }


}
