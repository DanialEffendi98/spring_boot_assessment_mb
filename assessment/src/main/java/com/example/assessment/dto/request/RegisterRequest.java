package com.example.assessment.dto.request;

public class RegisterRequest {

    private String userId;
    private String email;
    private String location;

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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "UserAddRequest [userId=" + userId + ", email=" + email + ", location=" + location + "]";
    }
}
