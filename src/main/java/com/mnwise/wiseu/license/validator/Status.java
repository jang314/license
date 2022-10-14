package com.mnwise.wiseu.license.validator;

public enum Status {
    OK(200),
    BAD_REQUEST(400),
    NOT_FOUNT(404),
    SERVER_ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }
}
