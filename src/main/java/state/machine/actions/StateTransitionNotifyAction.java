package state.machine.actions;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import state.machine.Events;
import state.machine.States;

@Component
public class StateTransitionNotifyAction implements Action<States, Events> {
    @Override
    public void execute(StateContext<States, Events> stateContext) {
        System.out.println("Transition to " + stateContext.getTarget().getId().name());
    }
}
