package PrintNumber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for(int i = 1;i <=100; ++i){
            if(i == 80){
                System.out.println("Stop");
            }
            NumberPrinter x = new NumberPrinter(i);
//            Thread t = new Thread(x);
//            t.start();
            ex.execute(x);
        }
    }
}
