package com.jotov.smdemo.service;

import com.jotov.smdemo.domain.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class NewsServiceImpl implements  NewsService {
    HashMap<Integer, Message> messages = new HashMap<>();
    Integer lastMessageId = 0;

    @Override
    public void createMessage(Message message){
        lastMessageId++;
        messages.put(lastMessageId, message);
    }
}
