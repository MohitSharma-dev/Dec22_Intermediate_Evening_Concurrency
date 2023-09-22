package adderSubtractorSynchronizedMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Value v;
    Lock lock;

    Adder(Value x, Lock y){
        this.v = x;
        this.lock = y;
    }

    public Void call (){
        for(int i = 1;i <=50; i++){
            this.v.incrementBy(i);
        }
        return null;
    }
}
