package adderSubtractorSynchronizedKey;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value v;
    private Lock lock;
    Subtractor(Value x, Lock y){
        v = x;
        lock = y;
    }

    public Void call (){
//        lock.lock();
        for(int i = 1;i <=50000; i++){
//            System.out.println("Subtractor got the lock : " + i);
//            lock.lock();
//            synchronized (v) {
                this.v.value -= i;
//            }

//            lock.unlock();
        }
//        lock.unlock();
        return null;
    }
}
