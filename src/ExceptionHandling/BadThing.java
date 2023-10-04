package ExceptionHandling;

public class BadThing {
    public static void doBadthing(int a){
        doBadthing(a * a);
    }

    public static void main(String[] args) {
        try {
            BadThing.doBadthing(5);
        } catch (StackOverflowError err){
            System.out.println("Stack overflow");
        }

    }
}
