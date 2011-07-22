package statemachine;

import java.util.List;

public class StateMachine<Context> {

    private ActionState currentState;

    private Context context;

    List<State> states;
    private ActionState startState;
    private Transitions transitions;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public StateMachine(ActionState startSate, Transitions transitions) {
        this.startState = startSate;
        this.transitions = transitions;
    }

    private void start() {
        startState.action(context);
        currentState = startState;
    }

    public void move(){
        if(currentState == null) start();
        else next();
    }

    private void next(){
        ActionState nextActionState = nextActionState(currentState);
        if(nextActionState instanceof IdleState)return;
        currentState.exitAction(context);
        currentState = nextActionState;
        currentState.action(context);
    }

    private ActionState nextActionState(ActionState state) {
        State newState = transitions.nextState(state, state.nextEvent(context));
        while (newState instanceof DecisionState){
            newState = transitions.nextState(newState, ((DecisionState) newState).nextEvent(context));
        }
        return (ActionState) newState;
    }

}
