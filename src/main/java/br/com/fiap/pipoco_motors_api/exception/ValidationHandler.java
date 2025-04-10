package br.com.fiap.pipoco_motors_api.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class ValidationHandler {

    record ValidationErrorMessage(String field, String message) {
        public ValidationErrorMessage(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ValidationErrorMessage> handle(MethodArgumentNotValidException e) {
        return e.getFieldErrors()
                .stream()
                .map(ValidationErrorMessage::new)
                .toList();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ValidationErrorMessage> handle(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof InvalidFormatException cause) {
            String fieldName = cause.getPath().get(0).getFieldName();
            return List.of(new ValidationErrorMessage(fieldName, "Formato inválido para o campo"));
        }

        return List.of(new ValidationErrorMessage("erro", "Dados mal formatados"));
    }
}
