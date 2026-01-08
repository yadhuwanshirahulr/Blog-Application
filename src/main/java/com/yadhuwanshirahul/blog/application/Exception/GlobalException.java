package com.yadhuwanshirahul.blog.application.Exception;

import com.yadhuwanshirahul.blog.application.PayLoad.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        APIResponse response = new APIResponse(message,false);
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
