package com.dtech.web.template.exception;


public class NotFoundException  extends RuntimeException {
    
    private static final long serialVersionUID = -1535299592674958163L;
    
    private Integer code;
    
    public NotFoundException(String string) {}
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
