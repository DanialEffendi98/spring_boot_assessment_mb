package com.example.assessment.dto.response;

public class GetSingleUserResponse {

    private String userId;
    private String email;
    private String location;
    private String message;

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
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "GetSingleUserResponse [userId=" + userId + ", email=" + email + ", location=" + location + ", message="
                + message + "]";
    }    
}
