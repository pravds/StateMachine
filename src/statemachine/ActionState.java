package statemachine;


public interface ActionState<Context> extends State<Context>{

    public void action(Context context);

    public void exitAction(Context context);
}
