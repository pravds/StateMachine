package motek.state;

import motek.MotekContext;
import motek.MotekResponse;
import statemachine.ActionState;

public class WelcomeMessage extends ActionState<MotekContext>{
    public static String USER_TYPE_SWITCH = "USER_TYPE_SWITCH";
    protected WelcomeMessage(String name) {
        super(name);
    }

    @Override
    protected void action(MotekContext context) {
       new MotekResponse("Welcome to motek mobile training");
    }

    @Override
    protected String nextTransition(MotekContext context) {
        return USER_TYPE_SWITCH;
    }

    @Override
    protected void exitAction(MotekContext context) {
    }
}
