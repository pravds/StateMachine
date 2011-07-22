package statemachine;

import java.util.Map;

public abstract class State<Context> {

    String name;

    boolean startState;

    Map<String,State> transitionMap;

    protected State(String name, boolean startState) {
        this.name = name;
        this.startState = startState;
    }

    public void setTransitionMap(Map<String, State> transitionMap) {
        this.transitionMap = transitionMap;
    }

    public String getName() {
        return name;
    }

    public boolean isStartState() {
        return startState;
    }
}
