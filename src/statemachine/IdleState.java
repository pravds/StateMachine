package statemachine;

public class IdleState implements ActionState{

    IdleState() {
        super();
    }

    public void action(Object o) {
    }

    public void exitAction(Object o) {
    }

    public Event nextEvent(Object o) {
        throw new RuntimeException("Unsupported operation") ;
    }
}
