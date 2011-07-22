package statemachine;


public abstract class DecisionState<Context> extends State<Context>{

    protected DecisionState(String name) {
        super(name);
    }

}
