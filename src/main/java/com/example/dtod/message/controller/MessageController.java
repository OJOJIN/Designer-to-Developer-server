package com.example.dtod.message.controller;

import com.example.dtod.message.dto.request.MessageCreateRequestDto;
import com.example.dtod.message.dto.request.MessageGetAllRequestDto;
import com.example.dtod.message.dto.response.MessageCreateResponseDto;
import com.example.dtod.message.dto.response.MessageDeleteResponseDto;
import com.example.dtod.message.dto.response.MessageGetAllResponseDto;
import com.example.dtod.message.entity.Message;
import com.example.dtod.message.service.MessageService;
import com.example.dtod.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    public BaseResponseDto<MessageGetAllResponseDto> findAll(
            @RequestParam Long id){
        List<Message> messages = messageService.getMessagesByRequestUserId(id);
        log.info("messages: {}", messages);
        return new BaseResponseDto<>(new MessageGetAllResponseDto(messages));
    }

    @PostMapping("")
    public BaseResponseDto<MessageCreateResponseDto> create(
            @RequestBody MessageCreateRequestDto messageCreateRequestDto){
        Message newMessage = messageService.createMessage(new Message(
                messageCreateRequestDto.getRequestUserId(),
                messageCreateRequestDto.getResponseUserId()));
        return new BaseResponseDto<>(new MessageCreateResponseDto(newMessage.getId()));
    }

    @DeleteMapping("")
    public BaseResponseDto<MessageDeleteResponseDto> delete(
            @RequestParam Long id){
        messageService.deleteMessage(id);
        return new BaseResponseDto<>(new MessageDeleteResponseDto(id));
    }
}
