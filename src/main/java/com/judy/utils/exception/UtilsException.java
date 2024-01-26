package com.judy.utils.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 에러객체
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UtilsException extends RuntimeException {
    private String desc;

    public UtilsException() {}

    public UtilsException(String desc) {
        this.desc = desc;
    }
}
