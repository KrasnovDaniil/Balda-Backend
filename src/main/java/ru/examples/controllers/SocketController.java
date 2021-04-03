package ru.examples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import ru.examples.dtos.MessageDto;
import ru.examples.models.Message;
import ru.examples.models.MessageType;
import ru.examples.repositories.MessageRepository;
import ru.examples.services.implementations.MessageServiceImpl;


import static java.lang.String.format;

@Controller
public class SocketController {

    private final MessageRepository messageRepo;
    private final SimpMessageSendingOperations messagingTemplate;
    private final MessageServiceImpl messageService;

    @Autowired
    public SocketController(MessageRepository messageRepo, SimpMessageSendingOperations messagingTemplate, MessageServiceImpl messageService){
        this.messageRepo = messageRepo;
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    // 2-nd place where request will process by this method or controller on tag "/hello" like "app/hello"
    @MessageMapping("/hello") // get request from this
    @SendTo("/topic/method") // and send to this
    public void greeting(Message msg) throws InterruptedException {
        System.out.println("got from client");
        messageRepo.save(msg); // successfully stored in the DB
    }

    // send received message from client to this one
    @MessageMapping ("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload MessageDto messageDto){
        Message castedMessage = null;
        try {
            castedMessage = messageService.castDto2Entity(messageDto);
            messageRepo.save(castedMessage);
            messagingTemplate.convertAndSend(format("/chat-channel/%s", roomId), messageDto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @MessageMapping("/chat/{room_name}/addUser")
    public void addUser(@DestinationVariable String room_name, @Payload MessageDto chatMessageDto,
                        SimpMessageHeaderAccessor headerAccessor) {
        String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_name", room_name);
        if (currentRoomId != null) {
            MessageDto leaveMessage = MessageDto.builder()
                    .type(MessageType.LEAVE)
                    .sender(chatMessageDto.getSender()).build();
            messagingTemplate.convertAndSend(format("/chat-channel/%s", currentRoomId), leaveMessage);
        }
        headerAccessor.getSessionAttributes().put("username", chatMessageDto.getSender());
        messagingTemplate.convertAndSend(format("/chat-channel/%s", room_name), chatMessageDto);
    }

    @MessageMapping("/chat/{roomId}/deleteUser")
    public void deleteUser(@DestinationVariable String roomId, @Payload Message chatMessage){

    }

}
