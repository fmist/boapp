package ru.rzik.bo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BoGlobalExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<BoErrorData> handleException(BoException exception) {
        BoErrorData errorData = new BoErrorData();
        errorData.setInfo(exception.getMessage());
        return new ResponseEntity<>(errorData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<BoErrorData> handleException(Exception exception) {
        BoErrorData errorData = new BoErrorData();
        errorData.setInfo(exception.getMessage());
        return new ResponseEntity<>(errorData, HttpStatus.BAD_REQUEST);
    }
}
