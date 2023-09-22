package HelloWorldPrinter;

public class Client {
    public static void main(String[] args) {
        HelloWorldPrint x = new HelloWorldPrint();
       // x.run();
        Thread t = new Thread(x);
        t.start();
        System.out.println("MAIN FUNCTION " + Thread.currentThread().getName());
    }
}
