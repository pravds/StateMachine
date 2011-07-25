package motek.service;

public class CourseService {

    private  static int lessonNumber =1;
    public String lessonToPlay(String number){
        return "Playing lesson"+lessonNumber + "" ;
    }

    public void updateCurrentLesson(String number) {
        lessonNumber++;
    }

    public boolean lastChapter() {
        return lessonNumber >= 3;  //To change body of created methods use File | Settings | File Templates.
    }
}
