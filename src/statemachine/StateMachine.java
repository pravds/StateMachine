package statemachine;

public class StateMachine<Context> {

    private ActionState currentState;

    private ActionState startState;

    private Transitions transitions;

    public StateMachine(ActionState startSate, Transitions transitions) {
        this.startState = startSate;
        this.transitions = transitions;
    }

    private void start(Context context) {
        currentState = startState;
        currentState.action(context);
    }

    public void move(Context context){
        if(currentState == null) start(context);
        else next(context);
    }

    private void next(Context context){
        ActionState nextActionState = nextActionState(currentState,context);
        if(nextActionState instanceof IdleState)return;
        currentState.exitAction(context);
        currentState = nextActionState;
        currentState.action(context);
    }

    private ActionState nextActionState(ActionState state,Context context) {
        State newState = transitions.nextState(state, state.nextEvent(context));
        while (newState instanceof DecisionState){
            newState = transitions.nextState(newState, newState.nextEvent(context));
        }
        return (ActionState) newState;
    }

}
