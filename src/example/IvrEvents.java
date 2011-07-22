package example;

import statemachine.Event;

public class IvrEvents {

    public static Event CHECK_USER_TYPE = new Event("Check UserType");
    public static Event SELECT_LANGUAGE = new Event("Select Language");
    public static Event PLAY_ENGLISH_MESSAGE = new Event("Play English Message");
    public static Event PLAY_HINDI_MESSAGE = new Event("Play Hindi Message");
    public static Event FINISH = new Event("Finish");
    public static Event UNKNOWN = new Event("Unknown");
}
