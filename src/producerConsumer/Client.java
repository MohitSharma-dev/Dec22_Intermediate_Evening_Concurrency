package producerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        Store store = new Store(5);
        for(int i = 1; i<=100; ++i){
            ex.execute(new Producer(store));
        }
        ExecutorService ex1 = Executors.newCachedThreadPool();
        for(int i = 1 ; i <=5; ++i){
          ex1.execute(new Consumer(store));
        }
    }

}
