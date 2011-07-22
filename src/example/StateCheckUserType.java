package example;

import statemachine.DecisionState;
import statemachine.Event;


public class StateCheckUserType implements DecisionState<IvrContext>{

    public Event nextEvent(IvrContext ivrContext) {
        IVRRequest request = ivrContext.getIvrRequest();
        if(newUser(ivrContext)) return IvrEvents.SELECT_LANGUAGE;
        if(Data.userToLanguageMap.get(request.getNumber()).equals("english")) return IvrEvents.PLAY_ENGLISH_MESSAGE;
        else if(Data.userToLanguageMap.get(request.getNumber()).equals("hindi")) return IvrEvents.PLAY_HINDI_MESSAGE;
        return IvrEvents.UNKNOWN;
    }

    private boolean newUser(IvrContext context) {
        IVRRequest request = context.getIvrRequest();
        return !Data.userToLanguageMap.containsKey(request.getNumber());
    }
}
