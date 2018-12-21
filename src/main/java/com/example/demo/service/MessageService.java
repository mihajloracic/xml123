package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.model.Rezervacija;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.RezervisanSmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private RezervisanSmestajRepository rezervisanSmestajRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, RezervisanSmestajRepository rezervisanSmestajRepository){
        this.messageRepository = messageRepository;
        this.rezervisanSmestajRepository = rezervisanSmestajRepository;
    }

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }
    public void saveMessages(List<Message> messageList){
        messageRepository.saveAll(messageList);
    }

    public List<Message> getByRezervacija(Long rezervacijaId){
       return messageRepository.findByRezervacija_IdAndAgentFalse(rezervacijaId);
    }

    public List<Message> getAllByRezervacija(Long rezervacijaId){
        return messageRepository.findByRezervacija_Id(rezervacijaId);
    }
    public List<Message> getAllMessages(){
        return messageRepository.findByAgentFalse();
    }



}
