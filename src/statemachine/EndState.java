package statemachine;

public class EndState implements ActionState{

    public void action(Object o) {}

    public  void exitAction(Object o) {}

    public Event nextEvent(Object o) {
        throw new RuntimeException("Unsupported operation") ;
    }
}
