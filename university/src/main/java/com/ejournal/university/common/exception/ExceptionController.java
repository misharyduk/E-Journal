package com.ejournal.university.common.exception;

import com.ejournal.university.common.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static com.ejournal.university.common.util.ServiceConstants.*;

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

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorDto> entityAlreadyExistsExceptionHandler(EntityAlreadyExistsException exception, WebRequest webRequestData){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(
                        webRequestData.getDescription(false),
                        HttpStatus.BAD_REQUEST,
                        exception.getMessage(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorDto> globalExceptionHandler(Throwable throwable, WebRequest webRequestData){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDto(
                        webRequestData.getDescription(false),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        STATUS_MESSAGE_500,
                        LocalDateTime.now()
                ));
    }

}
