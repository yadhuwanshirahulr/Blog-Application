package com.yadhuwanshirahul.blog.application.Exception;

public class ResourceNotFoundException extends RuntimeException{
    String message;
    String fieldName;
    String fieldValue;

    public ResourceNotFoundException(String message,String fieldName, String fieldValue) {
        super(String.format(
                "%s not found with %s : %s",
                message,
                fieldName,
                fieldValue
        ));
        this.message = message;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
