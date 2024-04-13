package com.ejournal.group.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String resourceType, String field, String value) {
        super(String.format("%s is already exists with given %s= %s", resourceType, field, value));
    }

    public EntityAlreadyExistsException(Throwable cause) {
        super(cause);
    }

}
