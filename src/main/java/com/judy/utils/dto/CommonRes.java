package com.judy.utils.dto;

import lombok.Data;

/**
 * 공통 반환값
 */
@Data
public class CommonRes<T> {

    /**
     * 반환 데이터
     */
    private T data;

    /**
     * 결과코드, 성공 : 0
     */
    private String resCode;

    /**
     * 결과메세지
     */
    private String resMsg;

    public CommonRes() {}

    public CommonRes(T data) {
        this.data = data;
        this.resCode = "0";
    }

    public CommonRes(T data, String code, String msg) {
        this.data = data;
        this.resCode = code;
        this.resMsg = msg;
    }

}
