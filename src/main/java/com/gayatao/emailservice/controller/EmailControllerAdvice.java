package com.gayatao.emailservice.controller;

import com.gayatao.emailservice.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
public class EmailControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponseDTO> handleException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            log.error("Invalid {} value submitted for {}",
                    fieldError.getRejectedValue(), fieldError.getField());
            errors.add("field: " + fieldError.getField() + " reason: " + fieldError.getRejectedValue());
        });


        return new ResponseEntity<>(ErrorResponseDTO.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Field errors encountered: " + errors)
                .build(), HttpStatus.BAD_REQUEST);
    }
}
