package motek;


import motek.state.*;
import statemachine.StateMachine;
import statemachine.Transition;
import statemachine.Transitions;

import java.util.ArrayList;
import java.util.List;

public class Driver {

     public static void main(String[] args){

         StateMachine<MotekContext> stateMachineOne = GetIvrStateMachine();
         // step call started welcome msg played
         MotekContext contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", "call"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // welcome msg played and new UserMenu given
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // help option chosen and help sent
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", "1"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // help played and lesson one sent
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // lesson one played and lesson menu played
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // lesson two selected played and lesson two sent
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", "2"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // played lesson two  and lesson menu provided
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // lesson three selected and lesson three sent
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", "2"));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // played lesson three played  and sent chapter finished
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());

         // played chapter finished and sent course finished text
         contextOne = new MotekContext();
         contextOne.setRequest(new MotekRequest("9880202527", ""));
         stateMachineOne.move(contextOne);
         System.out.println(contextOne.getResponse().getMessage());
     }

    private static StateMachine<MotekContext> GetIvrStateMachine() {
        // States
        StartState startState = new StartState();
        UserTypeDecideState userTypeDecideState = new UserTypeDecideState();
        PlayLesson playLesson = new PlayLesson();
        PlayHelpState playHelpState = new PlayHelpState();
        NewUserMenuState newUserMenuState = new NewUserMenuState();
        LessonMenuState lessonMenuState = new LessonMenuState();
        CourseFinishedState courseFinishedState = new CourseFinishedState();

        List<Transition> transitions = new ArrayList<Transition>();

        transitions.add(new Transition(startState,Events.NEW_CALL,userTypeDecideState));

        transitions.add(new Transition(userTypeDecideState,Events.NEW_USER,newUserMenuState));
        transitions.add(new Transition(userTypeDecideState,Events.LESSON_REQUESTED,playLesson));

        transitions.add(new Transition(newUserMenuState,Events.HELP_REQUESTED,playHelpState));
        transitions.add(new Transition(newUserMenuState,Events.LESSON_REQUESTED,playLesson));

        transitions.add(new Transition(playHelpState,Events.LESSON_REQUESTED,playLesson));
        transitions.add(new Transition(playLesson,Events.LESSON_MENU_REQUESTED,lessonMenuState));

        transitions.add(new Transition(lessonMenuState,Events.LESSON_REQUESTED,playLesson));
        transitions.add(new Transition(lessonMenuState,Events.COURSE_FINISHED,courseFinishedState));
        return new StateMachine<MotekContext>(startState,new Transitions(transitions));
    }


}
