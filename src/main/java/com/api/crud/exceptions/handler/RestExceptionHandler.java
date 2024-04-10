package com.api.crud.exceptions.handler;

import com.api.crud.exceptions.UserNotFoundException;
import com.api.crud.models.ErrorDetail;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    /*
    * Clase controladora, que cuando una funcion que suelte una Excepcion "UserNotFoundException" llamara a este
    * controlador, gracias a la anotacion @ExceptionHandler, y en lugar de mandar una Exception como
    * respuesta al error, mandaremos un ResponseEntity<> para hacerlo mas amigable al cliente
    * */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception,
                                                         HttpServletRequest httpServletRequest) {
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimeStamp(new Date().getTime());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Recurso NO encontrado");
        errorDetail.setDetail(exception.getClass().getName());
        errorDetail.setDeveloperMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetail,null,HttpStatus.NOT_FOUND);
    }
}
