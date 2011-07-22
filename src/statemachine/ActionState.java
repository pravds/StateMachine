package statemachine;


public abstract class ActionState<Context> extends State<Context>{

    protected ActionState(String name) {
        super(name);
    }

    protected abstract void action(Context context);

    protected abstract void exitAction(Context context);


}
