package example;


import statemachine.State;
import statemachine.StateMachine;

import java.util.HashMap;

public class Driver {

     public static void main(String[] args){
         final HashMap<String, State> stateMap = new HashMap<String, State>();

         StateWelcome welcome = new StateWelcome("welcome", true);
         StateCheckUserType userType = new StateCheckUserType("userType", false);
         StateSelectLanguage selectLanguage = new StateSelectLanguage("selectLanguage", false);
         StatePlayEnglishMessage englishMessage = new StatePlayEnglishMessage("englishMessage", false);
         StatePlayHindiMessage hindiMessage = new StatePlayHindiMessage("hindiMessage", false);

         HashMap<String, String> transitionMap = new HashMap<String, String>();
         transitionMap.put("checkUserState",userType.getName());
         welcome.setTransitionMap(transitionMap);

         transitionMap = new HashMap<String, String>();
         transitionMap.put("selectLanguage",selectLanguage.getName());
         transitionMap.put("english",englishMessage.getName());
         transitionMap.put("hindi",hindiMessage.getName());
         userType.setTransitionMap(transitionMap);

         transitionMap = new HashMap<String, String>();
         transitionMap.put("english",englishMessage.getName());
         transitionMap.put("hindi",hindiMessage.getName());
         selectLanguage.setTransitionMap(transitionMap);

         stateMap.put(welcome.getName(),welcome);
         stateMap.put(userType.getName(),userType);
         stateMap.put(selectLanguage.getName(),selectLanguage);
         stateMap.put(englishMessage.getName(),englishMessage);
         stateMap.put(hindiMessage.getName(),hindiMessage);

         StateMachine<IvrContext> stateMachine = new StateMachine<IvrContext>(stateMap);

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
