package com.example.dtod.user.service;
import com.example.dtod.user.dto.request.UserSignInRequestDto;
import com.example.dtod.user.entity.User;
import com.example.dtod.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long signInUser(UserSignInRequestDto userSignInRequestDto) {
        if(userRepository.existsUserByUserId(userSignInRequestDto.getUserId())){
            return (long) -1;
        }

        User signInUser = User.builder()
                .userId(userSignInRequestDto.getUserId())
                .password(userSignInRequestDto.getPassword())
                .nickname(userSignInRequestDto.getNickname())
                .category(userSignInRequestDto.getCategory())
                .build();

        userRepository.save(signInUser);
        return signInUser.getId();
    }
}
