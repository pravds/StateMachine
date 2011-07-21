package sample;


public class Driver {

    public static void main(String[] args){
        Root<Bean> root = new Root<Bean>();
        root.setContext(new Bean("message"));
        root.execute(new ChildOne());
    }
}

