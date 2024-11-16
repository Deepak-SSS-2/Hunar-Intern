package com.example.Helpdesk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;

public class Person {
    private final UUID id;
    private final String name;
    private String tempMsg;
    private final ArrayList<Msg> userMsg;
    private final ArrayList<Msg> adminMsg;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name,@JsonProperty("msg") String tempMsg,ArrayList<Msg> userMsg, ArrayList<Msg> adminMsg) {
        this.id = id;
        this.name = name;
        this.tempMsg = tempMsg;
        this.userMsg = userMsg;
        this.adminMsg = adminMsg;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Msg> getUserMsg() {
        return userMsg;
    }

    public ArrayList<Msg> getAdminMsg() {
        return adminMsg;
    }

    public String getTempMsg() {
        return tempMsg;
    }
}
