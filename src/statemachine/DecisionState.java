package statemachine;


public abstract class DecisionState<Context> extends State{

    protected DecisionState(String name, boolean startState) {
        super(name,  startState);
    }

    protected abstract String action(Context context);

    State nextState(Context context){
        return (State) transitionMap.get(action(context));
    }
}
