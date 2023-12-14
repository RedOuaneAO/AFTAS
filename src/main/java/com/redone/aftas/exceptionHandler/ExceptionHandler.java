package com.redone.aftas.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<ErrorResponseSimpleFormat> handleNoSuchElementException(
//            NoSuchElementException exception, HttpServletRequest request) {
//
//        errorSimpleResponse.setTimestamp(LocalDateTime.now());
//        errorSimpleResponse.setMessage("Resource Not Found");
//        errorSimpleResponse.setDetails(Collections.singletonList(exception.getMessage()));
//        errorSimpleResponse.setPath(request.getRequestURI());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorSimpleResponse);
//    }

}
