package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        long status = HttpStatus.BAD_REQUEST.value();
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(status, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler({ExistedUserException.class})
    public ResponseEntity<ErrorResult> handle(ExistedUserException ex) {
        long status = HttpStatus.NOT_FOUND.value();
        ErrorResult errorResult = new ErrorResult(status, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);

    }

    @ExceptionHandler({UserLoginException.class})
    public ResponseEntity<ErrorResult> handle(UserLoginException ex) {
        long status = HttpStatus.NOT_FOUND.value();
        ErrorResult errorResult = new ErrorResult(status, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }
}
