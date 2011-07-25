package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekRequest;
import statemachine.Event;

public class UserTypeDecideState implements MotekDecisionState {

    public Event nextEvent(MotekContext context) {
        MotekRequest request = context.getRequest();
        if(request.getNumber().equals("9880202527")) return Events.NEW_USER;
        return Events.LESSON_REQUESTED;
    }
}
