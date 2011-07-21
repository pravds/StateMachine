package example;

import statemachine.ActionState;

public class StateWelcome extends ActionState<IvrContext>{

    public StateWelcome(String name, boolean startState) {
        super(name, startState);
    }

    @Override
    protected void action(IvrContext ivrContext) {
        ivrContext.setIvrResponse(new IvrResponse("welcome message"));
    }

    @Override
    protected String nextTransition(IvrContext ivrContext) {
        return "checkUserState";
    }

    @Override
    protected void exitAction(IvrContext ivrContext) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
