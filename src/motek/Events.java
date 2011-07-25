package motek;

import statemachine.Event;

public class Events {
    public static Event NEW_CALL = new Event();
    public static Event NEW_USER = new Event();
    public static Event HELP_REQUESTED = new Event();
    public static Event LESSON_REQUESTED = new Event();
    public static Event UNKNOWN = new Event();
    public static Event LESSON_MENU_REQUESTED = new Event();
    public static Event COURSE_FINISHED = new Event();
}
