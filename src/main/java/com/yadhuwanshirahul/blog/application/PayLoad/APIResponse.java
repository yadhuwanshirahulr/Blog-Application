package com.yadhuwanshirahul.blog.application.PayLoad;

public class APIResponse {
    private String message;

    public APIResponse(String message,boolean status) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
