package com.example.chatroom_project.models;

import java.time.LocalTime;

public class MessageDTO {//POJO

//    PROPERTIES

    private String message;
    private LocalTime time;
    private Long chatroomId;
    private Long userId;

//    CONSTRUCTOR

    public MessageDTO(String message, LocalTime time, Long chatroomId, Long userId){
        this.message = message;
        this.time = time;
        this.chatroomId = chatroomId;
        this.userId = userId;
    }

//    DEFAULT CONSTRUCTOR

    public MessageDTO(){

    }


//    GETTERS AND SETTERS

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
