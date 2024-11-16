package com.example.Helpdesk.model;

import java.time.LocalDateTime;

public class Msg {
    private String message;
    private LocalDateTime time;

    public Msg(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
