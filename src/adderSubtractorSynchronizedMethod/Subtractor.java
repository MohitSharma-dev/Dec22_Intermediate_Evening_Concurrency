package adderSubtractorSynchronizedMethod;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value v;
    Lock lock;
    Subtractor(Value x, Lock y){
        v = x;
        this.lock = y;
    }
    public Void call (){
        for(int i = 1;i <=50; i++){
            this.v.decrementBy(i);
        }
        return null;
    }
}
