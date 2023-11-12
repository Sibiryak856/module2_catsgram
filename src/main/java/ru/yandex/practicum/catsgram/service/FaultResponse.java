package ru.yandex.practicum.catsgram.service;

public class FaultResponse {

    private String message;

    public FaultResponse() {
    }

    public FaultResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

