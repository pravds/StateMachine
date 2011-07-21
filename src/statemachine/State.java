package statemachine;

import java.util.Map;

public abstract class State<Context> {

    String name;

    boolean startState;

    Map<String,String> transitionMap;

    protected State(String name, boolean startState) {
        this.name = name;
        this.startState = startState;
    }

    public void setTransitionMap(Map<String, String> transitionMap) {
        this.transitionMap = transitionMap;
    }

    public String getName() {
        return name;
    }

    public boolean isStartState() {
        return startState;
    }
}
