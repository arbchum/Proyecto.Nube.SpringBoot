package com.proyecto.nube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(FileValidationException.class)
//    public ResponseEntity<String> handleFileValidation(
//            FileValidationException ex) {
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(ex.getMessage());
//    }
//
//    @ExceptionHandler(ReportGenerationException.class)
//    public ResponseEntity<String> handleReportGeneration(
//            ReportGenerationException ex) {
//
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ex.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(
            Exception ex) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error inesperado");
    }
}
