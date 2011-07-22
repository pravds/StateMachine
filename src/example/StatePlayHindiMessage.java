package example;

import statemachine.ActionState;
import statemachine.Event;


public class StatePlayHindiMessage extends ActionState<IvrContext>{
    public StatePlayHindiMessage(String name) {
        super(name);
    }

    @Override
    protected void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("hindi message"));
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
    }

    @Override
    protected Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.FINISH;
    }
}
