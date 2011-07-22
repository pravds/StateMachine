package example;

import statemachine.Event;

public class IvrEvents {

    public static Event CHECK_USER_TYPE = new Event();
    public static Event SELECT_LANGUAGE = new Event();
    public static Event PLAY_ENGLISH_MESSAGE = new Event();
    public static Event PLAY_HINDI_MESSAGE = new Event();
    public static Event FINISH = new Event();
    public static Event UNKNOWN = new Event();
}
