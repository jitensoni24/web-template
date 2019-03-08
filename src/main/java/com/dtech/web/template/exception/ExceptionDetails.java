package com.dtech.web.template.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class ExceptionDetails {
    private String message;

    @JsonInclude(Include.NON_NULL)
    private Integer code;

    private int status;
    
    @JsonInclude(Include.NON_NULL)
    private String details;
    
    public ExceptionDetails() {}

    public ExceptionDetails(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public ExceptionDetails(String message, Integer code, int status, String details) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
