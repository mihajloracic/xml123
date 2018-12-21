package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Rezervacija rezervacija;
    private String message;
    private boolean agent = true;

    public Message(){}

    public Message(long id, Rezervacija rezervacija, String message, boolean agent) {
        this.id = id;
        this.rezervacija = rezervacija;
        this.message = message;
        this.agent = agent;
    }

    @Autowired


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getAgent() {
        return agent;
    }

    public void setAgent(boolean agent) {
        agent = agent;
    }
}
