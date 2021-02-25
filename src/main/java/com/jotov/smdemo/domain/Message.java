package com.jotov.smdemo.domain;

import lombok.Data;

@Data
public class Message {
    private String message;
    private Integer level = 1;
    private Integer likes = 0;
    private MessageStatus state;
}
