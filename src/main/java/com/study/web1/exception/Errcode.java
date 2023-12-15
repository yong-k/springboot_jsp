package com.study.web1.exception;

public class Errcode {
    /**
     * [[ errcode ]]
     * default: 예상치 못한 오류가 발생했습니다.
     * 1: 존재하지 않는 회원입니다.
     * 2: 시스템에 문제가 발생했습니다. 다시 시도해주세요.
     * */
    public static final int NOT_EXIST_USER = 1;
    public static final int SYSTEM_PROBLEM = 2;
}
