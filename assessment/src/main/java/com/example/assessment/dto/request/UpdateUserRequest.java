package com.example.assessment.dto.request;

public class UpdateUserRequest {
    
    String userId;
    String email;
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "UpdateUserRequest [userId=" + userId + ", email=" + email + "]";
    }
}
