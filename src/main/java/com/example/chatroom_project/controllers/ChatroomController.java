package com.example.chatroom_project.controllers;


import com.example.chatroom_project.models.Chatroom;
import com.example.chatroom_project.models.Message;
import com.example.chatroom_project.models.User;
import com.example.chatroom_project.repositories.ChatroomRepository;
import com.example.chatroom_project.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;


//    GET
    @GetMapping
    public ResponseEntity<List<Chatroom>> displayAllChatrooms(){
        return new ResponseEntity<>(chatroomService.getAllChatrooms(), HttpStatus.OK);
    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Chatroom> displayChatroomById(@PathVariable Long id){
        return new ResponseEntity<>(chatroomService.getChatroomById(id), HttpStatus.OK);
    }

//    @GetMapping( value = "userId/{id}")
//    public ResponseEntity<List<Chatroom>> displayChatroomByUser(@PathVariable Long id){
//        return new ResponseEntity<>(chatroomService.getChatroomByUser(id), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Chatroom> createChatroom(@RequestBody Chatroom chatroom){
        return new ResponseEntity<>(chatroomService.createChatroom(chatroom), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Chatroom>> deleteChatroom(@PathVariable Long id){
        if (chatroomService.deleteChatroom(id) == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(chatroomService.deleteChatroom(id), HttpStatus.OK);
        }
    }

    @PatchMapping(value = "/addUser/{id}")
    public ResponseEntity<List<User>> addUserToChatroom(@PathVariable Long id, @RequestBody Long userId){
        if (chatroomService.addUserToChatroom(userId, id) == null){
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        } else {
            return new ResponseEntity<>(chatroomService.addUserToChatroom(userId, id), HttpStatus.OK);
        }
    }

    @PatchMapping(value = "/removeUser/{id}")
    public ResponseEntity<List<User>> removeUserFromChatroom(@PathVariable Long id, @RequestBody Long userId){
        try {
            return new ResponseEntity<>(chatroomService.removeUserFromChatroom(userId, id), HttpStatus.OK);
        } catch(NullPointerException e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/{id}/messages")
    public ResponseEntity<List<Message>> retrieveMessagesForChatroom(@PathVariable Long id){
        return new ResponseEntity<>(chatroomService.findMessagesForChatroomTimeDesc(id), HttpStatus.OK);

    }

}
