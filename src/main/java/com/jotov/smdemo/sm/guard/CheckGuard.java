package com.jotov.smdemo.sm.guard;

import com.jotov.smdemo.domain.MessageEvent;
import com.jotov.smdemo.domain.MessageStatus;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;


public class CheckGuard implements Guard<MessageStatus, MessageEvent> {
    @Override
    public boolean evaluate(StateContext<MessageStatus, MessageEvent> context) {
        System.out.print("Checking the message");
        return false;

    }


}
