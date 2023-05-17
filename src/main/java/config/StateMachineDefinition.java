package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import state.machine.Events;
import state.machine.States;
import state.machine.actions.StateTransitionNotifyAction;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineDefinition extends StateMachineConfigurerAdapter<States, Events> {

    @Autowired
    StateTransitionNotifyAction notifyAction;

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {

        states
                .withStates()
                .initial(States.SI)
                .states(EnumSet.allOf(States.class))
                .end(States.SF);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        transitions
                .withExternal()
                    .source(States.SI)
                    .target(States.S1)
                    .event(Events.E1)
                    .action(notifyAction)
                .and()
                .withExternal()
                    .source(States.S1)
                    .target(States.S2)
                    .event(Events.E2)
                    .action(notifyAction)
                .and()
                .withExternal()
                    .source(States.S2)
                    .target(States.SF)
                    .event(Events.END)
                    .action(notifyAction);
    }
}
