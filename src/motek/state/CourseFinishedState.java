package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekResponse;
import statemachine.Event;

public class CourseFinishedState implements MotekActionState{
    public void action(MotekContext context) {
        context.setResponse(new MotekResponse("Course finished, Thank you."));
    }

    public void exitAction(MotekContext context) {
    }

    public Event nextEvent(MotekContext context) {
        return Events.UNKNOWN;
    }
}
