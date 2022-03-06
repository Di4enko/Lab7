package com.es.WebChat.entity;

import java.util.UUID;

public class ChatUser {
    private String userKey;
    private String name;
    private long lastInteractionTime;
    private String sessionId;

    public ChatUser(String name,long lastInteractionTime,String sessionId) {
        super();
        this.userKey = UUID.randomUUID().toString();
        this.name = name;
        this.lastInteractionTime = lastInteractionTime;
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLastInteractionTime() {
        return lastInteractionTime;
    }

    public void setLastInteractionTime(long lastInteractionTime) {
        this.lastInteractionTime = lastInteractionTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
}
