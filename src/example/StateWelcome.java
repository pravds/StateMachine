package example;

import statemachine.ActionState;
import statemachine.Event;

public class StateWelcome implements ActionState<IvrContext>{

    public Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.CHECK_USER_TYPE;
    }

    public void action(IvrContext ivrContext) {
        ivrContext.setIvrResponse(new IvrResponse("welcome message"));
    }

    public void exitAction(IvrContext ivrContext) {
    }
}
