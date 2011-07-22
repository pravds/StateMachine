package statemachine;

public abstract class State<Context> {

    public static IdleState IDLE_STATE = new IdleState();
    public static EndState END_STATE = new EndState();

    private String name;

    protected State(String name) {
        this.name = name;
    }
}
