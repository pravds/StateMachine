package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekResponse;
import motek.service.CourseService;
import statemachine.Event;

public class PlayLesson implements MotekActionState{

    private CourseService courseService = new CourseService();

    public void action(MotekContext context) {
        context.setResponse(new MotekResponse(courseService.lessonToPlay(context.getRequest().getNumber())));
    }

    public void exitAction(MotekContext context) {
    }

    public Event nextEvent(MotekContext context) {
        return Events.LESSON_MENU_REQUESTED;
    }
}
