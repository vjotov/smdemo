package com.jotov.smdemo.sm.action;

import com.jotov.smdemo.domain.MessageEvent;
import com.jotov.smdemo.domain.MessageStatus;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class ErrorAction implements Action<MessageStatus, MessageEvent> {
    @Override
    public void execute(StateContext<MessageStatus, MessageEvent> stateContext) {
        System.out.println("Error Action");
    }
}
