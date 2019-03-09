package com.dtech.web.template.exception;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
    
    @Autowired
    private MessageSource messageSource;
    
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionDetails handleAccessException(IllegalArgumentException e) {
        logger.debug(e);
        
        return new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
    
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ExceptionDetails handleAccessException(BindException e) {
        logger.debug(e);
        
        return new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
    
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidArgumentException.class)
    public ExceptionDetails handleException(InvalidArgumentException e) {
        logger.debug(e);
        
        String message = messageSource.getMessage(e.getMessage(), e.getArgs(), Locale.getDefault());

        return new ExceptionDetails(message, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionDetails handleException(NotFoundException e) {
        logger.debug(e);

        String message = messageSource.getMessage(e.getMessage(), null, Locale.getDefault());
        
        return new ExceptionDetails(message, e.getCode(), HttpStatus.NOT_FOUND.value(), null);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ExceptionDetails handleException(HttpRequestMethodNotSupportedException e) {
        logger.debug(e);
        
        return new ExceptionDetails(e.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.value());
    }    

    @ResponseBody
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ExceptionDetails handleException(DataIntegrityViolationException e) {
        logger.debug(e);
        
        //String message = e.getMessage().substring(0, e.getMessage().indexOf(";"));

        return new ExceptionDetails("to do", HttpStatus.CONFLICT.value());
    }
    
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionDetails handleException(Exception e) {
        logger.error(e);
        
        return new ExceptionDetails(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}