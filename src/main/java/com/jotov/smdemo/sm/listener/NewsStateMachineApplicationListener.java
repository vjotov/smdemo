package com.jotov.smdemo.sm.listener;

import com.jotov.smdemo.domain.MessageEvent;
import com.jotov.smdemo.domain.MessageStatus;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

public class NewsStateMachineApplicationListener implements StateMachineListener<MessageStatus, MessageEvent> {

    @Override
    public void stateChanged(State<MessageStatus, MessageEvent> from, State<MessageStatus, MessageEvent> to) {
        if(from != null)
            System.out.println("Переход из статуса " + from.getId() + " в статус " + to.getId());
    }

    @Override
    public void stateEntered(State<MessageStatus, MessageEvent> state) {

    }

    @Override
    public void stateExited(State<MessageStatus, MessageEvent> state) {

    }

    @Override
    public void eventNotAccepted(Message<MessageEvent> event) {
        System.out.println("Евент не принят " + event);
    }

    @Override
    public void transition(Transition<MessageStatus, MessageEvent> transition) {

    }

    @Override
    public void transitionStarted(Transition<MessageStatus, MessageEvent> transition) {

    }

    @Override
    public void transitionEnded(Transition<MessageStatus, MessageEvent> transition) {

    }

    @Override
    public void stateMachineStarted(StateMachine<MessageStatus, MessageEvent> stateMachine) {

    }

    @Override
    public void stateMachineStopped(StateMachine<MessageStatus, MessageEvent> stateMachine) {

    }

    @Override
    public void stateMachineError(StateMachine<MessageStatus, MessageEvent> stateMachine, Exception e) {

    }

    @Override
    public void extendedStateChanged(Object o, Object o1) {

    }

    @Override
    public void stateContext(StateContext<MessageStatus, MessageEvent> stateContext) {

    }
}
