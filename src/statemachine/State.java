package statemachine;

import java.util.Map;

public abstract class State<Context> {

    public static IdleState IDLE_STATE = new IdleState();
    public static EndState END_STATE = new EndState();

    private String name;

    private boolean startState;

    protected Map<String,State> transitionMap;

    protected State(String name, boolean startState) {
        this.name = name;
        this.startState = startState;
    }

    public void setTransitionMap(Map<String, State> transitionMap) {
        this.transitionMap = transitionMap;
    }

    public boolean isStartState() {
        return startState;
    }


}
