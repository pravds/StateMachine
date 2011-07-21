package example;

import statemachine.DecisionState;


public class StateCheckUserType extends DecisionState<IvrContext>{


    public StateCheckUserType(String name, boolean startState) {
        super(name, startState);
    }

    @Override
    protected String action(IvrContext ivrContext) {
        if(newUser(ivrContext)) return "selectLanguage";
        IVRRequest request = ivrContext.getIvrRequest();
        return Data.userToLanguageMap.get(request.getNumber());
    }

    private boolean newUser(IvrContext context) {
        IVRRequest request = (IVRRequest) context.getIvrRequest();
        return !Data.userToLanguageMap.containsKey(request.getNumber());
    }
}
