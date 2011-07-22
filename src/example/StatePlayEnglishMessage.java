package example;

import statemachine.ActionState;
import statemachine.Event;


public class StatePlayEnglishMessage extends ActionState<IvrContext>{
    public StatePlayEnglishMessage(String name) {
        super(name);
    }

    @Override
    protected void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("english message"));
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
    }

    @Override
    protected Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.FINISH;
    }
}
