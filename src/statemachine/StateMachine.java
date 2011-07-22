package statemachine;

import java.util.List;

public class StateMachine<Context> {

    private ActionState currentState;

    private Context context;

   List<State> states;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public StateMachine(List<State> states) {
        this.states =states;
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
        State newState = state.nextState(context);
        while (newState instanceof DecisionState){
            newState = ((DecisionState)newState).nextState(context);
        }
        return (ActionState) newState;
    }

    private ActionState getStartState()  {
        for(int index=0;index< states.size();index++){
             if(states.get(index).isStartState()){
                return (ActionState) states.get(index);
            }
        }
        throw new RuntimeException("Could not find valid start state");
    }

}
