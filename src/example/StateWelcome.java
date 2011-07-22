package example;

import statemachine.ActionState;
import statemachine.Event;

public class StateWelcome extends ActionState<IvrContext>{

    public StateWelcome(String name) {
        super(name);
    }

    @Override
    protected Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.CHECK_USER_TYPE;
    }

    @Override
    protected void action(IvrContext ivrContext) {
        ivrContext.setIvrResponse(new IvrResponse("welcome message"));
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
    }
}
