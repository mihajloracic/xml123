package com.example.demo.repository;


import com.example.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    List<Message> findByRezervacija_IdAndAgentFalse(long resId);

    List<Message> findByAgentFalse();

    List<Message> findByRezervacija_Id(long resId);

}
