package com.ejournal.university.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ErrorDto {

    private String path;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;

}
