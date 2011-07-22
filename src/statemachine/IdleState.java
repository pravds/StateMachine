package statemachine;

public class IdleState extends ActionState{

    IdleState() {
        super("idle");
    }

    @Override
    protected void action(Object o) {
    }

    @Override
    protected void exitAction(Object o) {
    }

    @Override
    protected Event nextEvent(Object o) {
        throw new RuntimeException("Unsupported operation") ;
    }
}
