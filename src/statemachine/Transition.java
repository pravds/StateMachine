package statemachine;

public class Transition {

    private State fromState;

    private State toState;

    private Event event;

    public Transition(State fromState,Event event,State toState) {
        this.fromState = fromState;
        this.event = event;
        this.toState = toState;
    }

    public State getFromState() {
        return fromState;
    }

    public State getToState() {
        return toState;
    }

    public Event getEvent() {
        return event;
    }
}
