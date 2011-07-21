package sample;


public class ChildOne extends Child<Bean>{
    @Override
    public void print(Bean o) {
       System.out.println( o.message);
    }
}
