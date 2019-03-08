package com.dtech.web.template.exception;

public class InvalidArgumentException extends RuntimeException {
    
    private static final long serialVersionUID = -6524052241387391908L;

    private Object[] args;

    public InvalidArgumentException(String message) {
        super(message);
     }
    
    public InvalidArgumentException(String message, Object... args) {
        super(message);
        this.args = args;
    }
    
    public Object[] getArgs() {
        return args;
    }
}
