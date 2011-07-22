package example;


import statemachine.State;
import statemachine.StateMachine;
import statemachine.Transition;
import statemachine.Transitions;

import java.util.ArrayList;
import java.util.List;

public class Driver {

     public static void main(String[] args){

         StateMachine<IvrContext> stateMachineOne = GetIvrStateMachine();
         // steps
         IvrContext context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527","call"));
         stateMachineOne.setContext(context);
         stateMachineOne.move();
         System.out.println(stateMachineOne.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527", ""));
         stateMachineOne.setContext(context);
         stateMachineOne.move();
         System.out.println(stateMachineOne.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527", "english"));
         stateMachineOne.setContext(context);
         stateMachineOne.move();
         System.out.println(stateMachineOne.getContext().getIvrResponse().getMessage());

        StateMachine<IvrContext> stateMachineTwo = GetIvrStateMachine();

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527","call"));
         stateMachineTwo.setContext(context);
         stateMachineTwo.move();
         System.out.println(stateMachineTwo.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527",""));
         stateMachineTwo.setContext(context);
         stateMachineTwo.move();
         System.out.println(stateMachineTwo.getContext().getIvrResponse().getMessage());

     }

    private static StateMachine<IvrContext> GetIvrStateMachine() {
        // States
        StateWelcome welcome = new StateWelcome("welcome");
        StateCheckUserType checkUserType = new StateCheckUserType("userType");
        StateSelectLanguage selectLanguage = new StateSelectLanguage("selectLanguage");
        StatePlayEnglishMessage englishMessage = new StatePlayEnglishMessage("englishMessage");
        StatePlayHindiMessage hindiMessage = new StatePlayHindiMessage("hindiMessage");

        //transitions
        List<Transition> transitions = new ArrayList<Transition>();
        transitions.add(new Transition(welcome, IvrEvents.CHECK_USER_TYPE,checkUserType));

        transitions.add(new Transition(checkUserType, IvrEvents.SELECT_LANGUAGE,selectLanguage));
        transitions.add(new Transition(checkUserType, IvrEvents.PLAY_ENGLISH_MESSAGE,englishMessage));
        transitions.add(new Transition(checkUserType, IvrEvents.PLAY_HINDI_MESSAGE,hindiMessage));

        transitions.add(new Transition(selectLanguage, IvrEvents.PLAY_ENGLISH_MESSAGE,englishMessage));
        transitions.add(new Transition(selectLanguage, IvrEvents.PLAY_HINDI_MESSAGE,hindiMessage));

        transitions.add(new Transition(englishMessage, IvrEvents.FINISH, State.END_STATE));

        transitions.add(new Transition(hindiMessage, IvrEvents.FINISH,State.END_STATE));


        return new StateMachine<IvrContext>(welcome, new Transitions(transitions));
    }


}
