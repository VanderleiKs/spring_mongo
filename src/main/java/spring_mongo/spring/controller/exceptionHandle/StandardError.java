package spring_mongo.spring.controller.exceptionHandle;

import java.time.LocalDateTime;

public class StandardError {

    LocalDateTime timeStamp;
    Integer status;
    String message;
    String request;

    public StandardError(LocalDateTime timeStamp, Integer status, String message, String request) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
        this.request = request;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    
}
