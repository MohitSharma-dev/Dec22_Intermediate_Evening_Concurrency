package adderSubtractorSynchronizedMethod;

public class Value {
    private int value = 0;

    public synchronized void incrementBy(int x){
        this.value += x;
    }

    public synchronized void decrementBy(int x){
        this.value -= x;
    }

    public int getValue() {
        return value;
    }
}
