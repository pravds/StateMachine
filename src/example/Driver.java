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
         IvrContext contextOne = new IvrContext();
         contextOne.setIvrRequest(new IVRRequest("9880202527", "call"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getIvrResponse().getMessage());

         contextOne.setIvrRequest(new IVRRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getIvrResponse().getMessage());

         contextOne.setIvrRequest(new IVRRequest("9880202527", "english"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getIvrResponse().getMessage());

         StateMachine<IvrContext> stateMachineTwo = GetIvrStateMachine();

         IvrContext contextTwo = new IvrContext();
         contextTwo.setIvrRequest(new IVRRequest("9880202527","call"));
         stateMachineTwo.move(contextOne);
         System.out.println(contextOne.getIvrResponse().getMessage());

         contextTwo.setIvrRequest(new IVRRequest("9880202527", ""));
         stateMachineTwo.move(contextOne);
         System.out.println(contextOne.getIvrResponse().getMessage());

     }

    private static StateMachine<IvrContext> GetIvrStateMachine() {
        // States
        StateWelcome welcome = new StateWelcome();
        StateCheckUserType checkUserType = new StateCheckUserType();
        StateSelectLanguage selectLanguage = new StateSelectLanguage();
        StatePlayEnglishMessage englishMessage = new StatePlayEnglishMessage();
        StatePlayHindiMessage hindiMessage = new StatePlayHindiMessage();

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
