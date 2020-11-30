package spring_mongo.spring.controller.exceptionHandle;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import spring_mongo.spring.domain.exception.UserException;

@ControllerAdvice
@RestControllerAdvice
public class ResourceExceptionHandle extends ResponseEntityExceptionHandler{

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> userNotFound(UserException ex, HttpServletRequest request){
            HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(status)
                .body(new StandardError(LocalDateTime.now(), status.value(), ex.getMessage(), request.getRequestURI()));
    }
    
}
