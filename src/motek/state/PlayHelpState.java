package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekResponse;
import statemachine.Event;

public class PlayHelpState implements MotekActionState{
    public void action(MotekContext context) {
        context.setResponse(new MotekResponse("playing help"));
    }

    public void exitAction(MotekContext context) {
    }

    public Event nextEvent(MotekContext context) {
        return Events.LESSON_REQUESTED;
    }
}
