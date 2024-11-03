package br.com.fiap.coleta.exception;

import br.com.fiap.coleta.view.ErrorView;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RESTExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorView handleUsernameNotFound(UsernameNotFoundException exception, HttpServletRequest request) {
        return new ErrorView(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                exception.getMessage(),
                request.getServletPath()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView handleServerError(Exception exception, HttpServletRequest request) {
        return new ErrorView(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                exception.getMessage(),
                request.getServletPath()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorView handleValidationError(MethodArgumentNotValidException exception, HttpServletRequest request) {
        Map<String, String> errorMessage = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(e -> errorMessage.put(
                        e.getField(),
                        e.getDefaultMessage()));
        return new ErrorView(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                errorMessage.toString(),
                request.getServletPath()
        );
    }
}
