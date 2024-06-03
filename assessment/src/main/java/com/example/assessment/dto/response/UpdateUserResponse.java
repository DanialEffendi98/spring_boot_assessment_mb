package com.example.assessment.dto.response;

public class UpdateUserResponse {
    
    String userId;
    String message;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "UpdateUserResponse [userId=" + userId + ", message=" + message + "]";
    }
}
