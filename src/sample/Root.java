package sample;


public class Root<Context> {

    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void execute(Child child){
        child.print(context);
    }
}
