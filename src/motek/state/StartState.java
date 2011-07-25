package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekResponse;
import statemachine.Event;

public class StartState implements MotekActionState{
    public void action(MotekContext context) {
       context.setResponse(new MotekResponse("Welcome to motek training course"));
    }

    public void exitAction(MotekContext context) {
    }

    public Event nextEvent(MotekContext context) {
        return Events.NEW_CALL;
    }
}
