package statemachine;

public class Event {

    private String label;

    public Event(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
