package statemachine;

public class IdleState extends ActionState{

    private static final String NAME = "idle";

    public static IdleState instance = new IdleState();

    private IdleState() {
        super(NAME, false);
    }

    @Override
    protected void action(Object o) {
    }

    @Override
    protected String nextTransition(Object o) {
        return "";
    }

    @Override
    protected void exitAction(Object o) {
    }
}
