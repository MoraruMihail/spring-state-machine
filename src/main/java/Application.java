import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;
import state.machine.Events;
import state.machine.States;

@SpringBootApplication
@ComponentScan(basePackages = {"config", "state.machine.actions"})
public class Application implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
        stateMachine.sendEvent(Events.END);
    }
}
