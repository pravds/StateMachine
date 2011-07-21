package example;

import statemachine.ActionState;


public class StatePlayHindiMessage extends ActionState<IvrContext>{
    public StatePlayHindiMessage(String name, boolean startState) {
        super(name, startState);
    }

    @Override
    protected void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("hindi message"));
    }

    @Override
    protected String nextTransition(IvrContext ivrContext) {
        return "finish";
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
    }
}
