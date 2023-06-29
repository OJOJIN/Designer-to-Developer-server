//package com.example.dtod.websocket;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.stereotype.Controller;
//
//@Slf4j
//@Controller
//@RequiredArgsConstructor
//public class SocketMessageController {
//
//    private final SimpMessageSendingOperations simpMessageSendingOperations;
//
//    @MessageMapping("/hello")
//    public void message(SocketMessage message) {
//        simpMessageSendingOperations.convertAndSend("/sub/channel/" + message.getChannelId(), message);
//        log.info("message : \n{}\n{}\n{}", message.getContent(), message.getSender(), message.getChannelId());
//    }
//}
