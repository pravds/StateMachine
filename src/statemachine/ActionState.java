package statemachine;


public abstract class ActionState<Context> extends State{

    protected ActionState(String name, boolean startState) {
        super(name, startState);
    }

    protected abstract void action(Context context);

    protected abstract String  nextTransition(Context context);

    protected abstract void exitAction(Context context);

    String nextState(Context context){
        exitAction(context);
        return (String) transitionMap.get(nextTransition(context));
    }
}
