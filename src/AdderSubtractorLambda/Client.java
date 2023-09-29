package AdderSubtractorLambda;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();
//        Adder x = new Adder(v);
//        Subtractor y = new Subtractor(v);
        ExecutorService ec = Executors.newCachedThreadPool();

        Lock lock = new ReentrantLock();

        Callable<Void> adder = () -> {
            for(int i = 1;i <=50000; i++){
                lock.lock();
                v.value += i;
                lock.unlock();
            }
            return null;
        };

        Callable<Void> subtractor = () -> {
            for(int i = 1;i <=50000; i++){
                lock.lock();
                v.value -= i;
                lock.unlock();
            }
            return null;
        };

        Future<Void> adderFuture= ec.submit(adder);
        Future<Void> subtractorFuture= ec.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);
    }
}
