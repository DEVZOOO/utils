package com.judy.utils.exception;

import com.judy.utils.dto.CommonRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 에러 공통 처리
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(UtilsException.class)
    public ResponseEntity<CommonRes> utilsException(UtilsException e) {
        log.error("............... UtilsException :: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(new CommonRes(null, e.getDesc(), e.getDesc()));
    }
}
