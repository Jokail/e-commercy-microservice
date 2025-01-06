package com.jokail.product.handler;

import com.jokail.product.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductPurchaseException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(ProductPurchaseException exc) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exc.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exc) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exc.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exc) {
        var errors = new HashMap<String, String>();
        exc.getBindingResult().getAllErrors().forEach(error -> {
            {
                var fieldName = ((FieldError) error).getField();
                String defaultMessage = error.getDefaultMessage();
                errors.put(fieldName, defaultMessage);
            }
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }

}
