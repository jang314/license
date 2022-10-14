package com.mnwise.wiseu.license.validator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message<T> {
    private Status code;
    private String message;
    private T data;

    @Builder
    public Message(Status code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
