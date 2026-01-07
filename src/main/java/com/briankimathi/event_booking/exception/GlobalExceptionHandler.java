package com.briankimathi.event_booking.exception;

import com.briankimathi.event_booking.dto.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse> handleValidationException(ValidationException ex) {
        String msg = ex.getMessage();

        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .data(null)
                .message(msg)
                .timestamp(LocalDateTime.now())
                .build());
    }

}
