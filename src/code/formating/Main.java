package code.formating;

public class Main {
    public static void main(String[] args){
       String str = Loader.loadString("src/files/HelloWorld.java");
       System.out.println(Formatter.format(str));
    }
}
