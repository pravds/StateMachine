package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekRequest;
import motek.MotekResponse;
import statemachine.Event;

public class NewUserMenuState implements MotekActionState{
    public void action(MotekContext context) {
        context.setResponse(new MotekResponse("1-Help 2-Chapter/Lesson"));
    }

    public void exitAction(MotekContext context) {
    }

    public Event nextEvent(MotekContext context) {
        MotekRequest request = context.getRequest();
        if("1".equals(request.getUserInput())) return Events.HELP_REQUESTED;
        if("2".equals(request.getUserInput())) return Events.LESSON_REQUESTED;
        return Events.UNKNOWN;
    }
}
