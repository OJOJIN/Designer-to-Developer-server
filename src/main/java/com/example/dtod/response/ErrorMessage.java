package com.example.dtod.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorMessage {

    SUCCESS(OK, true,  "요청에 성공하였습니다."),
    INTERVAL_SERVER_ERROR(INTERNAL_SERVER_ERROR, false,"요청을 처리하는 과정에서 서버가 예상하지 못한 오류가 발생하였습니다."),
    USER_NOT_FOUND(NOT_FOUND, false, "해당 회원을 찾을 수 없습니다."),
    CATEGORY_NOT_FOUND(NOT_FOUND, false, "해당 회원의 카테고리를 찾을 수 없습니다."),
    WRONG_PASSWORD(NOT_FOUND, false, "비밀번호가 맞지 않습니다."),
    WRONG_POST(NOT_FOUND,false,"해당 포스트를 찾을 수 없습니다."),
    FOLLOW_NOT_FOUND(NOT_FOUND, false, "팔로잉을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(NOT_FOUND, false, "댓글을 찾을 수 없습니다"),
    INVALID_FILE_UPLOAD(BAD_REQUEST, false, "파일 업로드에 실패하였습니다."),
    INVALID_FORMAT(BAD_REQUEST, false, "형식에 맞지 않습니다."),
    POST_NOT_FOUND(NOT_FOUND, false, "포스트를 찾을 수 없습니다."),
    ALREADY_SIGNUPED_EMAIL_USER(BAD_REQUEST, false, "이미 회원가입한 유저입니다."),

    ALREADY_EXISTED_ARTICLE(BAD_REQUEST, false, "이미 존재하는 기사입니다."),
    ARTICLE_NOT_FOUND(NOT_FOUND, false, "해당 기업을 찾을 수 없습니다."),

    ALREADY_EXISTED_COMPANY(BAD_REQUEST, false, "이미 존재하는 기업입니다."),
    COMPANY_NOT_FOUND(NOT_FOUND, false, "해당 기업을 찾을 수 없습니다.");


    private final int code;
    private final boolean isSuccess;
    private final String message;

    ErrorMessage(HttpStatus code, boolean isSuccess, String message) {
        this.code = code.value();
        this.isSuccess = isSuccess;
        this.message = message;
    }
}