package statemachine;

public class IdleState extends ActionState{

    public static final String NAME = "idle";

    public IdleState() {
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
