package statemachine;

public class EndState extends ActionState{

    EndState() {
        super("endState");
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
