package HelloWorldPrinter;

public class HelloWorldPrint implements Runnable{
    public void doSomething(){
        System.out.println("DO something " + Thread.currentThread().getName());
    }

    public void run(){
        System.out.println("HELLO WORLD! " + Thread.currentThread().getName());
        doSomething();
    }
}
