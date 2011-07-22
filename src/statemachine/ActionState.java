package statemachine;


public abstract class ActionState<Context> extends State{

    protected ActionState(String name, boolean startState) {
        super(name, startState);
    }

    protected abstract void action(Context context);

    protected abstract String  nextTransition(Context context);

    protected abstract void exitAction(Context context);

    State nextState(Context context){
        String key = nextTransition(context);
        if(transitionMap.containsKey(key)){
            exitAction(context);
            return (State) transitionMap.get(key);
        }
        else return IdleState.instance;
    }
}
