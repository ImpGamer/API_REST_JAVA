package com.api.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Si suelta la exepcion, con que codigo de estado HTTP lo hara, en este caso un 404
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public UserNotFoundException(String message) {
        super(message);
    }

}
