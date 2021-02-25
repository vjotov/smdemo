package com.jotov.smdemo;

import com.jotov.smdemo.domain.MessageEvent;
import com.jotov.smdemo.domain.MessageStatus;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import static com.jotov.smdemo.domain.MessageEvent.SUBMIT;
import static com.jotov.smdemo.domain.MessageStatus.DRAFT;
import static com.jotov.smdemo.domain.MessageStatus.SUBMITTED;

@SpringBootTest
class SmdemoApplicationTests {
    private StateMachine<MessageStatus, MessageEvent> machine;

    @Autowired
    private StateMachineFactory<MessageStatus, MessageEvent> factory;

    @Before
    public void setUp() throws Exception {
        machine = factory.getStateMachine();
    }

//    @SneakyThrows
//    @Test
//    void submitMessage() {
//        StateMachineTestPlan<MessageStatus, MessageEvent> plan =
//                StateMachineTestPlanBuilder.<MessageStatus, MessageEvent>builder()
//                        .defaultAwaitTime(2)
//                        .stateMachine(machine)
//                        .step()
//                        .expectState(DRAFT)
//                        .expectStateChanged(0)
//                        .and()
//                        .step()
//                        .sendEvent(MessageEvent.SUBMIT)
//                        .expectState(SUBMITTED)
//                        .expectStateChanged(1)
//                        .and()
//                        .build();
//        plan.test();
//    }

    @Test
    public void initTest() {
        StateMachine<MessageStatus, MessageEvent> stateMachine = factory.getStateMachine();
        Assertions.assertThat(stateMachine.getState().getId())
                .isEqualTo(DRAFT);

        Assertions.assertThat(stateMachine).isNotNull();
    }

    @Test
    public void testGreenFlow() {
        StateMachine<MessageStatus, MessageEvent> stateMachine = factory.getStateMachine();
// Arrange & Act
        stateMachine.sendEvent(SUBMIT);

        // Asserts
        Assertions.assertThat(stateMachine.getState().getId())
                .isEqualTo(SUBMITTED);
    }
}
