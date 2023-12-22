package com.redone.aftas.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;



@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String,Object>> handleRuntimeException(RuntimeException ex) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("status","error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,Object>> handleValidationExceptions(MethodArgumentNotValidException ex, BindingResult bindingResult) {
        Map<String,Object> response = new HashMap<>();
        String errors="" ;
        if(bindingResult.hasErrors()){
            for(ObjectError error:bindingResult.getAllErrors()){
                errors = error.getDefaultMessage();
            }
        }
        response.put("message",errors );
        response.put("status","error");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
