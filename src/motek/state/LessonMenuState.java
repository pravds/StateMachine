package motek.state;

import motek.Events;
import motek.MotekContext;
import motek.MotekResponse;
import motek.service.CourseService;
import statemachine.Event;

public class LessonMenuState implements MotekActionState {

    private CourseService courseService = new CourseService();
    public void action(MotekContext context) {
        if(courseService.lastChapter()) context.setResponse(new MotekResponse("Chapter Finished"));
        else context.setResponse(new MotekResponse("1- Previous Lesson 2-Next Lesson"));
    }

    public void exitAction(MotekContext context) {
        if(context.getRequest().getUserInput().equals("2"))
            courseService.updateCurrentLesson(context.getRequest().getNumber());
    }

    public Event nextEvent(MotekContext context) {
        if(courseService.lastChapter()) return Events.COURSE_FINISHED;
        return Events.LESSON_REQUESTED;
    }
}
