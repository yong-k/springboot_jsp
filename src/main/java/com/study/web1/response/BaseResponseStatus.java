package com.study.web1.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 200: 요청 성공
     */
    SUCCESS(true, HttpStatus.OK.value(), "요청 성공"),


    /**
     * 400: Request, Response 오류
     */
    USERS_EMPTY_REQUIRED(false, HttpStatus.BAD_REQUEST.value(), "필수정보를 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, HttpStatus.BAD_REQUEST.value(), "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_USERNAME(false,HttpStatus.BAD_REQUEST.value(),"이미 사용중인 닉네임입니다."),
    POST_USERS_EXISTS_EMAIL(false,HttpStatus.BAD_REQUEST.value(),"이미 사용중인 이메일입니다."),
    RESPONSE_ERROR(false, HttpStatus.NOT_FOUND.value(), "값을 불러오는데 실패하였습니다."),
    NOT_FIND_USER(false,HttpStatus.NOT_FOUND.value(),"일치하는 회원이 없습니다."),
    INVALID_PAGE(false,HttpStatus.NOT_FOUND.value(), "존재하지 않는 페이지입니다."),


    /**
     * 500: Database, Server 오류
     */
    DATABASE_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 연결 실패"),
    SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버 연결에 실패"),

    INSERT_FAIL_USER(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),"회원 등록 실패"),
    MODIFY_FAIL_USER(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),"회원 정보 수정 실패"),
    DELETE_FAIL_USER(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),"회원 삭제 실패"),

    UNEXPECTED_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "예상치 못한 에러가 발생했습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;

    BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
