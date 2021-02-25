package com.jotov.smdemo.sm;

import com.jotov.smdemo.domain.MessageEvent;
import com.jotov.smdemo.domain.MessageStatus;
import com.jotov.smdemo.sm.action.ErrorAction;
import com.jotov.smdemo.sm.action.SubmitAction;
import com.jotov.smdemo.sm.guard.CheckGuard;
import com.jotov.smdemo.sm.listener.NewsStateMachineApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.EnumSet;

import static com.jotov.smdemo.domain.MessageStatus.*;

@Configuration
@EnableStateMachineFactory
public class SmConfig extends EnumStateMachineConfigurerAdapter<MessageStatus, MessageEvent> {
    @Override
    public void configure(StateMachineStateConfigurer<MessageStatus, MessageEvent> states) throws Exception {
        states
                .withStates()
                .initial(DRAFT)
                .end(PUBLISHED)
                .states(EnumSet.allOf(MessageStatus.class));
    }

    @Override
    public void configure(final StateMachineConfigurationConfigurer<MessageStatus, MessageEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new NewsStateMachineApplicationListener());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MessageStatus, MessageEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(DRAFT)
                .event(MessageEvent.SUBMIT)
                .guard(checkGuard())
//                .guardExpression("extendedState.variables.level > 0")
                .target(SUBMITTED)
                .action(submitAction(), errorAction());
//                .and
//                //	внутренне событие (не меняющее стейт) DEPLOY
//                .withInternal()
//                .source(States.BACKLOG)
//                .event(Events.DEPLOY)
//                .action(deployAction())
    }

    @Bean
    public Action<MessageStatus, MessageEvent>submitAction() {
        return new SubmitAction();
    }

    @Bean
    public Action<MessageStatus, MessageEvent> errorAction() {
        return new ErrorAction();
    }

    @Bean
    public Guard<MessageStatus, MessageEvent> checkGuard() {
        return new CheckGuard();
    }
}
