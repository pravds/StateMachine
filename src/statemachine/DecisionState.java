package statemachine;


public abstract class DecisionState<Context> extends State{

    protected DecisionState(String name) {
        super(name);
    }

    protected abstract Event nextEvent(Context context);
}
