package statemachine;

public interface State<Context> {

    public static IdleState IDLE_STATE = new IdleState();
    public static EndState END_STATE = new EndState();
    abstract Event nextEvent(Context context);
}
