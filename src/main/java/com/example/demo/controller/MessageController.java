package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.model.User;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController  {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    //sve poruke za agenta(inbox)
    @GetMapping("/all")
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();

    }
    //poruke samo za agenta iz odredjene rezervacije
    @GetMapping("/byReservation/{idRez}")
    public List<Message> getMessagesByReservation(@PathVariable long idRez){
        return messageService.getByRezervacija(idRez);
    }
    //cela prepiska rezervacije
    @GetMapping("/allByReservation/{idRez}")
    public List<Message> getAllMessagesByReservation(@PathVariable long idRez){
        return messageService.getAllByRezervacija(idRez);
    }
    //salje se poruka za klijenta
    @PostMapping("/send")
    public Message sendMessageToClient(@RequestBody Message message){
        return messageService.saveMessage(message);
    }
}
