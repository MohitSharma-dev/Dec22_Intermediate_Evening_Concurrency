package PrintNumber;

import java.util.concurrent.Callable;

public class NumberPrinter implements Runnable {
    private int noToPrint;

    public void run(){
        System.out.println("Number : " + noToPrint + "Thread : " + Thread.currentThread().getName());
    }

    NumberPrinter (int x) {
        noToPrint = x;
    }

}
