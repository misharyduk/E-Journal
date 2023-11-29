package com.ejournal.university.common.exception;

import com.ejournal.university.common.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> resourceNotFoundExceptionHandler(ResourceNotFoundException exception, WebRequest webRequestData){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(
                        webRequestData.getDescription(false),
                        HttpStatus.NOT_FOUND,
                        exception.getMessage(),
                        LocalDateTime.now()
                ));
    }

}
