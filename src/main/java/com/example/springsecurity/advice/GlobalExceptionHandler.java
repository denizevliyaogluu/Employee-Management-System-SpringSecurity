package com.example.springsecurity.advice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<APIError> validationException(
            ValidationException ex,
            HttpServletRequest request){

        log.error("validation exception : "+
                ex.getLocalizedMessage()+
                " for "+
                request.getRequestURI() );

        return new ResponseEntity<>(
                APIError.builder()
                        .errorMessage(ex.getLocalizedMessage())
                        .errorCode(HttpStatus.BAD_REQUEST.toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .customMessage("Istek gecerli degil")
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<APIError> genericException(
            Exception ex,
            HttpServletRequest request){

        log.error("exception : "+
                ex.getLocalizedMessage()+
                " for "+
                request.getRequestURI() );

        return new ResponseEntity<>(
                APIError.builder()
                        .errorMessage(ex.getLocalizedMessage())
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .customMessage("Istek islenemedi")
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
