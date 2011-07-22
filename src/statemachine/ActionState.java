package statemachine;


public abstract class ActionState<Context> extends State{

    protected ActionState(String name) {
        super(name);
    }

    protected abstract void action(Context context);

    protected abstract void exitAction(Context context);

    protected abstract Event nextEvent(Context context);
}
