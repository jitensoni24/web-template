package com.dtech.web.template.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private Logger logger = Logger.getLogger(ExceptionControllerAdvice.class);
    
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
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ExceptionDetails handleAccessException(InvalidDataAccessApiUsageException e) {
        logger.debug(e);
        
        return new ExceptionDetails("to do", HttpStatus.BAD_REQUEST.value());
    }
    
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidArgumentException.class)
    public ExceptionDetails handleException(InvalidArgumentException e) {
        logger.debug(e);
        
        return new ExceptionDetails("to do", HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionDetails handleException(MethodArgumentNotValidException e) {
        logger.debug(e);
        
        FieldError error = (FieldError) e.getBindingResult().getAllErrors().get(0);

        if (error.getDefaultMessage().contains(" ")) {
            List<Object> args = new ArrayList<Object>();
            args.add(error.getField().replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2"));
            args.add(error.getDefaultMessage().replaceAll("\"", ""));

            return new ExceptionDetails("to do", HttpStatus.BAD_REQUEST.value());
        } else {
            List<Object> args = new ArrayList<Object>();
            args.add("arg 1");
            args.add("arg 2");

            return new ExceptionDetails("to do", HttpStatus.BAD_REQUEST.value());
        }
    }
        
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ExceptionDetails handleException(HttpMessageNotReadableException e) {
        logger.debug(e);
        
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException exception = (InvalidFormatException) e.getCause();

            if (!exception.getPath().isEmpty()) {
                String message = null;
                if (exception.getTargetType() == Boolean.class) {
                    message = "must match the values [true, false]";
                } else if (Number.class.isAssignableFrom(exception.getTargetType())) {
                    message = "must match a number";
                } else if (exception.getTargetType().isEnum()) {
                    message = "must match the values " + Arrays.asList(exception.getTargetType().getEnumConstants()).toString();
                }

                return new ExceptionDetails("The field '" + exception.getPath().get(0).getFieldName() + "' " + message, HttpStatus.BAD_REQUEST.value());
            }
        } else if (e.getCause() instanceof UnrecognizedPropertyException) {
            UnrecognizedPropertyException exception = (UnrecognizedPropertyException) e.getCause();
            
            return new ExceptionDetails("The field '" + exception.getPropertyName() + "' is not a valid field", HttpStatus.BAD_REQUEST.value());
        }

        return new ExceptionDetails(e.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionDetails handleException(NotFoundException e) {
        logger.debug(e);

        return new ExceptionDetails("to do", e.getCode(), HttpStatus.NOT_FOUND.value(), null);
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ExceptionDetails handleAccessException(EmptyResultDataAccessException e) {
        logger.debug(e);
        
        //String message = e.getMessage().substring(0, e.getMessage().indexOf(";"));

        return new ExceptionDetails("to do", HttpStatus.NOT_FOUND.value());
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