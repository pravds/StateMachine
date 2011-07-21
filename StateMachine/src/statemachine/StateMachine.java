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

    public StateMachine(String path) {
        BuildStateMap(path);
        start();
    }

    public StateMachine(Map<String,State> stateMap) {
        this.stateMap =stateMap;
    }

    public void start() {
        ActionState startState = getStartState();
        startState.action(context);
        currentState = startState;
    }

    public void next(){
        ActionState newState = nextActionState(currentState);
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

    private ActionState getStartState() {
        Iterator<String> iterator = stateMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            State state = stateMap.get(key);
            if(state.isStartState()){
                return (ActionState) state;
            }

        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private void BuildStateMap(String path) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
