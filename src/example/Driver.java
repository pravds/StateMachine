package example;


import statemachine.State;
import statemachine.StateMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {

     public static void main(String[] args){
         final List<State> stateMap = new ArrayList<State>();

         // States
         StateWelcome welcome = new StateWelcome("welcome", true);
         StateCheckUserType userType = new StateCheckUserType("userType", false);
         StateSelectLanguage selectLanguage = new StateSelectLanguage("selectLanguage", false);
         StatePlayEnglishMessage englishMessage = new StatePlayEnglishMessage("englishMessage", false);
         StatePlayHindiMessage hindiMessage = new StatePlayHindiMessage("hindiMessage", false);

         //transitions
         HashMap<String, State > transitionMap = new HashMap<String, State>();

         transitionMap.put("checkUserState",userType);
         welcome.setTransitionMap(transitionMap);

         transitionMap = new HashMap<String, State>();
         transitionMap.put("selectLanguage",selectLanguage);
         transitionMap.put("english",englishMessage);
         transitionMap.put("hindi",hindiMessage);
         userType.setTransitionMap(transitionMap);

         transitionMap = new HashMap<String, State>();
         transitionMap.put("english",englishMessage);
         transitionMap.put("hindi",hindiMessage);
         selectLanguage.setTransitionMap(transitionMap);


         //state machine initialize
         stateMap.add(welcome);
         stateMap.add(userType);
         stateMap.add(selectLanguage);
         stateMap.add(englishMessage);
         stateMap.add(hindiMessage);
         StateMachine<IvrContext> stateMachine = new StateMachine<IvrContext>(stateMap);


         // steps
         IvrContext context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527","call"));
         stateMachine.setContext(context);
         stateMachine.move();
         System.out.println(stateMachine.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527",""));
         stateMachine.setContext(context);
         stateMachine.move();
         System.out.println(stateMachine.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527","english"));
         stateMachine.setContext(context);
         stateMachine.move();
         System.out.println(stateMachine.getContext().getIvrResponse().getMessage());

         StateMachine<IvrContext> newstateMachine = new StateMachine<IvrContext>(stateMap);

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527","call"));
         newstateMachine.setContext(context);
         newstateMachine.move();
         System.out.println(newstateMachine.getContext().getIvrResponse().getMessage());

         context = new IvrContext();
         context.setIvrRequest(new IVRRequest("9880202527",""));
         newstateMachine.setContext(context);
         newstateMachine.move();
         System.out.println(newstateMachine.getContext().getIvrResponse().getMessage());

     }


}
