package com.ejournal.group.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDto {
    private final String statusCode;
    private final String statusMessage;

    public ResponseDto(String statusCode, String statusMessage){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "statusCode='" + statusCode + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
