package statemachine;


public abstract class DecisionState<Context> extends State{

    protected DecisionState(String name, boolean startState) {
        super(name,  startState);
    }

    protected abstract Event nextEvent(Context context);
}
