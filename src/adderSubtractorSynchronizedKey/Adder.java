package adderSubtractorSynchronizedKey;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value v;
    private Lock lock;
    Adder(Value x, Lock y){
        v = x;
        lock = y;
    }
    public Void call (){

        for(int i = 1;i <=50000; i++){
//            System.out.println("Adder got the lock : " + i);
            synchronized (v){
                this.v.value += i;
            }

//            lock.unlock();
        }

        return null;
    }
}
