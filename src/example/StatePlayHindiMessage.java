package example;

import statemachine.ActionState;
import statemachine.Event;


public class StatePlayHindiMessage implements ActionState<IvrContext>{

    public void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("hindi message"));
    }

    public void exitAction(IvrContext ivrContext) {
    }

    public Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.FINISH;
    }
}
