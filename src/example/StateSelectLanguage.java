package example;


import statemachine.ActionState;
import statemachine.Event;

public class StateSelectLanguage implements ActionState<IvrContext>{
    public Event nextEvent(IvrContext ivrContext) {
        IVRRequest request = ivrContext.getIvrRequest();
        if(request.getUserInput().equals("english")) return IvrEvents.PLAY_ENGLISH_MESSAGE;
        else if(request.getUserInput().equals("hindi")) return IvrEvents.PLAY_HINDI_MESSAGE;
        return IvrEvents.UNKNOWN;
    }

    public void action(IvrContext ivrContext) {
        ivrContext.setIvrResponse(new IvrResponse("Please select your language preference"));
    }

    public void exitAction(IvrContext ivrContext) {
        IVRRequest request = ivrContext.getIvrRequest();
        SaveLanguage( request.getNumber(),request.getUserInput());
    }

    private void SaveLanguage( String number,String userInput) {
        Data.userToLanguageMap.put(number,userInput);
    }
}
