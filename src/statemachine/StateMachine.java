package statemachine;

import java.util.Iterator;
import java.util.Map;

public class StateMachine<Context> {

    private ActionState currentState;

    private Context context;

    Map<String,State> stateMap;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public StateMachine(Map<String,State> stateMap) {
        this.stateMap =stateMap;
        this.stateMap.put(IdleState.NAME,new IdleState());
    }

    private void start() {
        ActionState startState = getStartState();
        startState.action(context);
        currentState = startState;
    }

    public void move(){
        if(currentState == null) start();
        else next();
    }

    private void next(){
        ActionState newState = nextActionState(currentState);
        if(newState instanceof IdleState)return;
        newState.action(context);
        currentState = newState;
    }

    private ActionState nextActionState(ActionState state) {
        String name = state.nextState(context);
        State newState = stateMap.get(name);
        while (newState instanceof DecisionState){
            String stateName = ((DecisionState)newState).nextState(context);
            newState = stateMap.get(stateName);
        }
        return (ActionState) newState;
    }

    private ActionState getStartState()  {
        Iterator<String> iterator = stateMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            State state = stateMap.get(key);
            if(state.isStartState()){
                return (ActionState) state;
            }

        }
        throw new RuntimeException("Could not find valid start state");
    }

}
