package com.example.webfluxdemo.common;

import lombok.Getter;

@Getter
public enum ResponseCode {

    FAIL_100("해당 입력은 잘못되었습니다. 다시 입력해 주시기 바랍니다.", 100);

    private String message;
    private int code;

    ResponseCode(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
