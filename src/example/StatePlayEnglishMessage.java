package example;

import statemachine.ActionState;


public class StatePlayEnglishMessage extends ActionState<IvrContext>{
    public StatePlayEnglishMessage(String name, boolean startState) {
        super(name, startState);
    }

    @Override
    protected void action(IvrContext ivrContext) {
       ivrContext.setIvrResponse(new IvrResponse("english message"));
    }

    @Override
    protected String nextTransition(IvrContext ivrContext) {
        return "finish";
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
    }
}
