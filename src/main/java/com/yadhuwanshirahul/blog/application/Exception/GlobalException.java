package com.yadhuwanshirahul.blog.application.Exception;

import com.yadhuwanshirahul.blog.application.PayLoad.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundException(ResourceNotFoundException e){
        String message = e.getMessage();
        APIResponse response = new APIResponse(message,false);
        return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodNotFoundArgument(MethodArgumentNotValidException ex){
        Map<String,String> res = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            res.put(fieldName,message);
        });
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }
}
