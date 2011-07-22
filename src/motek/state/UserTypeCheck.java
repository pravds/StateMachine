package motek.state;

import motek.MotekContext;
import statemachine.DecisionState;

import static data.Data.existingUsers;

public class UserTypeCheck extends DecisionState<MotekContext>{


    public static final String RESUME_COURSE = "RESUME_COURSE";

    protected UserTypeCheck(String name) {
        super(name);
    }

    @Override
    protected String nextTransition(MotekContext context) {
        String number = context.getRequest().getNumber();
        if(existingUsers.contains(number)) return RESUME_COURSE;
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
