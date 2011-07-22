package statemachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transitions  {

    private Map<State,Map<Event,State>> transitionMap = new HashMap<State, Map<Event, State>>();

    public Transitions(List<Transition> transitions) {
        for(int index=0; index< transitions.size();index++){
            Transition transition = transitions.get(index);
            if(!transitionMap.containsKey(transition.getFromState())){
                transitionMap.put(transition.getFromState(), new HashMap<Event, State>());
            }
            Map<Event, State> eventStateMap = transitionMap.get(transition.getFromState());
            eventStateMap.put(transition.getEvent(),transition.getToState());
        }
    }

    public State nextState(State currentState, Event event){
        if(transitionMap.containsKey(currentState) && transitionMap.get(currentState).containsKey(event)){
            return transitionMap.get(currentState).get(event);
        }
        return State.IDLE_STATE;
    }
}
