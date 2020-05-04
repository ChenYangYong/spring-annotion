package com.web.result;

import org.apache.commons.lang.StringUtils;

public enum ExceptionResult {
    /**
     * Bad licence type
     */
    BAD_LICENCE_TYPE("7001", "Bad licence type."),
    /**
     * Licence not found
     */
    LICENCE_NOT_FOUND("7002", "Licence not found.")
    ;


    private ExceptionResult(String code,String msg){
        this.code = code;
        this.msg = msg;
    }
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;

    public Result result() {
        return new Result(this.code,this.msg);
    }
}
