package code.formating;

public class Main {
    public static void main(String[] args){
       String str = Loader.loadString("res/Loader.java");
       System.out.println(Formatter.format(str));
    }
}
