package com.example.lts15_sept_2022;

public class responsemodel
{
    String message;

    public responsemodel(String message) {
        this.message = message;
    }

    public responsemodel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
