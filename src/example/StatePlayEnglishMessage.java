package example;

import statemachine.ActionState;
import statemachine.Event;


public class StatePlayEnglishMessage implements ActionState<IvrContext>{

    public void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("english message"));
    }

    public void exitAction(IvrContext ivrContext) {
    }

    public Event nextEvent(IvrContext ivrContext) {
        return IvrEvents.FINISH;
    }
}
