package statemachine;


public abstract class DecisionState<Context> extends State{

    protected DecisionState(String name, boolean startState) {
        super(name,  startState);
    }

    protected abstract String action(Context context);

    String nextState(Context context){
        return (String) transitionMap.get(action(context));
    }
}
